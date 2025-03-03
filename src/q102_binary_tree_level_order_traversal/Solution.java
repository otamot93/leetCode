package q102_binary_tree_level_order_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/13 20:13
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

    public List<List<Integer>> levelOrder(TreeNode root) {
          if(root == null){
              return new ArrayList<>();
          }
        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> treeNodes = new ArrayDeque<>();
          treeNodes.add(root);
          while(treeNodes.size() > 0){
              List<Integer> layerVals = new ArrayList<>();
              int size = treeNodes.size();
              for (int i = 0; i < size; i++) {
                  TreeNode treeNode = treeNodes.pop();
                  layerVals.add(treeNode.val);
                  if(treeNode.left != null ){
                      treeNodes.add(treeNode.left);
                  }
                  if(treeNode.right != null){
                      treeNodes.add(treeNode.right);
                  }

              }
              result.add(layerVals);
          }
          return result;
    }

}
