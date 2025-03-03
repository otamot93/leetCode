package q21;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/31 16:03
 * @description：
 * @version: 1.0.0
 */
public class Solution2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null,tail = null;


        while(list1 != null || list2 != null){
            ListNode targetNode = list1 == null? list2 :(list2 == null? list1:(list1.val <= list2.val ? list1:list2));

            if(head == null){
                head = tail = targetNode;
            }else{
                tail.next = targetNode;
                tail = tail.next;
            }

            // 匹配中的节点往后移动
            if(targetNode == list1){
                list1 = list1.next;
            }else{
                list2 = list2.next;
            }
        }

        return head;
    }

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
        ListNode result = new Solution2().mergeTwoLists(node1, node4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
