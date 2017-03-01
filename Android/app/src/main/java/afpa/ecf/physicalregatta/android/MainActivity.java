package afpa.ecf.physicalregatta.android;

import android.os.Bundle;
import android.view.Gravity;
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

    TextView txtChallenge;
    TextView lblDate;
    TextView lblInfo;
    ListView lstRegatta;
    ListRegattaAdapter adpRegatta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtChallenge = (TextView) findViewById(R.id.txtChallenge);
        lblDate = (TextView) findViewById(R.id.lblDate);
        lblInfo = (TextView) findViewById(R.id.lblInfo);
        lstRegatta = (ListView) findViewById(R.id.lstRegatta);

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


        if (regattas.size() == 0) {
            txtChallenge.setText(this.getString(R.string.no_challenge));
        } else {
            txtChallenge.setText(regattas.get(0).getChallengeId().getName());
            txtChallenge.setGravity(Gravity.END);

            adpRegatta = new ListRegattaAdapter(this, regattas);
            lstRegatta.setAdapter(adpRegatta);

            lstRegatta.setOnItemClickListener(new ListRegattaClicked());
        }

        lblDate.setGravity(Gravity.END);
        lblInfo.setGravity(Gravity.CENTER);
    }

    @Override
    void onMenuCreated(Menu menu) {

    }
}
