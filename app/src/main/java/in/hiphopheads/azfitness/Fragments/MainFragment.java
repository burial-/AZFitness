package in.hiphopheads.azfitness.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.orm.SugarContext;

import java.util.Date;

import in.hiphopheads.azfitness.HistoryActivity;
import in.hiphopheads.azfitness.InfoActivity;
import in.hiphopheads.azfitness.Models.UserRecord;
import in.hiphopheads.azfitness.R;
import in.hiphopheads.azfitness.RoutineActivity;

/**
 * Basic fragment that sets onclick listeners for the buttons
 * Created on 13/10/14.
 */
public class MainFragment extends Fragment {

    public static final String PREF_PARAM_KEY = "pref_rep_key";
    public static final String PREF_PARAM_REPS = "reps";
    public static final String PREF_PARAM_LAST_ROUTINE = "last_routine";
    public static final int REP_AMOUNT = 10;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button startBtn = (Button) rootView.findViewById(R.id.fragment_main_startBtn);
        Button infoBtn = (Button) rootView.findViewById(R.id.fragment_main_infoBtn);
        Button histBtn = (Button) rootView.findViewById(R.id.fragment_main_histBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveStartTime();
                startActivity(new Intent(getActivity(), RoutineActivity.class));
            }
        });
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), InfoActivity.class));
            }
        });
        histBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), HistoryActivity.class));
//                Toast.makeText(getActivity(), "We need to create a history function", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SugarContext.init(getActivity());
    }

    void saveStartTime() {
        // The unique identifier for this instance
        long routineTimeId = new Date().getTime();
        Context context = getActivity();
        SharedPreferences sharedPref = context.getSharedPreferences(
                PREF_PARAM_KEY, Context.MODE_PRIVATE);
        String arg = String.valueOf(sharedPref.getLong(MainFragment.PREF_PARAM_LAST_ROUTINE, 0));
        try {
            UserRecord userRecord = UserRecord.find(UserRecord.class, "ROUTINE_TIME_ID = " + arg).get(0);
            userRecord.timeCompleted = new Date();
            userRecord.save();
        } catch (Exception e) {

        }
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(PREF_PARAM_REPS, REP_AMOUNT);
        editor.putLong(PREF_PARAM_LAST_ROUTINE, routineTimeId);
        editor.apply();

        UserRecord newUserRecord = new UserRecord(routineTimeId, new Date(), new Date(), sharedPref.getInt(PREF_PARAM_REPS, REP_AMOUNT));
        newUserRecord.save();
    }
}