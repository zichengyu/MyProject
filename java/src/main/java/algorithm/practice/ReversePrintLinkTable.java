package algorithm.practice;

import java.util.ArrayList;

/**
 * User: 20160301301
 * Date: 2017/11/1 11:44
 * Comment:
 */
public class ReversePrintLinkTable {

    public static ListNode init() {

        ListNode root8 = new ListNode(8);
        ListNode root7 = new ListNode(root8, 7);
        ListNode root6 = new ListNode(root7, 6);
        ListNode root5 = new ListNode(root6, 5);
        ListNode root4 = new ListNode(root5, 4);
        ListNode root3 = new ListNode(root4, 3);
        ListNode root2 = new ListNode(root3, 2);
        ListNode root1 = new ListNode(root2, 1);
        ListNode root = new ListNode(root1, 0);
        return root;
    }

    public static void ergodic(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode.getNext() == null) {
            return;
        }
        ergodic(listNode.getNext());
        result.add(listNode.getData());
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        if (listNode.getNext() == null) {
            result.add(listNode.getData());
            return result;
        }
        result = printListFromTailToHead(listNode.getNext());
        result.add(listNode.getData());
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = printListFromTailToHead(init());
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }
}