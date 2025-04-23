public class Main {
    public static void main(String[] args) {
        String[] wordNums = {"one", "two", "three"};
        WordPairList wpl = new WordPairList(wordNums);
        wpl.print();
        System.out.println(wpl.numMatches());
        String[] phrases = { "the", "more", "the", "merrier" };
        wpl = new WordPairList(phrases);
        wpl.print();
        System.out.println(wpl.numMatches());
        String[] moreWords = { "the", "red", "fox", "the", "red" };
        wpl = new WordPairList(moreWords);
        wpl.print();
        System.out.println(wpl.numMatches());
    }
}