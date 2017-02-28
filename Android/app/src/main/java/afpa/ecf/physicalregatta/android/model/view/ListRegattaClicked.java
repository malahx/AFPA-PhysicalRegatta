package afpa.ecf.physicalregatta.android.model.view;

import android.view.View;
import android.widget.AdapterView;

import afpa.ecf.physicalregatta.android.model.Regatta;

/**
 * Created by Afpa on 28/02/2017.
 */

public class ListRegattaClicked implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Regatta r = (Regatta) parent.getItemAtPosition(position);

//        Intent intent = new Intent(parent.getContext(), WebViewMedia.class);
//        Utils.fillIntentFromMedia(intent, media);
//
//
//        ((ListActivity) parent.getContext()).startActivityForResult(intent, 0);
    }
}
