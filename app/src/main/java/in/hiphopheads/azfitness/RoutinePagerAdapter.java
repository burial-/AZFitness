package in.hiphopheads.azfitness;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

/**
 * Created on 13/10/14.
 */
class RoutinePagerAdapter extends FragmentPagerAdapter {

    // The length of the routine array size
    private int fitnessListSize;

    public RoutinePagerAdapter(FragmentManager fm, int fitnessListSize) {
        super(fm);
        this.fitnessListSize = fitnessListSize;
    }

    @Override
    public Fragment getItem(int position) {
        // If the position isn't in the array then we have finished and need to display the end screen
        if(position >= fitnessListSize)
        {
            return RoutineEndFragment.newInstance();
        }

        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return RoutineFragment.newInstance(position);
    }

    // Currently we pass a length var to this classes init, maybe we should change this later,
    // to a database call if we use one.
    @Override
    public int getCount() {
        return fitnessListSize + 1;
    }
}