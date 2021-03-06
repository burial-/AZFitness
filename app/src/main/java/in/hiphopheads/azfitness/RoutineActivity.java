package in.hiphopheads.azfitness;

import android.app.Activity;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import in.hiphopheads.azfitness.Utilities.HardcodedRoutines;


public class RoutineActivity extends Activity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    private RoutinePagerAdapter mRoutinePagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routines);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity. We also pass the the fitness array,
        // this would latter be changed to a database call
        // or an api call depending on where data is stored.
        mRoutinePagerAdapter = new RoutinePagerAdapter(
                getFragmentManager(),
                new HardcodedRoutines(this).getRoutineListLength()
        );
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mRoutinePagerAdapter);

        getActionBar().setTitle(getString(R.string.routine_label));
    }

}
