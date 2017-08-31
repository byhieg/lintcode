import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by byhieg on 2017/8/30.
 * Mail to byhieg@gmail.com
 */
public class Number15 {

    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0){
            res.add(new ArrayList<Integer>());
            return res;
        }
        Permutation(nums, 0, res);
        return res;

    }

    public void Permutation(int[] nums, int begin, List<List<Integer>> res) {
        if (nums == null || nums.length < 1 || begin < 0 || begin > nums.length - 1) {
            return;
        }

        if (begin == nums.length - 1) {
            res.add(getList(nums));
        }else {
            for (int i = begin;i < nums.length;i++) {
                swap(nums, begin, i);
                Permutation(nums, begin + 1, res);
                swap(nums, begin, i);
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    public List<Integer> getList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i:
             nums) {
            list.add(i);
        }

        return list;
    }


}


