public class CombinedTable {
    private SingleTable t1;
    private SingleTable t2;

    public CombinedTable(SingleTable t1, SingleTable t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public boolean canSeat(int numPeople) {
        return t1.getNumSeats() + t2.getNumSeats() - 2 >= numPeople;
    }

    public double getDesirability() {
        double desirability = t1.getViewQuality() + t2.getViewQuality();
        desirability /= 2;
        if (t1.getHeight() != t2.getHeight()) {
            desirability -= 10;
        }
        return desirability;
    }
}
