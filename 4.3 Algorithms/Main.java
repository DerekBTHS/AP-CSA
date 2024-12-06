import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.StringBuilder;

public class Main {
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("/Users/Derek/Desktop/BTHS Repos/AP CSA/4.3 Algorithms/words.text");
        int twoLetter = twoLetter();
        System.out.println(twoLetter);
        String longest = longest();
        System.out.println(longest);
        int palindromes = palindromes();
        System.out.println(palindromes);
        s.close();
    }

    public static int twoLetter() throws FileNotFoundException {
        s = new Scanner(f);
        int count = 0;
        while (s.hasNext()) {
            if (s.nextLine().length() == 2) {
                count++;
            }
        }
        return count;
    }
    
    public static String longest() throws FileNotFoundException {
        s = new Scanner(f);
        String longest = "";
        String current;
        while (s.hasNext()) {
            current = s.nextLine();
            if (current.length() > longest.length()) {
                longest = current;
            }
        }
        return longest;
    }

    public static int palindromes() throws FileNotFoundException {
        s = new Scanner(f);
        int count = 0;
        String current;
        while (s.hasNext()) {
            current = s.nextLine();
            StringBuilder reversed = new StringBuilder();
            reversed.append(current);
            reversed.reverse();
            if (current.equals(reversed.toString())) {
                count++;
                System.out.println(current);
            }
        }
        return count;
    }
}
