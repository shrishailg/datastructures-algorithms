package binery_search_tree;

import java.util.ArrayList;
import java.util.List;

//Mode == frequency
public class Find_Mode_in_Binary_Search_Tree {
    int curNum = 0;
    int curFreq = 0;
    int maxFreq = 0;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] finalResult = new int[result.size()];

        int idx = 0;
        for(var num:result) {
            finalResult[idx++] = num;
        }

        return finalResult;
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (root.val == curNum) {
            curFreq++;
        } else {
            curNum = root.val;
            curFreq = 1;
        }

        if (curFreq > maxFreq) {
            result.clear();
            maxFreq = curFreq;
        }

        if (curFreq == maxFreq) {
            result.add(curNum);
        }

        inorder(root.right);
    }
}
