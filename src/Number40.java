import java.util.Stack;

/**
 * Created by byhieg on 2017/10/7.
 * Mail to byhieg@gmail.com
 */
public class Number40 {

    public class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        public MyQueue() {
            // do intialization if necessary
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /*
         * @param element: An integer
         * @return: nothing
         */
        public void push(int element) {
            // write your code here

            stack1.push(element);

        }

        /*
         * @return: An integer
         */
        public int pop() {
            // write your code here
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        /*
         * @return: An integer
         */
        public int top() {
            // write your code here
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }
    }
}
