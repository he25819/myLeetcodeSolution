package leetcode;

public class Problem86 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
//        ListNode nodes = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        ListNode nodes = new ListNode(1, new ListNode(1));
        System.out.println(new Problem86().partition(nodes, 3));
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
    //Memory Usage: 38.9 MB, less than 55.92% of Java online submissions for Partition List.
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode smallFirst = null, smallEnd = null, bigFirst = null, bigEnd = null;

        while (head != null) {
            if (head.val < x) {
                if (smallFirst == null) {
                    smallFirst = head;
                    smallEnd = head;
                } else {
                    smallEnd.next = head;
                    smallEnd = head;
                }
            } else {
                if (bigFirst == null) {
                    bigFirst = head;
                    bigEnd = head;
                } else {
                    bigEnd.next = head;
                    bigEnd = head;
                }
            }
            head = head.next;
        }

        if (smallFirst == null)
            return bigFirst;
        if (bigFirst == null)
            return smallFirst;
        smallEnd.next = bigFirst;
        bigEnd.next = null;
        return smallFirst;
    }
}
