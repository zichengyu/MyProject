package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/25 10:11
 * Comment:
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertTreeToLink {
    static TreeNode current = null;
    static TreeNode realHead = null;

    public static TreeNode convert(TreeNode pRootOfTree) {
        convertSub(pRootOfTree);
        return realHead;
    }

    private static void convertSub(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return;
        convertSub(pRootOfTree.left);
        if (current == null) {
            current = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            current.right = pRootOfTree;
            pRootOfTree.left = current;
            current = pRootOfTree;
        }
        convertSub(pRootOfTree.right);
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;
        t5.left = t10;
        t5.right = t11;
        convert(t1);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
