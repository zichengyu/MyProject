package algorithm.sord;

/**
 * 描述：输入一个链表，反转链表后，输出新链表的表头。
 *
 * @author: yuzicheng
 * @since: 8/7/20 9:34 上午
 */
public class ReverseList {

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = reverseList.new ListNode(0);
        ListNode next1 = reverseList.new ListNode(1);
        ListNode next2 = reverseList.new ListNode(2);

        head.next = next1;
        next1.next = next2;

        ListNode newHead = reverseList.reverseList(head);

        System.out.println(newHead.val);
        while (newHead.next != null) {
            System.out.println(newHead.next.val);
            newHead = newHead.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, p = head, next;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
