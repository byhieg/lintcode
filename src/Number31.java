/**
 * Created by byhieg on 2017/9/7.
 * Mail to byhieg@gmail.com
 */
public class Number31 {

    public int partitionArray(int[] nums, int k) {
        // write your code here

        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int low = 0;
        int high = length - 1;
        int index = partitionArray(nums, low, high);
        int count = 0;
        while (nums[index] != k) {
            System.out.println("index : " + index);
            if (nums[index] < k) {
                low = index + 1;
            }else{
                high = index - 1;
            }

            index = partitionArray(nums, low, high);
            if(index <= 0 || index >= length){
                break;
            }
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] < k) {
                res++;
            }
        }

        return res;
    }

    public int partitionArray(int[] nums, int low, int high) {
        if(low >= high){
            return low;
        }
        int i = low;
        int j = high;
        int x = nums[i];

        while (i < j) {
            while (i < j && nums[j] >= x) j--;
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }

            while (i < j && nums[i] <= x) i++;
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }

        nums[i] = x;

        return i;
    }
}
