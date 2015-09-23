package random;

/**
 * Created by paulberesuita on 8/31/15.
 */
public class RotateMatrix {

    public static void main(String[] args) {

        int[][] array = {
            { 1,2,3,4 },
            { 5,6,7,8 },
            { 9,0,1,2 },
            { 3,4,5,6 }
        };

        int[][] rotated = RotateMatrix(array, 4);

        System.out.print(rotated);
    }

    public static int[][] RotateMatrix(int[][] matrix, int n) {

        int[][] ret = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = n - j - 1;
                ret[i][j] = matrix[temp][i];
            }
        }

        return ret;
    }
}
