package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-28 14:27
 **/
public class Problem138 {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.random = node2;
        new Problem138().copyRandomList(node1);
    }


    // Runtime: 1 ms, faster than 7.08% of Java online submissions for Copy List with Random Pointer.
    //Memory Usage: 42.4 MB, less than 6.05% of Java online submissions for Copy List with Random Pointer.
    Map<Node, Node> map = new HashMap<>();
    Node first = null;
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        if (first == null)
            first = head;

        Node clone = new Node(head.val);
        map.put(head, clone);
        clone.next = copyRandomList(head.next);
        if (head.next == null) {
            while (first != null) {
                map.get(first).random = map.get(first.random);
                first = first.next;
            }
        }
        return clone;
    }



    // 答案1：回溯
    // HashMap which holds old nodes as keys and new nodes as its values.
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList2(Node head) {

        if (head == null) {
            return null;
        }

        // If we have already processed the current node, then we simply return the cloned version of
        // it.
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val);

        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid
        // them.
        this.visitedHash.put(head, node);

        // Recursively copy the remaining linked list starting once from the next pointer and then from
        // the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}
