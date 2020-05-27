package leetcode;

public class Problem24 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        ListNode next = node.next;
        next.next = new ListNode(3);
        next = next.next;
        next.next = new ListNode(4);
//        next = next.next;
//        next.next = new ListNode(5);
        ListNode rst = new Problem24().swapPairs(node);
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
    //Memory Usage: 39.1 MB, less than 5.50% of Java online submissions for Swap Nodes in Pairs.
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode rst = head.next;
        ListNode b = head.next;
        ListNode tmp = b.next;
        head.next = swapPairs(tmp);
        b.next = head;
        return rst;
    }




    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
