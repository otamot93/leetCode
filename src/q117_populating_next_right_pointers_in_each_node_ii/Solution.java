package q117_populating_next_right_pointers_in_each_node_ii;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/23 18:21
 * @description：
 * @version: 1.0.0
 */


public class Solution {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Deque<Node> nodes  = new ArrayDeque<>();
        nodes.add(root);
        while(nodes.size() > 0){
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                Node current = nodes.pop();
                if(current.left!=null){
                    nodes.add(current.left);
                }
                if(current.right!=null){
                    nodes.add(current.right);
                }
                if(i < size-1){
                    current.next = nodes.getFirst();
                }
            }
        }

        return root;
    }
}
