package leetcode;

public class Problem2 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        ListNode result = new ListNode(sum % 10);
        int isOver = sum / 10;
        ListNode current = result;
        while (l1.next != null || l2.next != null || isOver == 1) {
            sum = isOver;
            if (l1.next != null) {
                l1 = l1.next;
                sum += l1.val;
            }
            if (l2.next != null) {
                l2 = l2.next;
                sum += l2.val;
            }
            isOver = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return result;
    }
}
