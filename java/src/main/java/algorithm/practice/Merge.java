package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/11 11:09
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {

    public ListNode getMerge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            ListNode list = null;
            if (list1.val < list2.val) {
                list = list1;
                list.next = getMerge(list1.next, list2);
            } else {
                list = list2;
                list.next = getMerge(list1, list2.next);
            }
            return list;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode list = listNode1;
        listNode1 = listNode1.next;
        System.out.println(list.val);
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
