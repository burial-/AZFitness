package in.hiphopheads.azfitness.ListAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import in.hiphopheads.azfitness.Models.UserRecord;
import in.hiphopheads.azfitness.R;
import in.hiphopheads.azfitness.Utilities.Utillity;

/**
 * Created on 7/11/14.
 */
public class HistoryListAdapter extends ArrayAdapter<UserRecord> {

    public HistoryListAdapter(Context context, List<UserRecord> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the UserRecord for the current position
        UserRecord userRecord = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.history_list_item, parent, false);
        }

        // Initialize the text views
        TextView dateView = (TextView) convertView.findViewById(R.id.history_list_date);
        TextView repView = (TextView) convertView.findViewById(R.id.history_list_reps);
        TextView hourView = (TextView) convertView.findViewById(R.id.history_list_hours);
        TextView minuteView = (TextView) convertView.findViewById(R.id.history_list_mins);
        TextView secondView = (TextView) convertView.findViewById(R.id.history_list_secs);

        // Format the date string and set it
        try {
            dateView.setText(new Utillity().formatDate(userRecord.timeStarted));
        } catch (ParseException e) {
            e.printStackTrace();
            dateView.setText(userRecord.timeStarted.toString());
        }

        // Set the reps
//        repView.setText(userRecord.reps);

        // Calculate the difference between start and end time
        long difference = userRecord.timeCompleted.getTime() - userRecord.timeStarted.getTime();
        long diffInSec = TimeUnit.MILLISECONDS.toSeconds(difference)%60;
        long diffInMin = TimeUnit.MILLISECONDS.toMinutes(difference);
        long diffInHour = TimeUnit.MILLISECONDS.toHours(difference);
        // Set the difference
        hourView.setText(diffInHour+"");
        minuteView.setText(diffInMin+"");
        secondView.setText(diffInSec+"");

        // Return the updated view
        return convertView;
    }
}
