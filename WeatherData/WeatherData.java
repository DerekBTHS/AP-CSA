import java.util.ArrayList;

public class WeatherData {
/** Guaranteed not to be null and to contain only non-null entries */
    private ArrayList<Double> temperatures;

    public WeatherData(ArrayList<Double> temps) {
        temperatures = temps;
    }

    public WeatherData() {
        temperatures = new ArrayList<Double>();
    }

    public void AddEntry(double data) {
        temperatures.add(data);
    }

    public void print() {
        System.out.println(temperatures);
    }

/**
* Cleans the data by removing from temperatures all values that are less than
* lower and all values that are greater than upper, as described in part (a)
*/  
public void cleanData(double lower, double upper) {
        /* to be implemented in part (a) */
        ArrayList<Double> newTemperatures = new ArrayList<Double>();
        for (Double temp : temperatures) {
            if (temp >= lower && temp <= upper) {
                newTemperatures.add(temp);
            }
        }
        temperatures = newTemperatures;
    }
/**
* Returns the length of the longest heat wave found in temperatures, as described in
* part (b)
* Precondition: There is at least one heat wave in temperatures based on threshold.
*/
    public int longestHeatWave(double threshold) { /* to be implemented in part (b) */
        int max = 0;
        int streak = 0;
        for (Double temp : temperatures) {
            if (temp > threshold) {
                streak++;
            } else {
                if (max < streak) {
                    max = streak;
                }
                streak = 0;
            }
        }
        return max;
    }
// There may be instance variables, constructors, and methods that are not shown.
}
