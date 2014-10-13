package in.hiphopheads.azfitness.Models;

/**
 * Created on 13/10/14.
 */
public class Routine {
    String letter;
    String title;
    String description;
    int[] routineImages;

    public Routine() {
    }

    public Routine(String title, String description, String letter, int[] RoutineImages) {
        this.title = title;
        this.description = description;
        this.letter = letter;
        this.routineImages = RoutineImages;
    }

    public String getLetter() {
        return letter;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int[] getRoutineImages() {
        return routineImages;
    }
}
