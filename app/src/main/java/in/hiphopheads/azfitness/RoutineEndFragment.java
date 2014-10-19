package in.hiphopheads.azfitness;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.concurrent.TimeUnit;


public class RoutineEndFragment extends Fragment {

    // Start time we get from shared prefs
    private Date mStartTime;

    // Views we need to change/use
    private TextView mResultText;

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
                in.hiphopheads.azfitness.MainFragment.PREF_PARAM_TIME_KEY, Context.MODE_PRIVATE);
        mStartTime = new Date(sharedPref.getLong(in.hiphopheads.azfitness.MainFragment.PREF_PARAM_TIME, 0));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
                //frag_routine_end_start_time
        View rootView =  inflater.inflate(R.layout.fragment_routine_end, container, false);
        mResultText = (TextView) rootView.findViewById(R.id.frag_routine_end_result);

        Button mShowResults = (Button) rootView.findViewById(R.id.frag_routine_end_show_results);
        mShowResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayResults(new Date().getTime());
            }
        });

        return  rootView;
    }

    void displayResults(long EndTime)
    {
        long difference = EndTime - mStartTime.getTime();
        long diffInSec = TimeUnit.MILLISECONDS.toSeconds(difference);
        long diffInMin = TimeUnit.MILLISECONDS.toMinutes(difference);
        long diffInHour = TimeUnit.MILLISECONDS.toHours(difference);
        mResultText.setText(diffInHour + " Hours, " + diffInMin +" Minutes, " + diffInSec + " Seconds");
    }
}
