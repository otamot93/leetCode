package q98_validate_binary_search_tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/30 21:13
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

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        double lastValue = -Double.MAX_VALUE;
        while(queue.size() > 0 || root != null){
            while(root != null){
                queue.push(root);
                root = root.left;
            }
            root = queue.pop();
            if(root.val <= lastValue){
                return false;
            }
            lastValue = root.val;
            root = root.right;
        }
        return true;
    }


}
