package q100_is_same_tree;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/4 10:11
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 相同对象，或者都是null
        if(p == q){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        System.out.println(null == null);
    }
}
