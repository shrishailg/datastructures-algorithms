package binery_tree;

public class ConvertTreeToString {


    public static String convertTreeToString(TreeNode root) {
        if (root == null) {
            return "";
        }

        String result = String.valueOf(root.val);

        String left = convertTreeToString(root.left);
        String right = convertTreeToString(root.right);

        if (root.left == null && root.right == null) {
            return result;
        }

        if (root.left == null) {
            return result + "()" + "(" + right + ")";
        }

        if (root.right == null) {
            return result + "(" + left + ")";
        }

        return result + "(" + left + ")" + "(" + right + ")";
    }
}
