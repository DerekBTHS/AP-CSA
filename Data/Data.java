public class Data {
    public static final int MAX = 1000; /* value not shown */
    private int[][] grid;

    public Data(int rows, int cols) {
        grid = new int[rows][cols];
    }

    public Data(int[][] g) {
        grid = g;
    }

    /** Fills all elements of grid with randomly generated values, as described in part (a)
     * Precondition: grid is not null.
     * grid has at least one element.
     */
    public void repopulate() {
        /* to be implemented in part (a) */
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                while (grid[row][col] % 100 == 0 || grid[row][col] % 10 != 0) {
                    grid[row][col] = (int) (Math.random() * MAX) + 1;
                }
            }
        }
    }

    /** Returns the number of columns in grid that are in increasing order, as described
     * in part (b)
     * Precondition: grid is not null.
     * grid has at least one element.
     */
    public int countIncreasingCols() {
        /* to be implemented in part (b) */
        int count = 0;
        boolean ascending = true;
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length - 1; row++) {
                if (grid[row][col] > grid[row + 1][col]) {
                    ascending = false;
                    break;
                }
            }
            if (ascending) {
                count++;
            } else {
                ascending = true;
            }
        }
        return count;
    }

    public void printData() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
    // There may be instance variables, constructors, and methods that are not shown.
}