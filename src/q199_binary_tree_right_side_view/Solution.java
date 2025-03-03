package q199_binary_tree_right_side_view;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/12 19:15
 * @description：
 * @version: 1.0.0
 */




public class Solution {

    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root);
        while(treeNodes.size() > 0){
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodes.pop();
                if(i == size -1){
                    result.add(node.val);
                }
                if(node.left != null){
                    treeNodes.add(node.left);
                }
                if(node.right != null){
                    treeNodes.add(node.right);
                }
            }
        }
        return result;
    }
}
