package binery_tree;

public class BalanceBtree {

    // time complexity = O(N)
    // space complexity = O(N)
    int height(TreeNode root) {
        if (root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        // not balanced tree
        if (Math.abs(lh-rh) > 1) {
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }


    // time complexity = O(N2)
    // space complexity = O(N)
    boolean isBalancedTree(TreeNode root) {
        if (root == null){
            return true;
        }

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        if (Math.abs(lh-rh) > 1) {
            return false;
        }

        boolean isBalancedLeft = isBalancedTree(root.left);
        boolean isBalancedRight = isBalancedTree(root.right);

        return isBalancedLeft && isBalancedRight;
    }

    int findHeight(TreeNode root) {
        if (root == null){
            return 0;
        }

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        return 1 + Math.max(lh, rh);
    }

}
