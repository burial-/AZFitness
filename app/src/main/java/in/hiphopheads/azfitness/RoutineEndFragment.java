package in.hiphopheads.azfitness;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class RoutineEndFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_TIME = "my_time";

    private String mTime;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param myTime Parameter 1.
     * @return A new instance of fragment EndRoutineFragment.
     */
    public static RoutineEndFragment newInstance(String myTime) {
        RoutineEndFragment fragment = new RoutineEndFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_TIME, myTime);
        fragment.setArguments(args);
        return fragment;
    }
    public RoutineEndFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTime = getArguments().getString(ARG_PARAM_TIME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_routine_end, container, false);
    }

}
