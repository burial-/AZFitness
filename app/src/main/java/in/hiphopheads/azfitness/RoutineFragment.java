package in.hiphopheads.azfitness;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.List;

import in.hiphopheads.azfitness.Models.Routine;

/**
 * Created on 13/10/14.
 */
public class RoutineFragment extends Fragment {

    // Our routines
    List<Routine> routines;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    //This are the parts of the layout we will need to change for each item
    TextView letterTextView;
    TextView titleTextView;
    TextView descriptionTextView;
    ImageView exampleImageView;
    SliderLayout sliderShow;

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
        exampleImageView = (ImageView) rootView.findViewById(R.id.fragent_routine_imageview);

        // We now initialize the view with our routine
        initializeView();

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We get all the routines and store them in out list
        routines = new HardcodedRoutines(getActivity()).getRoutines();
    }

    public void initializeView() {
        // We convert the list to an array so we can use the position int
        // to select a certain routine
        Routine[] mRoutines = routines.toArray(new Routine[routines.size()]);
        // We get the position which was set as an argument by the PagerAdapter
        int position = getArguments().getInt(ARG_SECTION_NUMBER);

        // We set the text for the routine
        letterTextView.setText(mRoutines[position].getLetter());
        titleTextView.setText((mRoutines[position].getTitle()));
        descriptionTextView.setText((mRoutines[position].getDescription()));

        // We get the routine images
        int[] mRoutineImages = mRoutines[position].getRoutineImages();

        //TODO: decide if we should change to one or not, (usability)
        // We cycle through the int array adding the images to the slider,
        // an option we must consider is if a Routine only has one image then using a normal
        // ImageView would be more appropriate.
        if(mRoutineImages.length > 0) {
            for (int i = 0; i < mRoutineImages.length; i++) {
                // Since we will be using the slider we don't need the standard ImageView
                exampleImageView.setVisibility(View.GONE);
                // Create a new DefaultSliderView and set the image
                DefaultSliderView defaultSliderView = new DefaultSliderView(getActivity());
                defaultSliderView.image(mRoutineImages[i]);
                // Add the slider view to the slider
                sliderShow.addSlider(defaultSliderView);
            }
        } else {
            // Alternatively we don't use the slider and just use the image view as there is only
            // one image and we don't need to load a slider for that.
            sliderShow.setVisibility(View.GONE);
            exampleImageView.setImageResource(mRoutineImages[0]);
        }
        // This stops the slider from changing image automatically after a few seconds.
        sliderShow.stopAutoCycle();
    }
}