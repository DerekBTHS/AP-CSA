import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Maze {
    private int size;
    private Cell[][] grid;

    public Maze(int size) {
        this.size = size;
        this.grid = new Cell[2 * size + 1][2 * size + 1];
        for (int row = 0; row < 2 * size + 1; row++) {
            for (int col = 0; col < 2 * size + 1; col++) {
                this.grid[row][col] = new Cell();
            }
        }
    }

    /* Recursive backtracking maze generation */

    public void generateMaze() {
        int x = 2 * (int) (Math.random() * (size)) + 1;
        int y = 2 * (int) (Math.random() * (size)) + 1;

        visit(x, y);
        this.grid[1][1].setTile(2);
        this.grid[2 * size - 1][2 * size - 1].setTile(3);
    }


    public void visit(int x, int y) {
        this.grid[x][y].visit();
        String[] d = { "UP", "DOWN", "LEFT", "RIGHT" };
        List<String> directions = Arrays.asList(d);
        Collections.shuffle(directions);
        for (String move : directions) {
            if (move == "UP" && y != 1) {
                if (!this.grid[x][y - 2].wasVisited()) {
                    this.grid[x][y - 1].visit();
                    visit(x, y - 2);
                }
            } else if (move == "DOWN" && y != 2 * this.size - 1) {
                if (!this.grid[x][y + 2].wasVisited()) {
                    this.grid[x][y + 1].visit();
                    visit(x, y + 2);
                }
            } else if (move == "LEFT" && x != 1) {
                if (!this.grid[x - 2][y].wasVisited()) {
                    this.grid[x - 1][y].visit();
                    visit(x - 2, y);
                }
            } else if (move == "RIGHT" && x != 2 * this.size - 1) {
                if (!this.grid[x + 2][y].wasVisited()) {
                    this.grid[x + 1][y].visit();
                    visit(x + 2, y);
                }
            }
        }
    }

    public void showMaze() {
        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[row].length; col++) {
                System.out.print(this.grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}
