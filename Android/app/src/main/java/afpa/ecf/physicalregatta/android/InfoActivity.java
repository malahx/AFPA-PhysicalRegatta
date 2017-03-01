package afpa.ecf.physicalregatta.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import afpa.ecf.physicalregatta.android.model.Auditor;
import afpa.ecf.physicalregatta.android.model.Jury;
import afpa.ecf.physicalregatta.android.model.Regatta;
import afpa.ecf.physicalregatta.android.model.view.ListAuditorAdapter;
import afpa.ecf.physicalregatta.android.model.view.ListJuryAdapter;

/**
 * Created by Afpa on 28/02/2017.
 */

public class InfoActivity extends ListMenu {

    Regatta regatta;

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

        regatta = (Regatta) getIntent().getSerializableExtra("regatta");

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

        Button btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btnResult(v);
            }
        });
    }

    @Override
    void onMenuCreated(Menu menu) {
        MenuItem item = menu.findItem(R.id.itmExit);
        item.setTitle(this.getString(R.string.btn_return));
    }

    public void btnResult(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("regatta", regatta);
        startActivity(intent);
        finish();
    }
}