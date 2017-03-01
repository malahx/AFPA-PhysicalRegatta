package afpa.ecf.physicalregatta.android.model.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import afpa.ecf.physicalregatta.android.R;
import afpa.ecf.physicalregatta.android.ResultActivity;
import afpa.ecf.physicalregatta.android.Utils;
import afpa.ecf.physicalregatta.android.model.Compete;
import afpa.ecf.physicalregatta.android.model.Person;
import afpa.ecf.physicalregatta.android.model.Sailboat;
import afpa.ecf.physicalregatta.android.model.Sbclass;
import afpa.ecf.physicalregatta.android.model.Serie;

/**
 * Created by Afpa on 28/02/2017.
 */

public class ListResultAdapter extends ArrayAdapter<Compete> implements Filterable {

    private List<Compete> competes;
    private Filter filter;

    public ListResultAdapter(Context context, ArrayList<Compete> competes) {
        super(context, 0, competes);
        this.competes = new ArrayList<>(competes);
        this.filter = new CompeteFilter(this);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Compete compete = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itm_result, parent, false);
        }

        // Lookup view for data population
        final TextView pos = (TextView) convertView.findViewById(R.id.txtNumsail);
        final TextView txtOwner = (TextView) convertView.findViewById(R.id.txtOwner);
        final TextView txtTime = (TextView) convertView.findViewById(R.id.txtTime);

        final Sailboat sailboat = compete.getSailboatId();
        final Person owner = sailboat.getOwnerId().getPersonId();

        pos.setText(compete.getPosition() != null ? compete.getPosition().toString() : "N/A");
        txtOwner.setText(owner.getFirstname() + " " + owner.getLastname() + " (" + compete.getSailboatId().getNumSail()+ ")");
        pos.setTextColor(Color.BLACK);
        txtOwner.setTextColor(Color.BLACK);
        txtTime.setTextColor(Color.BLACK);

        if (compete.getReportId() != null) {
            pos.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            txtOwner.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            txtTime.setText(compete.getReportId().getCode());
        } else if (compete.getRealtime() == 0) {
            pos.setTextColor(Color.LTGRAY);
            txtOwner.setTextColor(Color.LTGRAY);
            txtTime.setTextColor(Color.LTGRAY);
            txtTime.setText("N/A");
        } else {
            txtTime.setText(Utils.time(compete.getCompTime()));
        }

        txtTime.setGravity(Gravity.END);

        // Return the completed view to render on screen
        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CompeteFilter(this);
        }
        return filter;
    }

    public class CompeteFilter extends Filter {

        private final ListResultAdapter adp;

        public CompeteFilter(ListResultAdapter adp) {
            this.adp = adp;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();

            List<Compete> medias = (List<Compete>)results.values;
            Collections.sort(medias, new Comparator<Compete>() {
                @Override
                public int compare(Compete o1, Compete o2) {
                    int pos = o1.getPosition() != o2.getPosition() && o1.getPosition() != null ? 0 : o1.getPosition() == null ? 1 : -1;
                    if (pos != 0) {
                        return pos;
                    }
                    return ((Float)o1.getCompTime()).compareTo(o2.getCompTime());
                }
            });

            addAll(medias);
            if (results.count == 0) {
                adp.notifyDataSetInvalidated();
            } else {
                adp.notifyDataSetChanged();
            }
        }

        @Override
        protected Filter.FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
            List<Compete> searchFiltered = new ArrayList<>();

            Serie serie = (Serie)((ResultActivity)adp.getContext()).getSpnSerie().getSelectedItem();
            Sbclass sbclass = (Sbclass)((ResultActivity)adp.getContext()).getSpnClass().getSelectedItem();

            boolean hideNoResult = ((ResultActivity)adp.getContext()).getHideNoResult().isChecked();

            if (serie.getName().equals(getContext().getString(R.string.select_serie)) && sbclass.getName().equals(getContext().getString(R.string.select_class)) && !hideNoResult) {

                // set the Original result to return
                results.count = competes.size();
                results.values = competes;
            } else {

                for (int i = 0, count = competes.size(); i < count; i++) {
                    Compete compete = competes.get(i);
                    if (hideNoResult && (compete.getPosition() == null || compete.getRealtime() == 0)) {
                        continue;
                    }

                    Sbclass currentClass = compete.getSailboatId().getClassId();
                    boolean isFiltered = (serie.getName().equals(getContext().getString(R.string.select_serie)) || serie.getId() == currentClass.getSerieId().getId()) && (sbclass.getName().equals(getContext().getString(R.string.select_class)) || sbclass.getId() == currentClass.getId());
                    if (isFiltered) {
                        searchFiltered.add(compete);
                    }
                }

                // set the Filtered result to return
                results.count = searchFiltered.size();
                results.values = searchFiltered;

            }
            return results;
        }
    }
}
