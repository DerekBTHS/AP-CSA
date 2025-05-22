public class Textbook extends Book {
    private int edition;

    public Textbook(String bookTitle, double bookPrice, int bookEdition) {
        super(bookTitle, bookPrice);
        edition = bookEdition;
    }
    
    public String getBookInfo() {
        return super.getBookInfo() + "-" + edition;
    }

    public int getEdition() {
        return edition;
    }

    public boolean canSubstituteFor(Textbook sub) {
        if (super.getTitle() == sub.getTitle() && edition >= sub.getEdition()) {
            return true;
        }
        return false;
    }
}