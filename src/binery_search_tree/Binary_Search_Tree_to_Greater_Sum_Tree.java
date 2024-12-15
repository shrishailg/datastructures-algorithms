package binery_search_tree;

public class Binary_Search_Tree_to_Greater_Sum_Tree {
        int sum = 0;


        public TreeNode bstToGst(TreeNode root) {
            reverseInOrder(root);
            return root;
        }

        void reverseInOrder(TreeNode root) {
            if(root == null) {
                return;
            }

            reverseInOrder(root.right);

            sum += root.val;
            root.val = sum;


            reverseInOrder(root.left);
        }
}
