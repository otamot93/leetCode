package q2_add_two_number;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/30 13:40
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public static class ListNode{
        int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if(l1 == null){
//            return l2;
//        }
//
//        if(l2 == null){
//            return l1;
//        }
//
//        ListNode result = new ListNode((l1.val+l2.val)%10);
//        ListNode current = result;
//        int carry = l1.val+l2.val >= 10 ? 1:0;
//        // 构造后续联表
//        while(l1 != null || l2 != null){
//
//            if(l1 != null){
//                l1 = l1.next;
//
//            }
//            if(l2 != null){
//                l2 = l2.next;
//            }
//            int add  = carry +(l1!= null? l1.val:0)+(l2!=null?l2.val:0);
//            if(l1 != null || l2 != null || carry > 0){
//                ListNode  addNode = new ListNode(add%10);
//                carry = add >= 10? 1:0;
//                current.next = addNode;
//                current = current.next;
//            }
//
//        }
//
//
//        return result;

        ListNode head = null,tail = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int add  = carry +(l1!= null? l1.val:0)+(l2!=null?l2.val:0);
            ListNode addNode = new ListNode(add %10);
            if(head == null){
                head = tail = addNode;
            }else{
                tail.next = addNode;
                tail = tail.next;
            }

            carry = add /10;
            if(l1 != null){
                l1 = l1.next;

            }
            if(l2 != null){
                l2 = l2.next;
            }

        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }

        return head;

    }

    public static void main(String[] args) {
        ListNode add0_0 = new ListNode(2);
        ListNode add0_1 = new ListNode(4);
        ListNode add0_2 = new ListNode(3);
//        ListNode add0_3 = new ListNode(7);
        add0_0.next = add0_1;
        add0_1.next = add0_2;
//        add0_2.next = add0_3;

        ListNode add1_0 = new ListNode(5);
        ListNode add1_1 = new ListNode(6);
        ListNode add1_2 = new ListNode(4);
        add1_0.next = add1_1;
        add1_1.next = add1_2;

        ListNode result = new Solution().addTwoNumbers(add0_0,add1_0);
        while(result != null ){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
