package binery_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {

    // 2, 1, 3

    //inorder:= left root right
    //time complexity: O(N) :- in case tree is skewed
    // space complexity: O(N)
    public List<Integer> printInorder(TreeNode root) {
       List<Integer> inorder = new ArrayList<>();

       if (root == null) {
           return inorder;
       }

       Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (true) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                if (stack.isEmpty()){
                    break;
                }

                temp = stack.pop();
                inorder.add(temp.val);
                temp = temp.right;
            }

        }

        return inorder;
    }


}
