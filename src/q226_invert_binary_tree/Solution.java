package q226_invert_binary_tree;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/5 17:10
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode newLeft = root.right;
        root.right = root.left;
        root.left = newLeft;
        // 翻转
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
