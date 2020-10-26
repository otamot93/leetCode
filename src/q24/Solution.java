package q24;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 交换
        ListNode prev = null;
        ListNode current = head;
        ListNode returnValue = head.next;
        while(true){
            ListNode currentNext = current.next;
            if(currentNext== null){
                break;
            }

            if(prev !=null){
                prev.next = currentNext;
            }

            current.next = current.next.next;
            currentNext.next = current;
            if(current.next ==null){
                break;
            }
            prev = current;
            current = current.next;

        }

        return returnValue;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 2;
        ListNode node3 = new ListNode();
        node3.val = 3;
        ListNode node4 = new ListNode();
        node4.val = 4;
        ListNode node5 = new ListNode();
        node5.val = 5;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = new Solution().swapPairs(node1);
        while (head !=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
