/**
 * Created by byhieg on 2017/9/8.
 * Mail to byhieg@gmail.com
 */
public class Number36 {

    public class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        int count = 1;
        ListNode mNode = null;
        ListNode preNode = null;
        ListNode startNode = null;
        ListNode nNode = null;
        while (cur != null) {

            if (count == (m - 1)) {
                startNode = cur;
            } else if (count == m) {
                preNode = cur;
            } else if (count == (m + 1)) {
                mNode = cur;
            }
            if (count == n) {
                nNode = cur;
            }
            cur = cur.next;
            count++;
        }
        cur = mNode;
        ListNode pre = preNode;
        ListNode nNextNode = nNode.next;

        while (cur != nNextNode) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        preNode.next = nNextNode;
        if (startNode != null) {
            startNode.next = nNode;
        } else {
            head = nNode;
        }
        return head;

    }
}
