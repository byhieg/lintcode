/**
 * Created by byhieg on 2017/8/29.
 * Mail to byhieg@gmail.com
 */
public class Number3 {

    public int digitCounts(int k, int n) {
        // write your code here
        int res = 0;
        for (int i = 0; i <= n; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if ((str.charAt(j) + "").equals(String.valueOf(k))) {
                    res++;
                }
            }
        }

        return res;
    }
}
