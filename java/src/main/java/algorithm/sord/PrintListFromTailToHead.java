package algorithm.sord;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {

    public static void main(String[] args) {
        ListNode tail = new ListNode(6);
        ListNode head = new ListNode(0);

        ListNode node1 = new ListNode(1);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node5.next = tail;

        System.out.println(printListFromTailToHead1(head));
    }

    /**
     * java栈解法
     *
     * @param listNode 节点
     * @return 结果
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * 递归解法
     *
     * @param listNode 节点
     * @return 结果
     */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null) {
            return arrayList;
        }
        // 递归遍历
        recursively(arrayList, listNode);
        return arrayList;
    }

    private static void recursively(ArrayList<Integer> arrayList, ListNode listNode) {
        if (listNode == null) {
            return;
        }
        recursively(arrayList, listNode.next);
        arrayList.add(listNode.val);
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
