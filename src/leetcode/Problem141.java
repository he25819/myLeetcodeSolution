package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-20 17:47
 **/
public class Problem141 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 全部存下来
    // Runtime: 3 ms, faster than 19.84% of Java online submissions for Linked List Cycle.
    //Memory Usage: 39.2 MB, less than 16.56% of Java online submissions for Linked List Cycle.
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head))
                return true;
            visited.add(head);
            head = head.next;
        }
        return false;
    }


    // 快慢指针
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
    //Memory Usage: 38.8 MB, less than 16.56% of Java online submissions for Linked List Cycle.
    public boolean hasCycle2(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == head)
                return true;
            fast = fast.next.next;
            head = head.next;
        }
        return false;
    }
}
