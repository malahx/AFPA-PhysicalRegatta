package afpa.ecf.physicalregatta.android;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import afpa.ecf.physicalregatta.android.model.Auditor;
import afpa.ecf.physicalregatta.android.model.Compete;
import afpa.ecf.physicalregatta.android.model.Regatta;
import afpa.ecf.physicalregatta.android.model.Sbclass;
import afpa.ecf.physicalregatta.android.model.Serie;
import afpa.ecf.physicalregatta.android.model.view.ListAuditorAdapter;
import afpa.ecf.physicalregatta.android.model.view.ListJuryAdapter;
import afpa.ecf.physicalregatta.android.model.view.ListResultAdapter;

/**
 * Created by Afpa on 28/02/2017.
 */

public class ResultActivity extends ListMenu {
    Regatta regatta;

    TextView txtRegatta;
    TextView lblOwner;
    TextView lblTime;
    Spinner spnSerie;
    Spinner spnClass;
    ListView lstResult;
    ListResultAdapter adpResult;
    ArrayAdapter<Serie> adpSerie;
    ArrayAdapter<Sbclass> adpSbclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        regatta = (Regatta) getIntent().getSerializableExtra("regatta");

        txtRegatta = (TextView) findViewById(R.id.txtRegatta);
        lblOwner = (TextView) findViewById(R.id.lblOwner);
        lblTime = (TextView) findViewById(R.id.lblTime);
        spnSerie = (Spinner) findViewById(R.id.spnSerie);
        spnClass = (Spinner) findViewById(R.id.spnClass);
        lstResult = (ListView) findViewById(R.id.lstResult);

        txtRegatta.setText(regatta.getName());
        txtRegatta.setGravity(Gravity.END);

        List<Serie> series = new ArrayList<>();
        List<Sbclass> sbclasss = new ArrayList<>();

        Collection<Compete> competes = regatta.getCompeteCollection();
        for (Compete c : competes) {
            c.setRegattaId(regatta);

            Sbclass sbclass = c.getSailboatId().getClassId();
            Serie serie = sbclass.getSerieId();
            if (!sbclasss.contains(sbclass)) {
                sbclasss.add(sbclass);
                if (!series.contains(serie)) {
                    series.add(serie);
                }
            }
        }
        adpSerie = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, series);
        spnSerie.setAdapter(adpSerie);

        adpSbclass = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sbclasss);
        spnClass.setAdapter(adpSbclass);

        adpResult = new ListResultAdapter(this, (ArrayList<Compete>)competes);
        lstResult.setAdapter(adpResult);

        lblOwner.setGravity(Gravity.CENTER);
        lblTime.setGravity(Gravity.END);

    }

    @Override
    void onMenuCreated(Menu menu) {
        MenuItem item = menu.findItem(R.id.itmExit);
        item.setVisible(false);
    }
}