package afpa.ecf.physicalregatta.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import afpa.ecf.physicalregatta.android.model.Auditor;
import afpa.ecf.physicalregatta.android.model.Jury;
import afpa.ecf.physicalregatta.android.model.Regatta;
import afpa.ecf.physicalregatta.android.model.view.ListAuditorAdapter;
import afpa.ecf.physicalregatta.android.model.view.ListJuryAdapter;
import afpa.ecf.physicalregatta.android.model.view.ListRegattaAdapter;

/**
 * Created by Afpa on 28/02/2017.
 */

public class InfoActivity extends ListMenu {
    TextView txtChallenge;
    TextView txtRegatta;
    TextView txtDistance;
    TextView txtCompete;
    ListView lstJury;
    ListView lstAuditor;
    ListJuryAdapter adpJury;
    ListAuditorAdapter adpAuditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Regatta regatta = (Regatta) getIntent().getSerializableExtra("regatta");

        txtChallenge = (TextView) findViewById(R.id.txtChallenge);
        txtRegatta = (TextView) findViewById(R.id.txtRegatta);
        txtDistance = (TextView) findViewById(R.id.txtDistance);
        txtCompete = (TextView) findViewById(R.id.txtCompete);

        txtChallenge.setText(regatta.getChallengeId().getName());
        txtRegatta.setText(regatta.getName());
        txtDistance.setText(regatta.getDistance() + " M");
        txtCompete.setText(regatta.getCompeteCollection().size() + "");

        txtChallenge.setGravity(Gravity.END);
        txtRegatta.setGravity(Gravity.END);
        txtDistance.setGravity(Gravity.END);
        txtCompete.setGravity(Gravity.END);

        lstJury = (ListView) findViewById(R.id.lstJury);
        lstAuditor = (ListView) findViewById(R.id.lstAuditor);

        adpJury = new ListJuryAdapter(this, (ArrayList<Jury>)regatta.getJuryCollection());
        lstJury.setAdapter(adpJury);

        adpAuditor = new ListAuditorAdapter(this, (ArrayList<Auditor>)regatta.getAuditorCollection());
        lstAuditor.setAdapter(adpAuditor);
    }

    @Override
    void onMenuCreated(Menu menu) {
        MenuItem item = menu.findItem(R.id.itmExit);
        item.setVisible(false);
    }
}