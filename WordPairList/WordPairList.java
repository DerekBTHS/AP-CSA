import java.util.ArrayList;
public class WordPairList {
    /** The list of word pairs, initialized by the constructor. */
    private ArrayList<WordPair> allPairs = new ArrayList<WordPair>();

    /**
     * Constructs a WordPairList object as described in part (a).
     * Precondition: words.length >= 2
     */
    public WordPairList(String[] words) {
        /* to be implemented in part (a) */
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                allPairs.add(new WordPair(words[i], words[j]));
            }
        }
    }

    /**
     * Returns the number of matches as described in part (b).
     */
    public int numMatches() {
        /* to be implemented in part (b) */
        int count = 0;
        for (WordPair wp : allPairs) {
            if (wp.getFirst().equals(wp.getSecond())) {
                count++;
            }
        }
        return count;
    }

    public void print() {
        for (WordPair wp : allPairs) {
            System.out.println(wp.getFirst() + " " + wp.getSecond());
        }
    }
}
