package in.hiphopheads.azfitness.Models;

/**
 * Created on 7/11/14.
 */
public class RoutineResultList {
    public long RoutineTimeId;
    public String RoutineLetter, RoutineTitle;
    public long minutes, seconds;

    public RoutineResultList(String routineLetter, String routineTitle, long minutes, long seconds, long RoutineTimeId) {
        RoutineLetter = routineLetter;
        RoutineTitle = routineTitle;
        this.minutes = minutes;
        this.seconds = seconds;
        this.RoutineTimeId = RoutineTimeId;
    }
}
