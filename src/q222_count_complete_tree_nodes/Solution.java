package q222_count_complete_tree_nodes;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/7 18:29
 * @description：
 * @version: 1.0.0
 */
public class Solution {
     public class TreeNode {
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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }

}
