package in.hiphopheads.azfitness;

import android.app.Activity;
import android.os.Bundle;

import in.hiphopheads.azfitness.Fragments.MainFragment;

// #WHY DID I USE A FRAGMENT
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setTitle(getString(R.string.main_label));
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }
    }
}
