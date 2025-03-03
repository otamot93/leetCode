package q112_sum_path;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/6 22:12
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
         if(root == null){
             return false;
         }
        if(root.left ==null && root.right == null && root.val == targetSum){
            return true;
        }
        // 继续遍历左右节点
        if(hasPathSum(root.left,targetSum-root.val)
                || hasPathSum(root.right,targetSum-root.val)){
            return true;
        }

        return false;
    }
}
