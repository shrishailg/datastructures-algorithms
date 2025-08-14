package binery_tree;

public class IdenticalTrees {

    public boolean isTreesIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isTreesIdentical(root1.left, root2.left) && isTreesIdentical(root1.right, root2.right);
    }
}
