public class StepTracker {
    private int dailyGoal;
    private int totalSteps;
    private int totalDays;
    private int activeDays;

    public StepTracker(int dailyGoal) {
        this.dailyGoal = dailyGoal;
    }

    public void addDailySteps(int steps) {
        this.totalSteps += steps;
        this.totalDays++;
        if (steps >= this.dailyGoal) {
            this.activeDays++;
        }
    }

    public int activeDays() {
        return this.activeDays;
    }

    public double averageSteps() {
        if (this.totalDays == 0) {
            return 0.0;
        }
        return (double) this.totalSteps / this.totalDays;
    }
}
