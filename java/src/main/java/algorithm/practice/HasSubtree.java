package algorithm.practice;

import java.util.IdentityHashMap;

/**
 * User: 20160301301
 * Date: 2017/11/11 11:32
 * Comment:
 */
public class HasSubtree {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        Byte x;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesTree1HasTree2(root1, root2);
            }
            if (!result) {
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }

    public static void main(String[] args) {
        float average[];
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