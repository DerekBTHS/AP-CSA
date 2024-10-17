import java.util.ArrayList;

public class GridPath {

    /** Initialized in the constructor with distinct values that never change */
    private int[][] grid;

    public GridPath (int[][] array) {
        grid = array;
    }
    
    /**
    * Returns the Location representing a neighbor of the grid element at row and col,
    * as described in part (a)
    * Preconditions: row is a valid row index and col is a valid column index in grid.
    * row and col do not specify the element in the last row and last column of grid.
    */
    
    public Location getNextLoc(int row, int col) {
        /* to be implemented in part (a) */
        if (row == grid.length - 1) {
            return new Location(row, col + 1);
        } else if (col == grid[row].length - 1) {
            return new Location(row + 1, col);
        } else if (grid[row + 1][col] < grid[row][col + 1]) {
            return new Location(row + 1, col);
        }
        return new Location(row, col + 1);
    }

    /**
    * Computes and returns the sum of all values on a path through grid, as described in
    * part (b)
    * Preconditions: row is a valid row index and col is a valid column index in grid.
    * row and col do not specify the element in the last row and last column of grid.
    */

    public int sumPath(int row, int col) {
        /* to be implemented in part (b) */
        int sum = grid[row][col];
        int currentRow = row;
        int currentCol = col;
        Location next = new Location(currentRow, currentCol);
        while (currentRow != grid.length - 1 || currentCol != grid[currentRow].length - 1) {
            next = getNextLoc(currentRow, currentCol);
            currentRow = next.getRow();
            currentCol = next.getCol();
            sum += grid[currentRow][currentCol];
        }
        return sum;
    }

    // There may be instance variables, constructors, and methods that are not shown.

}