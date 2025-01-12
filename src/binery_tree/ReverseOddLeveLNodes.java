package binery_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLeveLNodes {

    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {

            if (level % 2 == 1) {
                List<TreeNode> swappedValues = swapNodes(queue);
                queue.clear();
                queue.addAll(swappedValues);
            }

            int size = queue.size();

            while (size-- > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            level++;
        }

        return root;
    }

    List<TreeNode> swapNodes(Queue<TreeNode> queue) {
        List<TreeNode> list = queue.stream().toList();
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int temp = list.get(low).val;
            list.get(low).val = list.get(high).val;
            list.get(high).val = temp;
            low++;
            high--;
        }

        return list;
    }
}
