package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-15 17:47
 **/
public class Problem206 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 递归，更多单链表反转见problem92
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
    //Memory Usage: 39.2 MB, less than 6.67% of Java online submissions for Reverse Linked List.
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode left = head.next;
        ListNode right = reverseList(left);
        left.next = head;
        head.next = null;
        return right;
    }
}
