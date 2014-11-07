package in.hiphopheads.azfitness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import in.hiphopheads.azfitness.ListAdapters.HistoryListAdapter;
import in.hiphopheads.azfitness.Models.UserRecord;


public class HistoryActivity extends Activity {

    private ListView mHistList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mHistList = (ListView) findViewById(R.id.history_listview);
        final List<UserRecord> userRecords = UserRecord.listAll(UserRecord.class);
        HistoryListAdapter historyListAdapter = new HistoryListAdapter(getApplicationContext(), userRecords);
        mHistList.setAdapter(historyListAdapter);

        mHistList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), PreviousRoutineActivity.class);
                intent.putExtra(PreviousRoutineActivity.ROUTINE_TIME_KEY, String.valueOf(userRecords.get(i).RoutineTimeId));
                startActivity(intent);
            }
        });
    }


}
