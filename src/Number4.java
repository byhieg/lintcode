/**
 * Created by byhieg on 2017/8/29.
 * Mail to byhieg@gmail.com
 */
public class Number4 {

    public int nthUglyNumber(int n) {
        // write your code here
        int[] res = new int[n];
        res[0] = 1;

        int nextIndex = 1;
        int uN1 = 0;
        int uN2 = 0;
        int uN3 = 0;

        while (nextIndex < n) {
            int min = getMin(res[uN1] * 2, res[uN1] * 3, res[uN1] * 5);

            if (res[uN1] * 2 == min) {
                uN1++;
            }
            if (res[uN2] * 3 == min) {
                uN2++;
            }

            if (res[uN3] * 5 == min) {
                uN3++;
            }

            res[nextIndex++] = min;
        }

        return res[nextIndex - 1];

    }

    public int getMin(int a, int b, int c) {
        int temp = Math.min(a, b);
        return Math.min(temp, c);
    }
}
