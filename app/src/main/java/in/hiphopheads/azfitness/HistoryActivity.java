package in.hiphopheads.azfitness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import in.hiphopheads.azfitness.ListAdapters.HistoryListAdapter;
import in.hiphopheads.azfitness.Models.UserRecord;


public class HistoryActivity extends Activity {

    public ListView mHistList;

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
//                String date;
//                try {
                    //date = new Utillity().formatDate(userRecords.get(i).timeStarted);
                    Intent intent = new Intent(getApplicationContext(), PreviousRoutineActivity.class);
                    intent.putExtra(PreviousRoutineActivity.ROUTINE_TIME_KEY,String.valueOf(userRecords.get(i).RoutineTimeId));
                    startActivity(intent);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                    //date = "lol no parsing";
//                }
                //Toast.makeText(getApplication(), date, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.history, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
