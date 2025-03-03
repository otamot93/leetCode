package q92_reverse_link_two;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/1 22:11
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }

        // 翻转指定范围的数据
        left--;
        right--;
        while(left < right){
            ListNode leftNode = list.get(left);
            list.set(left,list.get(right));
            list.set(right,leftNode);
            left++;
            right--;
        }
        // 重新构建链表
        for (int i = 0; i < list.size(); i++) {
            if(i == list.size()-1){
                // 最后一个
                list.get(i).next = null;
            }else{
                list.get(i).next = list.get(i+1);
            }
        }

        return list.get(0);

    }
}
