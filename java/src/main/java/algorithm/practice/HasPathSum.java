package algorithm.practice;

import java.util.Stack;

/**
 * User: 20160301301
 * Date: 2017/11/23 16:00
 * Comment:
 * 给出一个二叉树,用一个函数确定是否有一条从根节点到叶子节点的路径，这个路径上所有节点的值加在一起等于给定的sum的值。
 * 函数声明hasPathSum已经给出，写出程序设计思路并且实现该函数。尽量提供多种实现方法。
 */
public class HasPathSum {

    public void findPath(TreeNode root, int expectedSum, Stack<Integer> path, int currentSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        path.push(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf) {
            if (currentSum == expectedSum) {
                System.out.println("A path is");
                for (int i : path)
                    System.out.print(i + " ");
                System.out.println();
            }
        } else {
            if (root.left != null) {
                findPath(root.left, expectedSum, path, currentSum);
            }
            if (root.right != null) {
                findPath(root.right, expectedSum, path, currentSum);
            }
        }
        currentSum -= root.val;
        path.pop();

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
