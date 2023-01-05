package nowcoder.nc;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class NC78 {
    // 提交结果：答案正确 运行时间：23ms 占用内存：10232KB 使用语言：Java 用例通过率：100.00%
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tail = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
