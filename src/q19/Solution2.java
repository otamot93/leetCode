package q19;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/2 17:51
 * @description：
 * @version: 1.0.0
 */
public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 缓存一遍一共有多少个
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }

        // 计算是正序的第几个
        int index = count - n +1;

        ListNode current = dummyNode;
        ListNode lastNode = null;
        while(current != null){
            if(index-- == 0){
                lastNode.next = current.next;
            }

            lastNode = current;
            current = current.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode n1  = new ListNode(1);
        ListNode n2  = new ListNode(2);
        ListNode n3  = new ListNode(3);
        ListNode n4  = new ListNode(4);
        ListNode n5  = new ListNode(5);
        n1.next = n2;
        n2.next= n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = new Solution2().removeNthFromEnd(n1,2);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }


}
