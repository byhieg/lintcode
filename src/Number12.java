import java.util.Stack;

/**
 * Created by byhieg on 2017/8/30.
 * Mail to byhieg@gmail.com
 */
public class Number12 {

    public class MinStack {

        Stack<Integer> stack;
        Stack<Integer> min;
        public MinStack() {
            // do initialize if necessary

            stack = new Stack<>();
            min = new Stack<>();

        }

        public void push(int number) {
            // write your code here
            if (!min.isEmpty()) {
                int tmp = min.peek();
                if (number <= tmp) {
                    min.push(number);
                }
            }else{
                min.push(number);
            }
            stack.push(number);
        }

        public int pop() {
            // write your code here
            if (!min.isEmpty()) {
                int temp = stack.peek();
                if (temp == min.peek()) {
                    min.pop();
                }
            }
            return stack.pop();
        }

        public int min() {
            // write your code here
            return min.peek();
        }
    }
}
