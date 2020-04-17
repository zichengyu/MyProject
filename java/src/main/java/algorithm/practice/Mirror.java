package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/13 15:33
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Mirror {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = null;
        tmp  = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}