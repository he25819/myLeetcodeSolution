package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-14 17:26
 **/
public class Problem92 {
    private static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
/* test cases
    [1,2,3,4,5]
            2
            4
            [1,2,3,4,5]
            1
            5
            [1,2,3,4,5]
            1
            2
            [1,2,3,4,5]
            1
            1
            [1,2,3,4,5]
            2
            2
            [1,2,3,4,5]
            5
            5
            [1,2,3,4,5]
            4
            5
            [1,2,3,4,5]
            2
            4
            [1,2,3,4,5]
            1
            5
    */


    public static void main(String[] args) {
        System.out.println(new Problem92().reverseBetween(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 1, 5));
    }

    // 非递归
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
    //Memory Usage: 36.6 MB, less than 16.19% of Java online submissions for Reverse Linked List II.
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode dummy = new ListNode(0, head);
        ListNode leftLast = dummy;
        ListNode cur = head;
        for (int i = 0; i < m - 1; i++) {
            leftLast = cur;
            cur = cur.next;
        }
        for (int i = m; i < n; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = leftLast.next;
            leftLast.next = next;
        }
        return dummy.next;
    }


    // 递归
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
    //Memory Usage: 36.4 MB, less than 16.19% of Java online submissions for Reverse Linked List II.
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m == n)
            return head;
        if (m == 1)
            return reverseN(head, n);
        head.next = reverseBetween2(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode reverseN(ListNode cur, int i) {
        if (i == 1)
            return cur;
        ListNode first = cur.next;
        ListNode last = reverseN(cur.next, i - 1);
        cur.next = first.next;
        first.next = cur;
        return last;
    }
}
