package q141_linked_list_crycle;


import java.util.HashSet;
import java.util.Set;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/29 16:48
 * @description：
 * @version: 1.0.0
 */



public class Solution {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null && head.next != null){
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
                head = head.next;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        boolean hasCycle = new Solution().hasCycle(null);
        System.out.println(hasCycle);
    }
}
