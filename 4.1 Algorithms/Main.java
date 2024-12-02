import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("/Users/Derek/Desktop/BTHS Repos/AP CSA/4.1 Algorithms/Numbers.txt");
        int odds = odds();
        System.out.println(odds + " odd numbers");
        int evens = evens();
        System.out.println(evens + " even numbers");
        int twoDigits = twoDigits();
        System.out.println(twoDigits + " two digit numbers");
        int aboveFiveHundred = aboveFiveHundred();
        System.out.println(aboveFiveHundred + " numbers above 500");
        int max = max();
        System.out.println(max + " is the largest number");
        int min = min();
        System.out.println(min + " is the smallest number");
        int sum = sum();
        System.out.println(sum + " is the sum");
        double mean = mean();
        System.out.format("%.3f", mean);
        System.out.println(" is the mean");
        int mode = mode();
        System.out.println(mode + " is the mode number");
        s.close();
    }

    public static int odds() throws FileNotFoundException {
        s = new Scanner(f);
        int odds = 0;
        while (s.hasNext()) {
            if (s.nextInt() % 2 != 0)
                odds++;
        }
        return odds;
    }
    
    public static int evens() throws FileNotFoundException {
        s = new Scanner(f);
        int evens = 0;
        while (s.hasNext()) {
            if (s.nextInt() % 2 == 0)
                evens++;
        }
        return evens;
    }
    
    public static int twoDigits() throws FileNotFoundException {
        s = new Scanner(f);
        int twoDigits = 0;
        while (s.hasNext()) {
            if (s.nextLine().length() == 2)
                twoDigits++;
        }
        return twoDigits;
    }
    
    public static int aboveFiveHundred() throws FileNotFoundException {
        s = new Scanner(f);
        int aboveFiveHundred = 0;
        while (s.hasNext()) {
            if (s.nextInt() > 500)
                aboveFiveHundred++;
        }
        return aboveFiveHundred;
    }
    
    public static int max() throws FileNotFoundException {
        s = new Scanner(f);
        int max = 0;
        int num;
        while (s.hasNext()) {
            num = s.nextInt();
            if (num > max)
                max = num;
        }
        return max;
    }
    
    public static int min() throws FileNotFoundException {
        s = new Scanner(f);
        int min = 0;
        int num;
        while (s.hasNext()) {
            num = s.nextInt();
            if (num < min)
                min = num;
        }
        return min;
    }
    
    public static int sum() throws FileNotFoundException {
        s = new Scanner(f);
        int sum = 0;
        while (s.hasNext()) {
            sum += s.nextInt();
        }
        return sum;
    }
    
    public static double mean() throws FileNotFoundException {
        s = new Scanner(f);
        int lines = 0;
        int sum = 0;
        while (s.hasNext()) {
            sum += s.nextInt();
            lines++;
        }
        return (double) sum / lines;
    }

    public static int mode() throws FileNotFoundException {
        s = new Scanner(f);
        HashMap<Integer, Integer> map = new HashMap<>();
        int mode = Integer.MIN_VALUE;
        map.put(mode, Integer.MIN_VALUE);
        int num;
        while (s.hasNext()) {
            num = s.nextInt();
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > map.get(mode)) {
                mode = num;
            }
        }
        return mode;
    }
}
