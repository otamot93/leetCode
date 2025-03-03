package q108_convert_sorted_array_to_binary_search_tree;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/20 18:14
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return sortedArrayToBST(nums,0,nums.length-1);

    }

    public TreeNode sortedArrayToBST(int[] nums,int start,int end) {
        if(start > end){
            return null;
        }
        int middleIndex = (start+end)/2;
        TreeNode  middleNode = new TreeNode(nums[middleIndex]);
        middleNode.left = sortedArrayToBST(nums,start,middleIndex-1);
        middleNode.right = sortedArrayToBST(nums,middleIndex+1,end);
        return middleNode;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-10,-3,0,5,9};
        TreeNode bst = new Solution().sortedArrayToBST(array);
        System.out.println(bst);
    }
}
