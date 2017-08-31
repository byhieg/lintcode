import tools.FullPrint;

/**
 * Created by byhieg on 2017/8/30.
 * Mail to byhieg@gmail.com
 */
public class Number8 {

    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str == null){
            return;
        }
        if(offset == 0 || String.valueOf(str).trim().equals("")){
            return ;
        }
        offset = offset % str.length;
        swap(str, 0, str.length - 1);
        swap(str, 0, offset - 1);
        swap(str,offset,str.length - 1);
    }

    public void swap(char[] str, int a, int b) {
        while (a <= b) {
            char tmp = str[a];
            str[a++] = str[b];
            str[b--] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] chars = "cppjavapy".toCharArray();
        new Number8().rotateString(chars,25);
        FullPrint.printResult(String.valueOf(chars));
    }
}
