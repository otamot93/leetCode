package q230_kth_smallest_element_in_a_binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/28 19:43
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

    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return list.get(k-1);
    }

    public void  dfs(TreeNode root,int k){
        if(root == null){
            return;
        }
        if(list.size() == k){
            return;
        }
        dfs(root.left,k);
        list.add(root.val);
        dfs(root.right,k);
    }
}
