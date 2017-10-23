/**
 * Created by byhieg on 2017/9/5.
 * Mail to byhieg@gmail.com
 */

import java.util.ArrayList;
import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger();

   // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
   // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
     // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }

public class Number22 {

    private List<Integer> res = new ArrayList<>();
    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        if (nestedList.size() == 0) {
            return res;
        }

        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                NestedInteger tmp = nestedList.get(i);
                res.add(tmp.getInteger());
            }else{
                flatten(nestedList.get(i).getList());
            }
        }
        return res;
    }
}
