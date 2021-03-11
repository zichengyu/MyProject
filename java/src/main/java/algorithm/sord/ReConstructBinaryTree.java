package algorithm.sord;

/**
 * 问题：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * 分析：先序序列的特点是第一个数就是根结点而后是左子树的先序序列和右子树的先序序列，而中序序列的特点是先是左子树的中序序列，
 * 然后是根结点，最后是右子树的中序序列。因此我们可以通过先序序列得到根结点，然后通过在中序序列中查找根结点的索引从而得到左子树和右子树
 * 的结点数。然后可以将两序列都一分为三，对于其中的根结点能够直接重建，然后根据对应子序列分别递归重建根结点的左子树和右子树。
 * 这是一个典型的将复杂问题划分成子问题分步解决的过程。
 *
 * @author: yuzicheng
 * @since: 8/7/20 10:24 上午
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || in.length == 0 || pre.length != in.length) {
            return null;
        }
        return rebuild(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * 重建二叉树
     *
     * @param pre 前序遍历节点
     * @param i   前序遍历节点开始索引
     * @param j   前序遍历节点终止节点
     * @param in  后袖遍历节点
     * @param m   后序遍历节点开始索引
     * @param n   后续遍历节点终止索引
     * @return 二叉树
     */
    private TreeNode rebuild(int[] pre, int i, int j, int[] in, int m, int n) {
        int rootVal = pre[i], index = findIndex(rootVal, in, m, n);
        if (index < 0) {
            return null;
        }
        TreeNode root = new TreeNode(rootVal);

        int leftNodes = index - m;
        int rightNodes = n - index;
        if (leftNodes <= 0) {
            root.left = null;
        } else {
            root.left = rebuild(pre, i + 1, i + leftNodes, in, m, m + leftNodes - 1);
        }
        if (rightNodes <= 0) {
            root.right = null;
        } else {
            root.right = rebuild(pre, i + leftNodes + 1, j, in, n - rightNodes + 1, n);
        }
        return root;
    }

    /**
     * 从中序遍历列表中找出当前rootVal对应的左子树节点最大索引
     *
     * @param rootVal 当前根节点值
     * @param in      中序遍历列表
     * @param from    起始索引
     * @param to      终止索引
     * @return 根节点值在中序遍历列表中的索引
     */
    private int findIndex(int rootVal, int[] in, int from, int to) {
        if (in == null || in.length == 0) {
            return -1;
        }
        for (int i = from; i <= to; i++) {
            if (in[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
