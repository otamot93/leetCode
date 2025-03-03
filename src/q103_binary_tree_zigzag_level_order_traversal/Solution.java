package q103_binary_tree_zigzag_level_order_traversal;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/14 20:23
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root);
        boolean leftToRight = true;
        List<List<Integer>> results = new ArrayList<>();

        while(treeNodes.size() > 0){
            int size = treeNodes.size();
            Deque<Integer> layer = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = treeNodes.pop();
                if(leftToRight){
                    layer.add(current.val);
                }else{
                    layer.push(current.val);
                }
                if(current.left != null){
                    treeNodes.add(current.left);
                }
                if(current.right!= null){
                    treeNodes.add(current.right);
                }
            }
            leftToRight = !leftToRight;
            results.add(layer.stream().collect(Collectors.toList()));
        }

        return results;
    }
}
