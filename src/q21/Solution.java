package q21;

import org.w3c.dom.NodeList;

public class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        ListNode result = new Solution().mergeTwoLists(null, null);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode firstNode = null;
        if(l1.val<=l2.val){
            firstNode = l1;
            l1 = l1.next;
        }else{
            firstNode = l2;
            l2 = l2.next;
        }
        ListNode temp = firstNode;
        while (l1 != null || l2 != null) {
            ListNode min = null;
            if(l1 == null){
                min = l2;
                l2 = l2.next;
            }else if(l2 == null){
                min = l1;
                l1 = l1.next;
            }else{
                if(l1.val<=l2.val){
                    min = l1;
                    l1 = l1.next;
                }else{
                    min =l2;
                    l2 = l2.next;
                }
            }
            temp.next = min;

            temp = temp.next;
        }
        return firstNode;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
