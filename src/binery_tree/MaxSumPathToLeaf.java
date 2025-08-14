package binery_tree;

import java.util.ArrayList;
import java.util.List;

public class MaxSumPathToLeaf {
    List<Integer> result = new ArrayList<>();
    int sum = 0;

    public List<Integer> maxSumPath(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        computeMaxSumPath(root, temp);

        return result;
    }

    // 1,2,3
    private void computeMaxSumPath(TreeNode root, List<Integer> temp) {
        if (root == null) {
            return;
        }

        temp.add(root.val);

        if (root.left == null && root.right == null) {
            int tempSum = temp.stream().mapToInt(Integer::intValue).sum();
            if (tempSum > sum) {
                sum = tempSum;
                result = temp;
            }
        }

        computeMaxSumPath(root.left, temp);
        computeMaxSumPath(root.right, temp);
    }
}
