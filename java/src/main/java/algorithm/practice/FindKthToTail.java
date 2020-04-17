package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/9 14:44
 * Comment:输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public static ListNode findToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode pAhead = head;
        ListNode pBehind = head;
        for (int i = 1; i <= k - 1; i++) {
            if (pAhead.getNext() == null) {
                return null;
            }
            pAhead = pAhead.getNext();
        }
        while (pAhead.getNext() != null) {
            pAhead = pAhead.getNext();
            pBehind = pBehind.getNext();
        }
        return pBehind;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        System.out.println(findToTail(node1, 6).getData());
    }
}