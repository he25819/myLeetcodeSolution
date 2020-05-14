package leetcode;

public class Problem21 {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
    //Memory Usage: 40.7 MB, less than 12.12% of Java online submissions for Merge Two Sorted Lists.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result, p;
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else {
            if (l1.val <= l2.val) {
                result = l1;
                l1 = l1.next;
            } else {
                result = l2;
                l2 = l2.next;
            }
        }
        p = result;
        while (l1 != null) {
            if (l2 != null) {
                if (l1.val <= l2.val) {
                    p.next = l1;
                    p = p.next;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    p = p.next;
                    l2 = l2.next;
                }
            } else {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }
        }
        while (l2 != null) {
            p.next = l2;
            p = p.next;
            l2 = l2.next;
        }
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
