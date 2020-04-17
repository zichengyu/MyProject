package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/11/1 14:31
 * Comment: 根据前序和中序遍历的结果，重建二叉树
 */
public class ConstructTwoForkTree {
    public TreeNode init() {
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);
        return A;   //返回根节点
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree(java.util.Arrays.copyOfRange(pre, 1, i + 1), java.util.Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(java.util.Arrays.copyOfRange(pre, i + 1, pre.length), java.util.Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}