package afpa.ecf.physicalregatta.android;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import afpa.ecf.physicalregatta.android.api.RegattaProvider;
import afpa.ecf.physicalregatta.android.model.Regatta;
import afpa.ecf.physicalregatta.android.model.view.ListRegattaAdapter;
import afpa.ecf.physicalregatta.android.model.view.ListRegattaClicked;

public class MainActivity extends ListMenu {

    ListView lstRegatta;
    ListRegattaAdapter adpRegatta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Regatta> regattas = new ArrayList<>();
        RegattaProvider data = new RegattaProvider();

        data.execute();

        try {
            regattas = data.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        TextView lblChallenge = (TextView) findViewById(R.id.lblChallenge);

        if (regattas.size() == 0) {
            lblChallenge.setText(this.getString(R.string.no_challenge));
        } else {
            lblChallenge.setText(this.getString(R.string.lbl_challenge) + " " + regattas.get(0).getChallengeId().getName());
            lstRegatta = (ListView) findViewById(R.id.lstRegatta);
            adpRegatta = new ListRegattaAdapter(this, regattas);
            lstRegatta.setAdapter(adpRegatta);

            lstRegatta.setOnItemClickListener(new ListRegattaClicked());
        }
    }

    @Override
    void onMenuCreated(Menu menu) {

    }
}
