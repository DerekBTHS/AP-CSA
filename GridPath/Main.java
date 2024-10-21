public class Main {
    public static void main(String[] args) {
        // test cases as shown in part(a)
        int[][] matrix1 = {{12, 3, 4, 13, 5},
                        {11 ,21, 2, 14, 16},
                        {7, 8, 9, 15, 0},
                        {10, 17, 20, 19, 1},
                        { 18, 22, 30, 25, 6 }};
        
        GridPath grid1 = new GridPath(matrix1);
        System.out.println(grid1);
        Location next = grid1.getNextLoc(0, 0);
        System.out.println("(" + next.getRow() + ", " + next.getCol() + ")");
        next = grid1.getNextLoc(1, 3);
        System.out.println("(" + next.getRow() + ", " + next.getCol() + ")");
        next = grid1.getNextLoc(2, 4);
        System.out.println("(" + next.getRow() + ", " + next.getCol() + ")");
        next = grid1.getNextLoc(4, 3);
        System.out.println("(" + next.getRow() + ", " + next.getCol() + ")");
        System.out.println();

        // test cases as shown in part(b)
        int[][] matrix2 = { {12, 30, 40, 25, 5},
                            {11 ,3, 22, 15, 43},
                            {7, 2, 9, 4, 0},
                            {8, 33, 18, 6, 1}};
        GridPath grid2 = new GridPath(matrix2);
        System.out.println(grid2);
        System.out.println(grid2.sumPath(1, 1));
    }
}