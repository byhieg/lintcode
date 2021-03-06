/**
 * Created by byhieg on 2017/8/30.
 * Mail to byhieg@gmail.com
 */
public class Number13 {

    public int strStr(String source, String target) {
        // write your code here

        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }
        if(target == ""){
            return 0;
        }

        char[] ss = source.toCharArray();
        char[] ms = target.toCharArray();

        int si = 0;
        int mi = 0;

        int[] next = getNextArray(ms);
        while (si < source.length() && mi < target.length()) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            }else{
                mi = next[mi];
            }
        }

        return mi == ms.length ? si - mi : -1;
    }

    private int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++ cn;
            }else if (cn > 0){
                cn = next[cn];
            }else{
                next[pos++] = 0;
            }
        }

        return next;
    }
}
