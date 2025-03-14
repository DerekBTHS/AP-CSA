import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr = { {2, 1, 0},
                        {1, 3, 2},
                        {0, 0, 0},
                        { 4, 5, 6 } };
        
        System.out.println(ArrayResizer.isNonZeroRow(arr, 0));
        System.out.println(ArrayResizer.isNonZeroRow(arr, 1));
        System.out.println(ArrayResizer.isNonZeroRow(arr, 2));
        System.out.println(ArrayResizer.isNonZeroRow(arr, 3));

        int[][] smaller = ArrayResizer.resize(arr);
        System.out.print("{");
        for (int row = 0; row < smaller.length; row++) {
            System.out.print(Arrays.toString(smaller[row]));
            if (row != smaller.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
