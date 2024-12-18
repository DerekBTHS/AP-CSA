public class Level {
    private boolean goalReached;
    private int points;

    public Level(boolean r, int p) {
        goalReached = r;
        points = p;
    }

    /** Returns true if player has reached the goal on this level and returns false otherwise */
    public boolean goalReached() {
        /* implementation not shown */
        return goalReached;
    }
    /** Returns the number of points (a positive integer) recorded for this level */
    public int getPoints() {
        /* implementation not shown */
        return points;
    }
    // There may be instance variables, constructors, and methods that are not shown.
}
