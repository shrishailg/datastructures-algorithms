package binery_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {


    public void printZigzagTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean leftToRight = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0;i<n;i++) {
                TreeNode temp = queue.poll();

                if (leftToRight) {
                    list.add(temp.val);
                }else {
                    list.add(0,temp.val);
                }

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

            result.add(list);
            leftToRight = !leftToRight;
        }
    }
}
