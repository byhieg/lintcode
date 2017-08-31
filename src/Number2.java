/**
 * Created by byhieg on 2017/8/28.
 * Mail to byhieg@gmail.com
 */
public class Number2 {

    public long trailingZeros(long n) {
        // write your code here
        long sum = 0;
        long tmp = n / 5;
        while (tmp != 0) {
            sum += tmp;
            tmp = tmp / 5;
        }

        return sum;
    }
}
