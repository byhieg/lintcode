import java.util.Stack;

/**
 * Created by byhieg on 2017/10/23.
 * Mail to byhieg@gmail.com
 */
public class Number227 {

    public class Tower {
        private Stack<Integer> disks;
        /*
        * @param i: An integer from 0 to 2
        */
        public Tower(int i) {
            // create three towers
            disks = new Stack<>();
        }

        /*
         * @param d: An integer
         * @return: nothing
         */
        public void add(int d) {
            // Add a disk into this tower
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error placing disk " + d);
            } else {
                disks.push(d);
            }
        }

        /*
         * @param t: a tower
         * @return: nothing
         */
        public void moveTopTo(Tower t) {
            // Move the top disk of this tower to the top of t.
            if (t.disks.isEmpty() || (!disks.isEmpty() && disks.peek() < t.disks.peek())) {
                t.disks.push(disks.pop());
            }
        }

        /*
         * @param n: An integer
         * @param destination: a tower
         * @param buffer: a tower
         * @return: nothing
         */
        public void moveDisks(int n, Tower destination, Tower buffer) {
            // Move n Disks from this tower to destination by buffer tower
            if (n <= 0) {
                return;
            }else if (n == 1) {
                moveTopTo(destination);
            }else{
                moveDisks(n - 1,buffer,destination);
                moveDisks(1,destination,buffer);
                buffer.moveDisks(n - 1,destination,this);
            }
        }

        /*
         * @return: Disks
         */
        public Stack<Integer> getDisks() {
            // write your code here
            return disks;
        }
    }

/**
 * Your Tower object will be instantiated and called as such:
 * Tower[] towers = new Tower[3];
 * for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
 * for (int i = n - 1; i >= 0; i--) towers[0].add(i);
 * towers[0].moveDisks(n, towers[2], towers[1]);
 * print towers[0], towers[1], towers[2]
 */
}
