package afpa.ecf.physicalregatta.android;

import android.os.Bundle;
import android.view.Menu;

/**
 * Created by Afpa on 28/02/2017.
 */

public class ResultActivity extends ListMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    void onMenuCreated(Menu menu) {

    }
}