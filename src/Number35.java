/**
 * Created by byhieg on 2017/9/8.
 * Mail to byhieg@gmail.com
 */
public class Number35 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

}
