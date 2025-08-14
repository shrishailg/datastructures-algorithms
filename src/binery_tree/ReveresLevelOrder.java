package binery_tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReveresLevelOrder {

    public void reverseLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            List<Integer> temList = new ArrayList<>();
            int n = queue.size();

            while (n-->0) {
                TreeNode temp = queue.poll();

                temList.add(temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

            result.addAll(0, temList);
        }

        System.out.println(result);
    }
}
