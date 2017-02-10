/**
 * Created by byhieg on 17/2/18.
 * Mail to byhieg@gmail.com
 */
public class Number1 {

    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators
        int sum = a;
        while (b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }
}
