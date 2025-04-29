package q148_sort_list;

import base.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        return sortMerge(head);
    }

    private ListNode sortMerge(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        // 快慢指针寻找中心节点
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = sortMerge(slow.next);
        slow.next = null;
        ListNode left = sortMerge(head);

        // 归并排序
        ListNode virtualNode = new ListNode();
        ListNode current = virtualNode;
        while(right != null && left != null){
            if(left.val < right.val){
                current.next = left;
                left = left.next;
            }else{
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = left == null ? right: left;
        return virtualNode.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        node4.next = node2;
        node2.next = node1;
        node1.next = node3;
        node5.next = node4;

        ListNode head = new Solution().sortList(node5);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
