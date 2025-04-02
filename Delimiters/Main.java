import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Delimiters d1 = new Delimiters("(", ")");
        String[] d1Tokens = { "(", "x + y", ")", " * 5" };
        ArrayList<String> d1ArrayList = d1.getDelimitersList(d1Tokens);
        System.out.println(d1ArrayList);

        Delimiters d2 = new Delimiters("<q>", "</q>");
        String[] d2Tokens = { "<q>", "yy", "</q>", "zz", "</q>"};
        ArrayList<String> d2ArrayList = d2.getDelimitersList(d2Tokens);
        System.out.println(d2ArrayList);

        Delimiters d3 = new Delimiters("<sup>", "</sup>");
        ArrayList<String> balanced = new ArrayList<String>();
        String[] balanced1 = { "<sup>", "<sup>", "</sup>", "<sup>", "</sup>", "</sup>" };
        for (String s : balanced1) {
            balanced.add(s);
        }
        System.out.println(d3.isBalanced(balanced));
        balanced.clear();
        String[] balanced2 = { "<sup>", "</sup>", "</sup>", "<sup>" };
        for (String s : balanced2) {
            balanced.add(s);
        }
        System.out.println(d3.isBalanced(balanced));
        balanced.clear();
        String[] balanced3 = { "</sup>" };
        for (String s : balanced3) {
            balanced.add(s);
        }
        System.out.println(d3.isBalanced(balanced));
        balanced.clear();
        String[] balanced4 = { "<sup>", "<sup>", "</sup>" };
        for (String s : balanced4) {
            balanced.add(s);
        }
        System.out.println(d3.isBalanced(balanced));
    }
}
