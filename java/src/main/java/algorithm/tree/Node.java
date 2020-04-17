package algorithm.tree;

/**
 * User: 20160301301
 * Date: 2017/10/30 17:01
 * Comment: 二叉树结构
 * Comment: 二叉树结构
 */
public class Node {

    private Node leftChild;
    private Node rightChild;
    private int data;

    public Node(int data, Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
