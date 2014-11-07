package in.hiphopheads.azfitness.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import in.hiphopheads.azfitness.ListAdapters.ResultsListAdapter;
import in.hiphopheads.azfitness.Models.RoutineResultList;
import in.hiphopheads.azfitness.Models.RoutineTime;
import in.hiphopheads.azfitness.Models.UserRecord;
import in.hiphopheads.azfitness.R;


public class RoutineEndFragment extends Fragment {

    // RoutineId we get from shared prefs
    private String RoutineId;

    // The User Record for this instance
    private UserRecord mUserRecord;

    // Views we need to change/use
    private TextView mResultText;
    private ListView mRoutineResults;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EndRoutineFragment.
     */
    public static RoutineEndFragment newInstance() {
        return new RoutineEndFragment();
    }
    public RoutineEndFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getActivity();
        SharedPreferences sharedPref = context.getSharedPreferences(
                MainFragment.PREF_PARAM_KEY, Context.MODE_PRIVATE);
        String arg = String.valueOf(sharedPref.getLong(MainFragment.PREF_PARAM_LAST_ROUTINE, 0));
        RoutineId = arg;
        mUserRecord = UserRecord.find(UserRecord.class, "ROUTINE_TIME_ID = " + arg).get(0);

        SugarContext.init(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_routine_end, container, false);
        mResultText = (TextView) rootView.findViewById(R.id.frag_routine_end_result);

        mRoutineResults = (ListView) rootView.findViewById(R.id.frag_routine_end_listview);

        Button mShowResults = (Button) rootView.findViewById(R.id.frag_routine_end_show_results);
        mShowResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayResults();
            }
        });

        return  rootView;
    }

    void displayResults()
    {
        mUserRecord.timeCompleted = new Date();
        mUserRecord.save();

        long difference = mUserRecord.timeCompleted.getTime() - mUserRecord.timeStarted.getTime();
        long diffInSec = TimeUnit.MILLISECONDS.toSeconds(difference)%60;
        long diffInMin = TimeUnit.MILLISECONDS.toMinutes(difference);
        long diffInHour = TimeUnit.MILLISECONDS.toHours(difference);
        mResultText.setText(diffInHour + " Hours, " + diffInMin +" Minutes, " + diffInSec + " Seconds");

        ArrayList<RoutineResultList> mListRoutines = new ArrayList<RoutineResultList>();
        for (RoutineTime routineTime : RoutineTime.find(RoutineTime.class, "ROUTINE_TIME_ID = " + RoutineId))
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

        ArrayAdapter arrayAdapter = new ResultsListAdapter(getActivity(), mListRoutines);
        mRoutineResults.setAdapter(arrayAdapter);
    }
}

