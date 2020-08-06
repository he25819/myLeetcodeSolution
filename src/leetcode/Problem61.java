package leetcode;


public class Problem61 {
    // Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
    //Memory Usage: 39.4 MB, less than 7.17% of Java online submissions for Rotate List.
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;

        int count = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            count++;
        }
        k %= count;
        if (k == 0)
            return head;

        ListNode last = node;
        ListNode preFirst = head;
        ListNode first = head;
        int i = count - k;
        while (--i > 0) {
            preFirst = preFirst.next;
        }
        first = preFirst.next;

        preFirst.next = null;
        last.next = head;
        return first;
    }

}
