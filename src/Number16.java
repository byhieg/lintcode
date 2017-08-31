import sun.jvm.hotspot.debugger.win32.coff.DebugVC50SegDescEnums;
import tools.FullPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by byhieg on 2017/8/31.
 * Mail to byhieg@gmail.com
 */
public class Number16 {


    public List<List<Integer>> permuteUnique(int[]  nums) {
        // write your code here

        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> item = getList(nums);

        if (nums == null || nums.length == 0){
            res.add(new ArrayList<Integer>());
            return res;
        }
        permuteUnique(item, res, 0, item.size() - 1);
        return res;

    }
    @SuppressWarnings("unchecked")
    public void permuteUnique(ArrayList<Integer> nums,
                              List<List<Integer>> res, int s, int e) {
        if (s == e) { // s=e 则将其加入res中
            boolean flag = false; // res中是否存在tmp值的arraylist.
            for (int i = 0; i < res.size(); i++) {
                if (res.get(i).equals(nums)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                res.add((ArrayList<Integer>) nums.clone());
            }
            return;
        } else {
            for (int i = s; i < nums.size(); i++) {
                swap(nums, s, i);
                permuteUnique(nums, res, s + 1, e);
                swap(nums, s, i);
            }
        }
    }

    public void swap(ArrayList<Integer> nums, int s, int e) {
        int tmp1 = nums.get(s);
        int tmp2 = nums.get(e);
        nums.set(s, tmp2);
        nums.set(e, tmp1);
    }

    public ArrayList<Integer> getList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i:
                nums) {
            list.add(i);
        }

        return list;
    }

}
