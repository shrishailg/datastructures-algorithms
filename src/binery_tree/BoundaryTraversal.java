package binery_tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    public void printBoundary(TreeNode root) {
        if (root == null) {
            return;
        }

        List<Integer> result = new ArrayList<>();

        List<Integer> al = new ArrayList<>();

        List<Integer> leftBoundary = getLeftBoundary(root.left, new ArrayList<>());
        getRightBottomUp(root.right, al);

        result.addAll(leftBoundary);
        result.addAll(al);
    }

    private List<Integer> getLeftBoundary(TreeNode root, List<Integer> leftArray) {
        if (root == null) {
            return leftArray;
        }

        leftArray.add(root.val);

        if (root.left != null) {
            return getLeftBoundary(root.left, leftArray);
        } else {
            return getLeftBoundary(root.right, leftArray);
        }
    }

    private void getRightBottomUp(TreeNode root, List<Integer> al) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
             getRightBottomUp(root.right, al);
        } else {
             getRightBottomUp(root.left, al);
        }

        al.add(root.val);
    }
}
