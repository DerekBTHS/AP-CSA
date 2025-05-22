import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // Test cases as shown in part a
        WordChecker a1 = new WordChecker(new ArrayList<String>(Arrays.asList("an", "band", "band", "abandon")));
        System.out.println(a1.isWordChain());
        WordChecker a2 = new WordChecker(new ArrayList<String>(Arrays.asList("to", "too", "stool", "tools")));
        System.out.println(a2.isWordChain());

        // Test cases as shown in part b
        WordChecker b = new WordChecker();
        b.listAdd("catch");
        b.listAdd("bobcat");
        b.listAdd("catchacat");
        b.listAdd("cat");
        b.listAdd("at");
        System.out.println(b.createList("cat"));
        System.out.println(b.createList("catch"));
        System.out.println(b.createList("dog"));
    }
}