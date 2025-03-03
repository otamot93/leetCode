package q206_reverse_link_list;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/2 15:41
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

    public ListNode reverseList(ListNode head) {
        ListNode lastNode = null;
        while(head != null){
            ListNode nextNode = head.next;
            head.next = lastNode;
            lastNode = head;
            head = nextNode;
        }

        return lastNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = listNode3;

        ListNode head = new Solution().reverseList(listNode);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

}
