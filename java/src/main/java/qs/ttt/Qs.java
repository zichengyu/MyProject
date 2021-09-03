package qs.ttt;

import java.util.concurrent.BrokenBarrierException;

/**
 * 给定两个用单链表表示的整数，每个节点包含一个数位。
 * <p>
 * 编写函数对这两个整数求和，并用单链表形式返回结果。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即716+592 = 1308 (1->3->0->8)
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 */
public class Qs {
    public class ListNode {
        private Integer val;
        private ListNode next;

        public ListNode(Integer val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode listAdd(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode current = new ListNode(-1, null);
        ListNode head = current;

        // 保存累加的进位
        int a = 0;
        int l1Val = 0;
        int l2Val = 0;
        // 当前累加和
        int sum = 0;
        while (l1 != null || l2 != null) {
            l1Val = l1 == null ? 0 : l1.val;
            l2Val = l2 == null ? 0 : l2.val;
            sum = l1Val + l2Val + a;
            a = sum / 10;
            current.next = new ListNode(sum % 10, null);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            } else {
                l1 = null;
            }
            if (l2 != null) {
                l2 = l2.next;
            } else {
                l2 = null;
            }

        }
        if (a != 0) {
            current.next = new ListNode(1, null);
        }
        return head.next;
    }

    public ListNode revert(ListNode listNode) {
        ListNode pre = listNode;
        ListNode current = listNode.next;
        pre.next = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        Qs qs = new Qs();
        ListNode l1 = qs.buildNode("1,6");
        ListNode l2 = qs.buildNode("5,9,2");
        l1 = qs.revert(l1);
        l2 = qs.revert(l2);
        ListNode result = qs.listAdd(l1, l2);
        result = qs.revert(result);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }


    private ListNode buildNode(String s) {
        String[] nums = s.split(",");
        ListNode current = new ListNode(-1, null);
        ListNode head = current;
        for (String num : nums) {
            current.next = new ListNode(Integer.valueOf(num), null);
            current = current.next;
        }
        return head.next;
    }
}
