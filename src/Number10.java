import tools.FullPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byhieg on 2017/8/30.
 * Mail to byhieg@gmail.com
 */
public class Number10 {

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here


        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        order(root, list);
        if (k1 > list.get(list.size() - 1) || k2 < list.get(0) || k1 >= k2) {
            return res;
        }

        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 0 ; i < list.size();i++) {
            if (list.get(i) >= k1) {
                firstIndex = i;
                break;
            }
        }

        for (int i = list.size() - 1 ; i >= firstIndex;i-- ) {
            if (list.get(i) <= k2) {
                secondIndex = i;
                break;
            }
        }

        for (int i = firstIndex; i <= secondIndex;i++) {
            res.add(list.get(i));
        }

        return res;
    }


    public void order(TreeNode root,List<Integer> order) {
        if (root.left != null) {
            order(root.left, order);
        }
        order.add(root.val);
        if (root.right != null) {
            order(root.right, order);
        }


    }
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {

    }
}
