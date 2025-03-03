package q138_copy_list_with_random_pointer;


import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/31 16:30
 * @description：
 * @version: 1.0.0
 */
public class Solution {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node,Node> cache = new HashMap<>();

    public Node copyRandomList(Node head) {
        // 循环两遍，第一遍构造一个Map<node,index>的索引和一个List<Node>新的链表
        // 第二遍给新的链表赋值
//        Node oldHead = head;
//        Node newHead = null,newTail = null;
//
//        while(head != null){
//            Node  newNode = new Node(head.val);
//            cache.put(head,newNode);
//            if(newHead == null){
//                newHead = newTail = newNode;
//            }else{
//                newTail.next = newNode;
//                newTail = newTail.next;
//            }
//            head = head.next;
//        }
//        Node resultHead = newHead;
//
//        while(oldHead  != null){
//            newHead.random = cache.get(oldHead.random);
//            oldHead = oldHead.next;
//            newHead = newHead.next;
//        }
//        return resultHead;

        if(head == null){
            return null;
        }
        Node newNode = new Node(head.val);
        cache.put(head,newNode);
        if(cache.containsKey(head.next)){
            newNode.next = cache.get(head.next);
        }else{
            newNode.next = copyRandomList(head.next);
        }

        newNode.random = cache.get(head.random);
        return newNode;
    }
}
