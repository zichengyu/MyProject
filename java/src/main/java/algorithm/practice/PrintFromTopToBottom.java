package algorithm.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * User: 20160301301
 * Date: 2017/11/23 9:22
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> data = new ArrayDeque();
        while (root != null) {
            result.add(root.val);
            if (root.left != null) {
                data.offer(root.left);
            }
            if (root.right != null) {
                data.offer(root.right);
            }
            root = data.poll();
        }
        return result;
    }
}
