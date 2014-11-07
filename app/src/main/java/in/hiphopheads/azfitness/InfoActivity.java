package in.hiphopheads.azfitness;

import android.app.Activity;
import android.os.Bundle;


public class InfoActivity extends Activity {

    /**
     * Very basic activity to display the info text, nothing happens here...
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getActionBar().setTitle(getString(R.string.info_label));
    }

}
