package binery_search_tree;

import java.util.ArrayList;
import java.util.List;

public class Find_Minimum_Absolute_Difference {
        int minDiff = Integer.MAX_VALUE;
        TreeNode prev = null;


        public int getMinimumDifference(TreeNode root) {
            inorder(root);
            return minDiff;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }

            inorder(root.left);
            if(prev != null) {
                minDiff = Math.min(minDiff, Math.abs(root.val - prev.val));
            }

            prev = root;

            inorder(root.right);
        }
}
