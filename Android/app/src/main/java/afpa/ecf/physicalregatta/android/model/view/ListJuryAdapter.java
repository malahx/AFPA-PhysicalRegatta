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
import afpa.ecf.physicalregatta.android.model.Jury;
import afpa.ecf.physicalregatta.android.model.Regatta;

/**
 * Created by Afpa on 28/02/2017.
 */

public class ListJuryAdapter extends ArrayAdapter<Jury> {

    private List<Jury> jury;

    public ListJuryAdapter(Context context, ArrayList<Jury> jury) {
        super(context, 0, jury);
        this.jury = new ArrayList<>(jury);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Jury jury = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itm_person, parent, false);
        }

        // Lookup view for data population
        final TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(jury.getPersonId().getFirstname() + " " + jury.getPersonId().getLastname());

        // Return the completed view to render on screen
        return convertView;
    }
}
