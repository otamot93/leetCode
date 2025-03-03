package q530_minimum_absolute_difference_in_bst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/9 21:57
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
    public int getMinimumDifference(TreeNode root) {
          int minimumDifference = 1000001;
        List<Integer> list = getMinimumDifferenceList(root);
        for (int i = 0; i < list.size()-1; i++) {
            minimumDifference = Integer.min(minimumDifference,list.get(i+1)-list.get(i));
        }
        return minimumDifference;

    }

    private List<Integer> getMinimumDifferenceList(TreeNode root) {
          List<Integer> list = new ArrayList<>();
          if(root.left != null){
              list.addAll(getMinimumDifferenceList(root.left));
          }
          list.add(root.val);
          if(root.right != null){
              list.addAll(getMinimumDifferenceList(root.right));
          }
          return list;
    }
}
