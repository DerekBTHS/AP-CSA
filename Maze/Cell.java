public class Cell {

    /*
     * 0 = wall ⬛
     * 1 = path ⬜
     * 2 = start 🟩
     * 3 = end 🟥
     */

    private int tile;
    private boolean visited;

    public Cell() {
        this.tile = 0;
    }

    public void visit() {
        this.visited = true;
        this.tile = 1;
    }

    public void setTile(int tile) {
        this.tile = tile;
    }

    public boolean wasVisited() {
        return this.visited;
    }

    @Override
    public String toString() {
        if (this.tile == 0) {
            return "⬛";
        } else if (this.tile == 1) {
            return "⬜";
        } else if (this.tile == 2) {
            return "🟩";
        } else {
            return "🟥";
        }
    }
}
