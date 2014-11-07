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
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.orm.SugarContext;

import java.util.Date;
import java.util.List;

import in.hiphopheads.azfitness.Models.Routine;
import in.hiphopheads.azfitness.Models.RoutineTime;

/**
 * Created on 13/10/14.
 */
public class RoutineFragment extends Fragment {

    // Our routines
    private List<Routine> routines;
    private Routine routine;

    private boolean hasStarted = false;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    //This are the parts of the layout we will need to change for each item
    private TextView letterTextView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private SliderLayout sliderShow;
    private Button startButton, endButton;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static RoutineFragment newInstance(int sectionNumber) {
        RoutineFragment fragment = new RoutineFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public RoutineFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_routines, container, false);
        letterTextView = (TextView) rootView.findViewById(R.id.fragent_routine_letter);
        titleTextView = (TextView) rootView.findViewById(R.id.fragent_routine_title);
        descriptionTextView = (TextView) rootView.findViewById(R.id.fragent_routine_description);
        sliderShow = (SliderLayout) rootView.findViewById(R.id.fragment_routine_slider);
        startButton = (Button) rootView.findViewById(R.id.frag_routine_start_btn);
        endButton = (Button) rootView.findViewById(R.id.frag_routine_end_btn);

        // We now initialize the view with our routine
        initializeView();

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We get all the routines and store them in out list
        routines = new HardcodedRoutines(getActivity()).getRoutines();
        SugarContext.init(getActivity());
    }

    void initializeView() {
        // We convert the list to an array so we can use the position int
        // to select a certain routine
        Routine[] mRoutines = routines.toArray(new Routine[routines.size()]);
        // We get the position which was set as an argument by the PagerAdapter
        int position = getArguments().getInt(ARG_SECTION_NUMBER);
        routine = mRoutines[position];

        // We set the text for the routine
        letterTextView.setText(routine.getLetter());
        titleTextView.setText(routine.getTitle());
        descriptionTextView.setText(routine.getDescription());

        // We get the routine images
        int[] mRoutineImages = routine.getRoutineImages();

        // We cycle through the int array adding the images to the slider,
        // an option we must consider is if a Routine only has one image then using a normal
        // ImageView would be more appropriate.
        for (int mRoutineImage : mRoutineImages) {
            // Create a new DefaultSliderView and set the image
            DefaultSliderView defaultSliderView = new DefaultSliderView(getActivity());
            defaultSliderView.image(mRoutineImage);
            defaultSliderView.setScaleType(BaseSliderView.ScaleType.FitCenterCrop);
            // Add the slider view to the slider
            sliderShow.addSlider(defaultSliderView);
        }
        // This stops the slider from changing image automatically after a few seconds.
        sliderShow.stopAutoCycle();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the timer has started we don't want to start it again
                if (!hasStarted) {
                    hasStarted = true;
                    startRoutine();
                } else {
                    Toast.makeText(getActivity(), "You've already started the routine", Toast.LENGTH_SHORT).show();
                }
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // We can't record the end time unless the timer has started
                if (hasStarted) {
                    endRoutine();
                } else {
                    Toast.makeText(getActivity(), "You've got to start the routine first!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void startRoutine() {
        // Get the RoutineTimeId for this instance from shared prefs
        SharedPreferences sharedPref = getActivity().getSharedPreferences(
                MainFragment.PREF_PARAM_KEY, Context.MODE_PRIVATE);
        long RoutineTimeId = sharedPref.getLong(MainFragment.PREF_PARAM_LAST_ROUTINE, 0);

        // Create a new routine time for this instance
        RoutineTime routineTime = new RoutineTime(
                RoutineTimeId,
                routine.getLetter(),
                routine.getTitle(),
                new Date().getTime(),
                new Date().getTime()
        );
        routineTime.save();
    }

    void endRoutine() {
        // We find the routine time we started and set the end date to now
        SharedPreferences sharedPref = getActivity().getSharedPreferences(
                MainFragment.PREF_PARAM_KEY, Context.MODE_PRIVATE);
        String[] args = {String.valueOf(sharedPref.getLong(MainFragment.PREF_PARAM_LAST_ROUTINE, 0))};
        RoutineTime routineTime = RoutineTime.find(RoutineTime.class, "ROUTINE_TIME_ID = " + args[0] + " AND ROUTINE_LETTER = '" + routine.getLetter() + "'").get(0);
        routineTime.timeCompleted = new Date().getTime();
        routineTime.save();
    }
}