package in.hiphopheads.azfitness.Models;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created on 7/11/14.
 */
public class UserRecord extends SugarRecord {
    public long id;
    // Unique Identifier that we store in sharedprefs for use with all other records
    public long RoutineTimeId;
    public Date timeStarted, timeCompleted;
    // Rep amount so you can change the recorded amount if required
    public int reps;

    public UserRecord() {
    }

    public UserRecord(long routineTimeId, Date timeStarted, Date timeCompleted, int reps) {
        RoutineTimeId = routineTimeId;
        this.timeStarted = timeStarted;
        this.timeCompleted = timeCompleted;
        this.reps = reps;
    }
}
