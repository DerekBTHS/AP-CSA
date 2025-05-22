public class Main {
    public static void main(String[] args) {
        Data data = new Data(3, 3);
        data.repopulate();
        data.printData();

        int[][] grid1 = {
            {10, 50, 40},
            {20, 40, 20},
            {30, 50, 30}
        };
        Data data2 = new Data(grid1);
        System.out.println(data2.countIncreasingCols());

        int[][] grid2 = {
            {10, 540, 440, 440},
            {220, 450, 440, 190}
        };
        Data data3 = new Data(grid2);
        System.out.println(data3.countIncreasingCols());
    }
}