package q637_average_of_levels_in_binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/8 22:32
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
    public List<Double> averageOfLevels(TreeNode root) {

          List<Double> averages = new ArrayList<>();
          if(root == null){
              return averages;
          }

        Deque<TreeNode> deque = new ArrayDeque<>();
          deque.add(root);
          while(deque.size() > 0){
              double total = 0;
              int size = deque.size();
              for (int i = 0; i < size; i++) {
                  TreeNode pop = deque.pop();
                  total += pop.val;
                  if(pop.left != null){
                      deque.add(pop.left);
                  }
                  if(pop.right != null){
                      deque.add(pop.right);
                  }
              }
              averages.add(total/size);
          }
          return averages;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2147483647);
        TreeNode treeNode2 = new TreeNode(2147483647);
        TreeNode treeNode3 = new TreeNode(2147483647);


        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        List<Double> result = new Solution().averageOfLevels(treeNode1);
        for (Double d:result){
            System.out.println(d);
        }
    }
}
