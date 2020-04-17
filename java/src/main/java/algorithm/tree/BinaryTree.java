package algorithm.tree;


import java.util.Stack;

/**
 * User: 20160301301
 * Date: 2017/10/30 17:04
 * Comment:
 */
public class BinaryTree {

    public Node init() {
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);
        return A;   //返回根节点
    }

    public void printNode(Node node) {
        System.out.print(node.getData() + "\t");
    }

    //先序遍历，非递归
    public void preOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || stack.size() > 0) {  //将所有左孩子压栈
            if (node != null) {   //压栈之前先访问
                printNode(node);
                stack.push(node);
                node = node.getLeftChild();
            } else {
                node = stack.pop();
                node = node.getRightChild();
            }
        }
    }

    //先序遍历，递归
    public void preOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        printNode(node);
        preOrderRecur(node.getLeftChild());
        preOrderRecur(node.getRightChild());

    }

    //中序遍历，非递归
    public void midorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || stack.size() > 0) {  //将所有左孩子压栈
            if (node != null) {   //压栈之前先访问
                stack.push(node);
                node = node.getLeftChild();
            } else {
                node = stack.pop();
                printNode(node);
                node = node.getRightChild();
            }
        }
    }

    //中序遍历，递归
    public void midorderSecur(Node node) {
        if (node == null) {
            return;
        }
        midorderSecur(node.getLeftChild());
        printNode(node);
        midorderSecur(node.getRightChild());
    }

    //先把右子树放进栈中去，再把左子树放进栈中去
    public void postorder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> output = new Stack<Node>(); //构造一个中间栈来存储逆后序遍历的结果
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.getRightChild(); //遍历右子树
            } else {
                node = stack.pop();
                node = node.getLeftChild();
            }
        }
        while (output.size() > 0) {
            printNode(output.pop());
        }
    }

    //后序，非递归
    public void postorderSecur(Node node) {
        if (node == null) {
            return;
        }
        postorderSecur(node.getLeftChild());
        postorderSecur(node.getRightChild());
        printNode(node);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.init();

        binaryTree.preOrder(root);
        System.out.println("\n");
        binaryTree.preOrderRecur(root);
        System.out.println("\n----------------------------");

        binaryTree.midorder(root);
        System.out.println("\n");
        binaryTree.midorderSecur(root);
        System.out.println("\n----------------------------");

        binaryTree.postorder(root);
        System.out.println("\n");
        binaryTree.postorderSecur(root);
    }
}