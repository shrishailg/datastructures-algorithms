package binery_tree;

import binery_search_tree.TreeNode;

import java.util.Map;

public class Height {

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);

        return 1 + Math.max(lheight, rheight);
    }
}
