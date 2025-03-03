package q82_remove_duplicates_from_sorted_list_two;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/3 11:06
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-101);
        // 指针指向上一个不一样的数字
        ListNode notDuplicateNode = dummyNode;
        int duplicateValue = dummyNode.val;
        while(head != null){
            // 重复元素跳过
            if(head.val == duplicateValue){
                head = head.next;
                continue;
            }
            duplicateValue = head.val;
            if(head.next == null || head.val != head.next.val){
                notDuplicateNode.next = head;
                notDuplicateNode = head;
            }
            head = head.next;
        }
        notDuplicateNode.next = null;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode result = new Solution().deleteDuplicates(listNode1);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}
