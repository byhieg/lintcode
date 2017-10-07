/**
 * Created by byhieg on 2017/9/6.
 * Mail to byhieg@gmail.com
 */
public class Number28 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here

        int n = matrix.length;
        if (n < 1) return false;
        int m = matrix[0].length;
        if (m < 1) return false;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= m - 1; j++) {
                if (target == matrix[i][j]) {
                    return true;
                } else if (target < matrix[i][j]) {
                    break;
                }
            }
        }

        return false;
    }
}
