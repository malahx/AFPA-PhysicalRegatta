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
import afpa.ecf.physicalregatta.android.model.Auditor;
import afpa.ecf.physicalregatta.android.model.Regatta;

/**
 * Created by Afpa on 28/02/2017.
 */

public class ListAuditorAdapter extends ArrayAdapter<Auditor> {

    private List<Auditor> auditors;

    public ListAuditorAdapter(Context context, ArrayList<Auditor> auditors) {
        super(context, 0, auditors);
        this.auditors = new ArrayList<>(auditors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Auditor auditor = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itm_auditor, parent, false);
        }

        // Lookup view for data population
        final TextView title = (TextView) convertView.findViewById(R.id.title);
        final TextView committee = (TextView) convertView.findViewById(R.id.committee);

        title.setText(auditor.getPersonId().getFirstname() + " " + auditor.getPersonId().getLastname());
        committee.setText(auditor.getCommitteeId().getName());
        committee.setGravity(Gravity.END);

        // Return the completed view to render on screen
        return convertView;
    }

}
