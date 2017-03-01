package afpa.ecf.physicalregatta.android;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import afpa.ecf.physicalregatta.android.model.Compete;
import afpa.ecf.physicalregatta.android.model.Regatta;
import afpa.ecf.physicalregatta.android.model.Sbclass;
import afpa.ecf.physicalregatta.android.model.Serie;
import afpa.ecf.physicalregatta.android.model.view.ListResultAdapter;

/**
 * Created by Afpa on 28/02/2017.
 */

public class ResultActivity extends ListMenu {
    Regatta regatta;

    TextView txtRegatta;
    TextView lblOwner;
    TextView lblTime;
    TextView lblResult;
    Spinner spnSerie;
    Spinner spnClass;
    ListView lstResult;
    CheckBox hideNoResult;
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
        lblResult = (TextView) findViewById(R.id.lblResult);
        spnSerie = (Spinner) findViewById(R.id.spnSerie);
        spnClass = (Spinner) findViewById(R.id.spnClass);
        lstResult = (ListView) findViewById(R.id.lstResult);
        hideNoResult = (CheckBox) findViewById(R.id.chkNoResult);

        txtRegatta.setText(regatta.getName());
        txtRegatta.setGravity(Gravity.END);

        List<Serie> series = new ArrayList<>();
        List<Sbclass> sbclasss = new ArrayList<>();

        series.add(new Serie(this.getString(R.string.select_serie)));
        sbclasss.add(new Sbclass(this.getString(R.string.select_class)));

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
        spnSerie.setOnItemSelectedListener(new FilterChanged());

        adpSbclass = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sbclasss);
        spnClass.setAdapter(adpSbclass);
        spnClass.setOnItemSelectedListener(new FilterChanged());

        adpResult = new ListResultAdapter(this, (ArrayList<Compete>)competes);
        lstResult.setAdapter(adpResult);

        lblResult.setGravity(Gravity.CENTER);
        lblTime.setGravity(Gravity.END);

        hideNoResult.setOnCheckedChangeListener(new FilterChanged());

    }

    @Override
    void onMenuCreated(Menu menu) {
        MenuItem item = menu.findItem(R.id.itmExit);
        item.setTitle(this.getString(R.string.btn_return));
    }

    public Spinner getSpnSerie() {
        return spnSerie;
    }

    public Spinner getSpnClass() {
        return spnClass;
    }

    public CheckBox getHideNoResult() {
        return hideNoResult;
    }

    private class FilterChanged implements AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            adpResult.getFilter().filter("");
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            adpResult.getFilter().filter("");
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            adpResult.getFilter().filter("");
        }
    }
}