package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/1 11:41
 * Comment:
 */
public class ListNode {
    private ListNode next;
    private int data;

    public ListNode(int data) {
        this(null, data);
    }

    public ListNode(ListNode next, int data) {
        this.next = next;
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}