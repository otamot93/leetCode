package q105_construct_binnary_tree_from_preorder_and_inorder_traversal;

import java.util.Set;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/5 19:04
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        int rootVal = preorder[0];
        TreeNode rootNode = new TreeNode(rootVal);

        // 利用inorder和preorder[0]根节点找到左边节点的元素
        int index = 0;
        while(inorder[index] != rootVal){
            index++;
        }
        // 小于index的就是左边节点的，大于index的就是右边节点的
        int[] leftPreorder = new int[index];
        int[] leftInorder = new int[index];
        int[] rightPreorder = new int[preorder.length-1-index];
        int[] rightInorder = new int[preorder.length-1-index];
        System.arraycopy(preorder,1,leftPreorder,0,index);
        System.arraycopy(inorder,0,leftInorder,0,index);
        System.arraycopy(preorder,index+1,rightPreorder,0,preorder.length-1-index);
        System.arraycopy(inorder,index+1,rightInorder,0,preorder.length-1-index);
        rootNode.left = buildTree(leftPreorder,leftInorder);
        rootNode.right = buildTree(rightPreorder,rightInorder);
        return rootNode;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = new Solution().buildTree(preorder,inorder);
    }
}
