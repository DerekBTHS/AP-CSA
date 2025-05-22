public class BoxOfCandy
{
    /** box contains at least one row and is initialized in the constructor. */
    private Candy[][] box;


    public BoxOfCandy(Candy[][] array) {
        box = array;
    }

    public void showBox() {
        for (Candy[] row : box) {
            System.out.print("[");
            for (Candy col : row) {
                if (col != null) {
                    System.out.print(col.getFlavor() + ", ");
                } else {
                    System.out.print("null, ");
                }
            }
            System.out.println("]");
        }
    }
    /**
    * Moves one piece of candy in column col, if necessary and possible, so that the box
    * element in row 0 of column col contains a piece of candy, as described in part (a).
    * Returns false if there is no piece of candy in column col and returns true otherwise.
    * Precondition: col is a valid column index in box.
    */
    public boolean moveCandyToFirstRow(int col)
    { /* to be implemented in part (a) */
        for (int i = 0; i < box.length; i++) {
            if (box[i][col] != null) {
                if (i == 0) {
                    return true;
                } else {
                    box[0][col] = box[i][col];
                    box[i][col] = null;
                    return true;
                }
            }
        }
        return false;
    }

    /**
    * Removes from box and returns a piece of candy with flavor specified by the parameter, or
    * returns null if no such piece is found, as described in part (b)
    */
    public Candy removeNextByFlavor(String flavor)
    { /* to be implemented in part (b) */
        Candy found;
        for (int row = box.length - 1; row >= 0; row--) {
            for (int col = 0; col < box[row].length; col++) {
                if (box[row][col] != null && box[row][col].getFlavor() == flavor) {
                    found = box[row][col];
                    box[row][col] = null;
                    return found;
                }
            }
        }
        return null;
    }

    // There may be instance variables, constructors, and methods that are not shown.
}