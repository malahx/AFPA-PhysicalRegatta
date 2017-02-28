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
import afpa.ecf.physicalregatta.android.model.Regatta;

/**
 * Created by Afpa on 28/02/2017.
 */

public class ListRegattaAdapter extends ArrayAdapter<Regatta> {

    private List<Regatta> regattas;

    public ListRegattaAdapter(Context context, ArrayList<Regatta> regattas) {
        super(context, 0, regattas);
        this.regattas = new ArrayList<>(regattas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Regatta regatta = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itm_regatta, parent, false);
        }

        // Lookup view for data population
        final TextView title = (TextView) convertView.findViewById(R.id.title);
        final TextView date = (TextView) convertView.findViewById(R.id.date);
        title.setText(regatta.getName());
        date.setText(regatta.getDate().toString());
        date.setGravity(Gravity.END);

        // Return the completed view to render on screen
        return convertView;
    }

    public List<Regatta> getMedias() {
        return regattas;
    }

    public Regatta getById(int id) {
        for (Regatta media: regattas) {
            if (id == media.getId()) {
                return media;
            }
        }
        return null;
    }
}
