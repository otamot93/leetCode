package q129_sum_root_to_leaf_numbers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/26 22:50
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

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }

        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        int result = 0;
        while(nodes.size() > 0){
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = nodes.pop();
                if(current.left == null && current.right == null){
                    result +=current.val;
                }
                if(current.left != null){
                    current.left.val = current.val * 10+ current.left.val;
                    nodes.add(current.left);
                }
                if(current.right != null){
                    current.right.val = current.val *10 + current.right.val;
                    nodes.add(current.right);
                }
            }
        }

        return result;
    }
}
