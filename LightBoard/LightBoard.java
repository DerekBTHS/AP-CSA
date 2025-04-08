public class LightBoard {
    /** The lights on the board, where true represents on and false represents off.
    */
    private boolean[][] lights;

    /** Constructs a LightBoard object having numRows rows and numCols columns.
    * Precondition: numRows > 0, numCols > 0
    * Postcondition: each light has a 40% probability of being set to on.
    */
    public LightBoard(int numRows, int numCols) {
        /* to be implemented in part (a) */
        this.lights = new boolean[numRows][numCols];
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (Math.random() * 10 < 4) {
                    this.lights[r][c] = true;
                }
            }
        }
    }

    /** Evaluates a light in row index row and column index col and returns a status
    * as described in part (b).
    * Precondition: row and col are valid indexes in lights.
    */
    public boolean evaluateLight(int row, int col) 
    {
        int on = 0;
        for (int r = 0; r < this.lights.length; r++) {
            if (this.lights[r][col] == true) {
                on++;
            }
        }
        if (this.lights[row][col] == true && on % 2 == 0) {
            return false;
        } else if (this.lights[row][col] == false && on % 3 == 0) {
            return true;
        }
        return this.lights[row][col];
        /* to be implemented in part (b) */
    }

    public void showBoard() {
        for (int r = 0; r < this.lights.length; r++) {
            for (int c = 0; c < this.lights[r].length; c++) {
                System.out.print(this.lights[r][c]);
                if (this.lights[r][c] == true) {
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    // There may be additional instance variables, constructors, and methods not shown.
}