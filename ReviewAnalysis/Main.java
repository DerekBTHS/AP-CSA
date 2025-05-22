public class Main {
    public static void main(String[] args) {
        Review[] reviews = new Review[5];
        reviews[0] = new Review(4, "Good! Thx");
        reviews[1] = new Review(3, "OK site");
        reviews[2] = new Review(5, "Great!");
        reviews[3] = new Review(2, "Poor! Bad.");
        reviews[4] = new Review(3, "");
        ReviewAnalysis ra = new ReviewAnalysis(reviews);
        System.out.println(ra.averageRating());
        System.out.println(ra.collectComments());
    }
}
