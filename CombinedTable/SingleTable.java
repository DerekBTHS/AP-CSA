public class SingleTable {
    private int numSeats;
    private int height;
    private double viewQuality;

    public SingleTable(int numSeats, int height, double viewQuality) {
        this.numSeats = numSeats;
        this.height = height;
        this.viewQuality = viewQuality;
    }

    /** Returns the number of seats at this table. The value is always greater than or equal to 4. */
    public int getNumSeats() {
        /* implementation not shown */
        return this.numSeats;    
    }
    /** Returns the height of this table in centimeters. */
    public int getHeight() {
        /* implementation not shown */
        return this.height;
    }
    /** Returns the quality of the view from this table. */
    public double getViewQuality() {
        /* implementation not shown */
        return this.viewQuality;    
    }
    /** Sets the quality of the view from this table to value . */
    public void setViewQuality(double value) {
        /* implementation not shown */
        this.viewQuality = value;
    }
    // There may be instance variables, constructors, and methods that are not shown.
}
