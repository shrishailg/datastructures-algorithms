package binery_tree;

public class MaxPathSum {
    int result = Integer.MIN_VALUE;

    public int findMaxSumPath(TreeNode root) {
        computeMaxSumPath(root);

        return result;
    }

    private int computeMaxSumPath(TreeNode root) {
        if (root == null){
            return 0;
        }

        int suml = computeMaxSumPath(root.left);
        int sumr = computeMaxSumPath(root.right);

        result = Math.max(result, root.val + suml + sumr);

        return root.val + Math.max(suml, sumr);
    }
}
