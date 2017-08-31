/**
 * Created by byhieg on 2017/8/30.
 * Mail to byhieg@gmail.com
 */
public class Number14 {

    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums.length == 0 || nums == null) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid > 0 && nums[mid - 1] == target) {
                    high = mid;
                }else{
                    return mid;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
