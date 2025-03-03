package q61_rotate_list;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/3 18:29
 * @description：
 * @version: 1.0.0
 */
public class Solution {

    public static  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
            // 统计链表长度
        int count = 0;
        ListNode current = head;
        // 末尾的节点
        ListNode tailNode = current;

        while(current != null){
            count++;
            if(current.next == null){
                tailNode = current;
            }
            current = current.next;
        }



        // 不用变
        if(k % count == 0){
            return head;
        }

        // 获取要截取移动到前面的节点位置

        int targetIndex = count - k % count+1;
        current = head;
        ListNode lastNode = null;
        count = 0;

        while(current != null){
            count++;
            if(count == targetIndex){
                // lastNode的next设置为null，末尾节点的next设置为头节点
                lastNode.next = null;
                tailNode.next = head;
                return current;
            }
            lastNode = current;
            current = current.next;
        }

        // 不会走到这
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode result = new Solution().rotateRight(listNode1,2);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
