package binery_search_tree;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary search tree, return a balanced binary search tree with the same node values.
 If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
        TreeNode[] root = {1,null,2,null,3,null,4,null,null};
        Output: [2,1,3,null,null,null,4]

 */

public class Balance_Binary_Search_Tree {

    public static void main(String... args) {

    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> result = inorder(root, new ArrayList<>());
        return alToBtree(result, 0, result.size()-1);
    }

    TreeNode alToBtree(List<Integer> result, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + ((high - low) / 2);

        TreeNode root = new TreeNode(result.get(mid));
        root.left = alToBtree(result, low, mid - 1);
        root.right = alToBtree(result, mid + 1, high);

        return root;
    }

    List<Integer> inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);

        return result;
    }
}
