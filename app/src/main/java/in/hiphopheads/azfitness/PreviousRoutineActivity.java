package in.hiphopheads.azfitness;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

        getRoutineTimeId();

        ListView mRoutineResults = (ListView) findViewById(R.id.previous_routine_listview);
        ArrayList<RoutineResultList> mListRoutines = new ArrayList<RoutineResultList>();
        for (RoutineTime routineTime : RoutineTime.find(RoutineTime.class, "ROUTINE_TIME_ID = " + routineTimeId))
        {
            long diff = routineTime.timeCompleted - routineTime.timeStarted;
            long Sec = TimeUnit.MILLISECONDS.toSeconds(diff)%60;
            long Min = TimeUnit.MILLISECONDS.toMinutes(diff);
            mListRoutines.add(new RoutineResultList(
                    routineTime.RoutineLetter,
                    routineTime.RoutineTitle,
                    Min,
                    Sec,
                    routineTime.RoutineTimeId
            ));
        }

        ArrayAdapter arrayAdapter = new ResultsListAdapter(this, mListRoutines);
        mRoutineResults.setAdapter(arrayAdapter);
    }

    public void getRoutineTimeId()
    {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            routineTimeId = extras.getString(ROUTINE_TIME_KEY);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.previous_routine, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
