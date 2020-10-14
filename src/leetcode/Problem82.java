package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-14 13:50
 **/
public class Problem82 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
/* test case
    [1,2,3,3,4,4,5]
            [1,1,1,1,1]
            [1,1,1,2,2,3,4,4,5]
            [1,1,2,2]
            [1,1,2,2,3,3,4,5,5]
            [1,2,2,3]
            [1,2,2,3,3]
            []
            [1]
            [1,2,3]
    */
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))));
        System.out.println(new Problem82().deleteDuplicates(head));
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
    //Memory Usage: 38 MB, less than 17.54% of Java online submissions for Remove Duplicates from Sorted List II.
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode root = new ListNode();
        ListNode now = root;
        ListNode next = head;
        boolean isFirstTime = true;
        root.val = head.val - 1;
        while (true) {
            if (next.next == null) {
                now.next = isFirstTime ? next : null;
                break;
            }
            if (next.next.val == next.val) {
                isFirstTime = false;
            } else {
                if (isFirstTime) {
                    now.next = next;
                    now = next;
                }
                isFirstTime = true;
            }
            next = next.next;
        }
        return root.next;
    }
}
