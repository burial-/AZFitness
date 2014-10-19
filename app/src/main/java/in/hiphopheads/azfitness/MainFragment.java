package in.hiphopheads.azfitness;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Date;

/**
 * Basic fragment that sets onclick listeners for the buttons
 * Created on 13/10/14.
 */
public class MainFragment extends Fragment {

    public static final String PREF_PARAM_TIME_KEY = "pref_time_key";
    public static final String PREF_PARAM_TIME = "time";

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button startBtn = (Button) rootView.findViewById(R.id.fragment_main_startBtn);
        Button infoBtn = (Button) rootView.findViewById(R.id.fragment_main_infoBtn);
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
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void saveStartTime()
    {
        Context context = getActivity();
        SharedPreferences sharedPref = context.getSharedPreferences(
                PREF_PARAM_TIME_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong(PREF_PARAM_TIME, new Date().getTime());
        editor.commit();
    }
}