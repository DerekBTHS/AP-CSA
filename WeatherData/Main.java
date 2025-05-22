import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        WeatherData data1 = new WeatherData(new ArrayList<Double>(Arrays.asList(99.1, 142.0, 85.0, 85.1, 84.6, 94.3, 124.9, 98.0, 101.0, 102.5)));
        data1.print();
        data1.cleanData(85.0, 120.0);
        data1.print();

        WeatherData data2 = new WeatherData();
        data2.AddEntry(100.5);
        data2.AddEntry(98.5);
        data2.AddEntry(102.0);
        data2.AddEntry(103.9);
        data2.AddEntry(87.5);
        data2.AddEntry(105.2);
        data2.AddEntry(90.3);
        data2.AddEntry(94.8);
        data2.AddEntry(109.1);
        data2.AddEntry(102.1);
        data2.AddEntry(107.4);
        data2.AddEntry(93.2);
        data2.print();
        System.out.println(data2.longestHeatWave(100.5));
        System.out.println(data2.longestHeatWave(95.2));
    }
}
