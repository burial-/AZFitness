package in.hiphopheads.azfitness.Models;

import com.orm.SugarRecord;

/**
 * Created on 7/11/14.
 */
public class RoutineTime extends SugarRecord{
    public long id;
    public long RoutineTimeId;
    public String RoutineLetter, RoutineTitle;
    public long timeStarted, timeCompleted;

    public RoutineTime() {
    }

    public RoutineTime(long routineTimeId, String routineLetter, String routineTitle, long timeCompleted, long timeStarted) {
        RoutineTimeId = routineTimeId;
        RoutineLetter = routineLetter;
        RoutineTitle = routineTitle;
        this.timeCompleted = timeCompleted;
        this.timeStarted = timeStarted;
    }
}
