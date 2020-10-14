package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-14 13:40
 **/
public class Problem83 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
    //Memory Usage: 38.3 MB, less than 12.23% of Java online submissions for Remove Duplicates from Sorted List.
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        int val = head.val;
        ListNode last = head;
        ListNode next = head.next;
        while (next != null) {
            if (next.val != val) {
                val = next.val;
                last.next = next;
                last = next;
            }
            next = next.next;
        }
        last.next = null;
        return head;
    }
}
