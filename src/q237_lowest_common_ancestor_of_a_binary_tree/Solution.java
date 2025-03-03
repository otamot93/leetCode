package q237_lowest_common_ancestor_of_a_binary_tree;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/27 22:58
 * @description：
 * @version: 1.0.0
 */
public class Solution {

     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
     }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root == null || root == p || root == q){
             return root;
         }
         TreeNode leftAncestor = lowestCommonAncestor(root.left,p,q);
         TreeNode rightAncestor = lowestCommonAncestor(root.right,p,q);
         if(leftAncestor == null){
             return rightAncestor;
         }
         if(rightAncestor == null){
             return leftAncestor;
         }
         return root;
    }
}
