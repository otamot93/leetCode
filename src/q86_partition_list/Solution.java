package q86_partition_list;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/3 18:57
 * @description：
 * @version: 1.0.0
 */
public class Solution {

  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode = new ListNode(x+1);
        dummyNode.next = head;
        ListNode lastNode = dummyNode;
        ListNode smallNode = null;
        ListNode smallNodeIter = null;
        while(head != null){
            if(head.val < x){
                if(smallNode == null){
                    smallNodeIter = head;
                    smallNode = head;
                }else{
                    smallNodeIter.next = head;
                    smallNodeIter = smallNodeIter.next;
                }
            }else{
                lastNode.next = head;
                lastNode = head;
            }

            head = head.next;
        }
        lastNode.next = null;
        if(smallNode == null){
            return dummyNode.next;
        }
        smallNodeIter.next = dummyNode.next;
        return smallNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode partitionNode = new Solution().partition(listNode1,3);
        while(partitionNode != null){
            System.out.println(partitionNode.val);
            partitionNode = partitionNode.next;
        }
    }
}
