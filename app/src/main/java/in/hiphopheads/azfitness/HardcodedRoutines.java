package in.hiphopheads.azfitness;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import in.hiphopheads.azfitness.Models.Routine;

/**
 * TODO: Use a database, maybe get the data through JSON online or something
 * This is not good programming, this is not good at all
 * Created on 13/10/14.
 */
class HardcodedRoutines {
    // This list of routines we will use
    private List<Routine> routines = new ArrayList<Routine>();

    public HardcodedRoutines(Context mContext) {
        // Each of these creates a new routine,
        // it also creates an array of image ids which we add to the routine,
        // we then add the routine to the routines list
        int[] routineImages = {R.drawable.a1, R.drawable.b2};
        Routine routine = new Routine(
                mContext.getString(R.string.a_title),
                mContext.getString(R.string.a_desc),
                mContext.getString(R.string.a_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.a2, R.drawable.b2};
        routine = new Routine(
                mContext.getString(R.string.b_title),
                mContext.getString(R.string.b_desc),
                mContext.getString(R.string.b_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.a3};
        routine = new Routine(
                mContext.getString(R.string.c_title),
                mContext.getString(R.string.c_desc),
                mContext.getString(R.string.c_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.a4, R.drawable.b4};
        routine = new Routine(
                mContext.getString(R.string.d_title),
                mContext.getString(R.string.d_desc),
                mContext.getString(R.string.d_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.a5};
        routine = new Routine(
                mContext.getString(R.string.e_title),
                mContext.getString(R.string.e_desc),
                mContext.getString(R.string.e_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.a5};
        routine = new Routine(
                mContext.getString(R.string.f_title),
                mContext.getString(R.string.f_desc),
                mContext.getString(R.string.f_letter),
                routineImages);
        routines.add(routine);

        // We sort the list by the letter
        if (routines.size() > 0) {
            Collections.sort(routines, new Comparator() {
                @Override
                public int compare(Object o, Object o2) {
                    Routine r1 = (Routine) o;
                    Routine r2 = (Routine) o2;
                    return r1.getLetter().compareTo(r2.getLetter());
                }
            });
        }
    }

    // Basic function to get the list of routines
    public List<Routine> getRoutines() {
        return routines;
    }

    public int getRoutineListLength() {
        return routines.size();
    }
}
