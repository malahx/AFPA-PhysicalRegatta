package afpa.ecf.physicalregatta.android.model.view;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import afpa.ecf.physicalregatta.android.R;
import afpa.ecf.physicalregatta.android.Utils;
import afpa.ecf.physicalregatta.android.model.Compete;
import afpa.ecf.physicalregatta.android.model.Person;
import afpa.ecf.physicalregatta.android.model.Regatta;
import afpa.ecf.physicalregatta.android.model.Sailboat;

/**
 * Created by Afpa on 28/02/2017.
 */

public class ListResultAdapter extends ArrayAdapter<Compete> {

    private List<Compete> competes;

    public ListResultAdapter(Context context, ArrayList<Compete> competes) {
        super(context, 0, competes);
        this.competes = new ArrayList<>(competes);
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
        final TextView num_sail = (TextView) convertView.findViewById(R.id.txtNumsail);
        final TextView txtOwner = (TextView) convertView.findViewById(R.id.txtOwner);
        final TextView txtTime = (TextView) convertView.findViewById(R.id.txtTime);

        final Sailboat sailboat = compete.getSailboatId();
        final Person owner = sailboat.getOwnerId().getPersonId();

        num_sail.setText(compete.getSailboatId().getNumSail() + "");
        txtOwner.setText(owner.getFirstname() + " " + owner.getLastname());
        float f = compete.getRealtime() - (compete.getRegattaId().getDistance() * sailboat.getClassId().getCoef());
        txtTime.setText(Utils.time(f > 0 ? f : 0));
        txtTime.setGravity(Gravity.END);

        // Return the completed view to render on screen
        return convertView;
    }

}
