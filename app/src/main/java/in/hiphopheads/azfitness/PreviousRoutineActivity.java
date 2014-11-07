package in.hiphopheads.azfitness;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import in.hiphopheads.azfitness.ListAdapters.ResultsListAdapter;
import in.hiphopheads.azfitness.Models.RoutineResultList;
import in.hiphopheads.azfitness.Models.RoutineTime;


public class PreviousRoutineActivity extends Activity {

    // The routine id used for finding all exercises for that routine
    private String routineTimeId;

    // Key used to pass routineTimeId through activities
    public static final String ROUTINE_TIME_KEY = "routine_time_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_routine);

        // We need the routine id
        getRoutineTimeId();

        // Initialize the list and array
        ListView mRoutineResults = (ListView) findViewById(R.id.previous_routine_listview);
        ArrayList<RoutineResultList> mListRoutines = new ArrayList<RoutineResultList>();

        // Iterate through the routines for this user record
        for (RoutineTime routineTime : RoutineTime.find(RoutineTime.class, "ROUTINE_TIME_ID = " + routineTimeId)) {

            // Calculate the times
            long diff = routineTime.timeCompleted - routineTime.timeStarted;
            long Sec = TimeUnit.MILLISECONDS.toSeconds(diff) % 60;
            long Min = TimeUnit.MILLISECONDS.toMinutes(diff);

            // Add routines to the routine list to be displayed
            mListRoutines.add(new RoutineResultList(
                    routineTime.RoutineLetter,
                    routineTime.RoutineTitle,
                    Min,
                    Sec,
                    routineTime.RoutineTimeId
            ));
        }

        // Create a new array adapter and pass the routines to it
        ArrayAdapter arrayAdapter = new ResultsListAdapter(this, mListRoutines);

        // Attach the adapter to the list view
        mRoutineResults.setAdapter(arrayAdapter);
    }

    // Get the routine id from the intent
    void getRoutineTimeId() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            routineTimeId = extras.getString(ROUTINE_TIME_KEY);
        }
    }

}
