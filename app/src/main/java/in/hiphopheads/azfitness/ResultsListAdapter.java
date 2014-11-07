package in.hiphopheads.azfitness;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import in.hiphopheads.azfitness.Models.RoutineResultList;

/**
 * Created on 7/11/14.
 */
public class ResultsListAdapter extends ArrayAdapter<RoutineResultList> {

    public ResultsListAdapter(Context context, ArrayList<RoutineResultList> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RoutineResultList routineResultList = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_routine_end_list_item, parent, false);
        }


        TextView titleView = (TextView) convertView.findViewById(R.id.frag_routine_end_title);
        TextView letterView = (TextView) convertView.findViewById(R.id.frag_routine_end_letter);
        TextView minuteView = (TextView) convertView.findViewById(R.id.frag_routine_end_minute);
        TextView secondView = (TextView) convertView.findViewById(R.id.frag_routine_end_seconds);

        letterView.setText(((routineResultList.RoutineLetter == null) ? "N/A" : routineResultList.RoutineLetter));
        titleView.setText(((routineResultList.RoutineTitle == null) ? "N/A" : routineResultList.RoutineTitle));
        minuteView.setText(String.valueOf(routineResultList.minutes));
        secondView.setText(String.valueOf(routineResultList.seconds));


        return convertView;
    }
}
