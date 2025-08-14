package binery_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderIterative {

    //root, left, right
    // 1, 2, 3
    public List<Integer> printPreorder(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        if (root == null){
            return preorder;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);

        while(!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            preorder.add(temp.val);

            if (temp.right != null) {
                stack1.push(temp.right);
            }

            if (temp.left != null) {
                stack1.push(temp.left);
            }
        }

        return preorder;
    }
}
