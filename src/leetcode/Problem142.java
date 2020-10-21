package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-21 10:39
 **/
public class Problem142 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Runtime: 3 ms, faster than 23.27% of Java online submissions for Linked List Cycle II.
    //Memory Usage: 39.7 MB, less than 5.94% of Java online submissions for Linked List Cycle II.
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (!visited.add(head))
                return head;
            head = head.next;
        }
        return null;
    }


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
    //Memory Usage: 38.8 MB, less than 5.94% of Java online submissions for Linked List Cycle II.
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode rst = head;
                while (slow != rst) {
                    slow = slow.next;
                    rst = rst.next;
                }
                return rst;
            }
        }
        return null;
    }
}
