package q106_construct_binary_tree_from_inorder_and_postorder_traversal;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/22 19:40
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,postorder,0,inorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder,int inorderLeftIndex,int inorderRightIndex,int postOrderLeftIndex,int postOrderRightIndex) {
         if(postOrderLeftIndex > postOrderRightIndex){
             return null;
         }
        if(inorderLeftIndex  == inorderRightIndex){
            return new TreeNode(inorder[inorderLeftIndex]);
        }

         int centerVal = postorder[postOrderRightIndex];
         TreeNode centerNode = new TreeNode(centerVal);

         // 通过中序号查找属于左节点的数量
        int count = 0;
        while(inorder[inorderLeftIndex + count] != centerVal){
            count++;
        }
        centerNode.left = buildTree(inorder,postorder,inorderLeftIndex,inorderLeftIndex+count-1,postOrderLeftIndex,postOrderLeftIndex+count-1);
        centerNode.right = buildTree(inorder,postorder,inorderLeftIndex+count+1,inorderRightIndex,postOrderLeftIndex+count,postOrderRightIndex-1);

        return centerNode;
    }

    public static void main(String[] args) {
        TreeNode result = new Solution().buildTree(new int[]{2,1},new int[]{2,1});
    }
}
