package q19;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
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
        ListNode head = new Solution().removeNthFromEnd(n1,2);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    /**
     * 方法不好，数组是没用的，只要记住倒数第n个的前一个就好了
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //申明一个大小为n的数组
        ListNode[] array = new ListNode[n];
        int nowCount = 0;//目前存放量
        ListNode first = head;
        ListNode removeLast = null;
        while(head != null){
            if(nowCount <=n-1){
                array[nowCount] = head;
                nowCount++;
            }else{
                removeLast = array[0];
                //调整位置
                for (int i = 0; i <array.length-1 ; i++) {
                    array[i] = array[i+1];
                }
                array[n-1] = head;
            }
            head = head.next;
        }

        //如果要删除是第一个
        if(array[0] == first){
            return first.next;
        }else{
            removeLast.next = n==1?null:array[1];
        }
        return first;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
