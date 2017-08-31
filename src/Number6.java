/**
 * Created by byhieg on 2017/8/30.
 * Mail to byhieg@gmail.com
 */
public class Number6 {

    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here

        int [] res = new int[A.length + B.length];
        int index = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        int flag = 0;
        while(index <= res.length - 1){
            if (secondIndex >= B.length){
                flag = -1;
                break;
            }
            if (firstIndex >= A.length) {
                flag = 1;
                break;
            }
            if(A[firstIndex] < B[secondIndex]){
                res[index++] = A[firstIndex++];
            }else if (A[firstIndex] > B[secondIndex]) {
                res[index++] = B[secondIndex++];
            }else{
                res[index++] = B[secondIndex++];
                res[index++] = A[firstIndex++];
            }

        }

        switch (flag) {
            case 1:
                for (int i = index;i < res.length;i++) {
                    res[i] = B[secondIndex++];
                }
                break;
            case -1:
                for (int i = index;i < res.length;i++) {
                    res[i] = A[firstIndex++];
                }
                break;
            case 0:
                return res;
        }

        return res;
    }
}
