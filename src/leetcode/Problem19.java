package leetcode;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class Problem19 {
    public static void main(String[] args) {
    }

    // Runtime: 1 ms, faster than 14.51% of Java online submissions for Remove Nth Node From End of List.
    //Memory Usage: 37.6 MB, less than 6.37% of Java online submissions for Remove Nth Node From End of List.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode headBak = head;
        Queue<ListNode> q = new ArrayDeque<>();
        int i = 0;
        while (head != null) {
            q.offer(head);
            if (q.size() > n + 1)
                q.poll();
            head = head.next;
        }

        if (n == 1) {
            if (q.size() == 1)
                return null;
            while (q.size() > 2)
                q.poll();
            Objects.requireNonNull(q.poll()).next = null;
        } else if (n == q.size()) {
            return headBak.next;
        } else {
            ListNode a = q.poll();
            a.next = q.poll().next;
        }

        return headBak;
    }

    private static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
