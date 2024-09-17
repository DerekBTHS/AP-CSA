public class Feeder {

    /**
     * The amount of food, in grams, currently in the bird feeder; initialized
     * in the constructor and always greater than or equal to zero
     */
    private int currentFood;

    public Feeder(int c) {
        currentFood = c;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    /**
     * Simulates one day with numBirds birds or possibly a bear at the bird
     * feeder, as described in part (a) Precondition: numBirds > 0
     */
    public void simulateOneDay(int numBirds) {
        if (Math.floor(Math.random() * 100) <= 95) {
            // 95% chance conditions will be normal
            double gramsEatenPerBird = Math.floor(Math.random() * 40 + 10);
            currentFood -= gramsEatenPerBird * numBirds;
            if (currentFood < 0) {
                currentFood = 0;
            }
        } else {
            // 5% chance all food will be eaten
            currentFood = 0;
        }
    }

    /**
     * Returns the number of days birds or a bear found food to eat at the
     * feeder in this simulation, as described in part (b) Preconditions:
     * numBirds > 0, numDays > 0
     */
    public int simulateManyDays(int numBirds, int numDays) {
        int daysPassed = 0;
        // While theres food and the days passed are less than the number of days
        while (currentFood > 0 && daysPassed < numDays) {
            simulateOneDay(numBirds);
            daysPassed++;
        }
        return daysPassed;
    }
}
