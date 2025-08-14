package binery_tree;

import com.sun.source.tree.Tree;

public class Diameter {

    public static int ans = Integer.MIN_VALUE;

    // time complexity = O(N) : in case of skewed tree
    // space complexity = O(N)
    public int diameterOptimised(TreeNode root) {
        if (root == null) {
            ans = Math.max(ans, 0);
            return 0;
        }

        int lh = diameterOptimised(root.left);
        int rh = diameterOptimised(root.right);

        ans = Math.max(ans, 1 + lh + rh);

        return 1 + Math.max(lh, rh);
    }


    // time complexity = O(N2)
    // space complexity = O(N)
    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        int ld = diameter(root.left);
        int rd = diameter(root.right);

        return Math.max(Math.max(ld,rd), 1 + lh + rh);
    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        return 1 + Math.max(lh ,rh);
    }
}
