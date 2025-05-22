public class Game {
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;
    private boolean isBonus;
    /** Postcondition: All instance variables have been initialized. */
    public Game(Level one, Level two, Level three, boolean bonus) {
        levelOne = one;
        levelTwo = two;
        levelThree = three;
        isBonus = bonus;
    }
    { /* implementation not shown */ }
    /** Returns true if this game is a bonus game and returns false otherwise */
    public boolean isBonus() {
        /* implementation not shown */
        return isBonus;
    }
    /** Simulates the play of this Game (consisting of three levels) and updates all relevant
    * game data
    */
    public void play()
    { /* implementation not shown */ }
    /** Returns the score earned in the most recently played game, as described in part (a) */
    public int getScore() {
        /* to be implemented in part (a) */
        int total = 0;
        if (levelOne.goalReached()) {
            total += levelOne.getPoints();
        }
        if (levelOne.goalReached() && levelTwo.goalReached()) {
            total += levelTwo.getPoints();
        }
        if (levelOne.goalReached() && levelTwo.goalReached() && levelThree.goalReached()) {
            total += levelThree.getPoints();
        }
        if (isBonus) {
            return total * 3;
        }
        return total;
    }
    /** Simulates the play of num games and returns the highest score earned, as
    * described in part (b)
    * Precondition: num > 0
    */
    public int playManyTimes(int num) {
        /* to be implemented in part (b) */
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num; i++) {
            play();
            if (getScore() > max) {
                max = getScore();
            }
        }
        return max;
    }
    // There may be instance variables, constructors, and methods that are not shown.
}
