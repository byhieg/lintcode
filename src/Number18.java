import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by byhieg on 2017/9/5.
 * Mail to byhieg@gmail.com
 */
public class Number18 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(res, temp, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
        if (!isIn(res, temp)) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = j; i < nums.length; i++) {
            temp.add(nums[i]);  //① 加入 nums[i]
            dfs(res, temp, nums, i + 1);  //② 递归
            temp.remove(temp.size() - 1);  //③ 移除 nums[i]
        }
    }

    private boolean isIn(List<List<Integer>> res, List<Integer> temp) {
        for (int i = 0 ; i < res.size();i++) {
            if (temp.equals(res.get(i))) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new Number18().subsetsWithDup(new int[]{1, 2, 2}));
        int i = 1;
    }
}
