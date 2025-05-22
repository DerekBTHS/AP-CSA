import java.util.ArrayList;

public class ReviewAnalysis {
    /** All user reviews to be included in analysis */
    private Review[] allReviews;

    /** Initializes allReviews to contain Review objects to be analyzed */
    public ReviewAnalysis(Review[] reviews) {
        allReviews = reviews;
    }

    /** Returns a double representing the average rating of all Review objects to be
     * analyzed, as described in part (a) 
     * Precondition: allReviews contains at least one Review
     *            No elements of allReviews are null
     */
    public double averageRating() {
        double sum = 0.0;
        for (Review r : allReviews) {
            sum += r.getRating();
        }
        return sum / allReviews.length;
    }

    /** Returns an ArrayList of String objects containing formatted versions of
     * select user comments, as described in part (b)
     * Precondition: allReviews contains at least one Review
     *          No elements of allReviews are null
     * Postcondition: allReviews is unchanged
     */
    public ArrayList<String> collectComments() {
        ArrayList<String> comments = new ArrayList<String>();
        for (int i = 0; i < allReviews.length; i++) {
            if (allReviews[i].getComment().contains("!")) {
                if (allReviews[i].getComment().endsWith(".") || allReviews[i].getComment().endsWith("!")) {
                    comments.add(i + "-" + allReviews[i].getComment());
                } else {
                    comments.add(i + "-" + allReviews[i].getComment() + ".");
                }
            }
        }
        return comments;
    }
}