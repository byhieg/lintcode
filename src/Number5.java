import tools.FullPrint;

/**
 * Created by byhieg on 2017/8/29.
 * Mail to byhieg@gmail.com
 */
public class Number5 {

    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        int low = 0;
        int high = nums.length - 1;
        int index = partition(nums, low, high);
        while (index != k - 1) {
            if (index > k - 1){
                low = 0;
                high = index - 1;
                index = partition(nums, low, high);
            }else{
                low = index + 1;
                high = nums.length - 1;
                index = partition(nums, low, high);
            }
        }

        return nums[index];
    }

    public int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        int x = nums[low];
        while (i < j) {
            while (i < j && nums[j] <= x) j--;
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }

            while (i < j && nums[i] >= x) i++;
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }

        nums[i] = x;

        return i;
    }


    public static void main(String[] args) {
        FullPrint.printResult(new Number5().kthLargestElement(3,new int[]{9,3,2,4,8}));
    }

}
