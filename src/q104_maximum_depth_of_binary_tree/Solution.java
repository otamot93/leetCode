package q104_maximum_depth_of_binary_tree;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/4 09:56
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public static class TreeNode {
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

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if(root.left != null){
            leftDepth = maxDepth(root.left);
        }

        if(root.right != null){
            rightDepth = maxDepth(root.right);
        }

        return 1 + Integer.max(leftDepth,rightDepth);


    }
}
