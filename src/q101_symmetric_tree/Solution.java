package q101_symmetric_tree;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/5 17:33
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode leftNode,TreeNode rightNode){
        if(leftNode == rightNode){
            return true;
        }
        if(leftNode  ==  null || rightNode == null){
            return false;
        }
        if(leftNode.val != rightNode.val){
            return false;
        }

        return isSymmetric(leftNode.left,rightNode.right) && isSymmetric(leftNode.right,rightNode.left);

    }
}
