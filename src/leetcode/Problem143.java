package leetcode;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Problem143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        new Problem143().reorderList(head);
        System.out.println();
    }

    //Runtime: 3 ms, faster than 22.56% of Java online submissions for Reorder List.
    //Memory Usage: 39.2 MB, less than 100.00% of Java online submissions for Reorder List.
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        List<ListNode> oldList = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            oldList.add(p);
            p = p.next;
        }
        int i = 0, j = oldList.size() - 1;
        boolean isLeft = true;
        while (i < j) {
            if (isLeft) {
                oldList.get(i++).next = oldList.get(j);
                isLeft = false;
            } else {
                oldList.get(j--).next = oldList.get(i);
                isLeft = true;
            }
        }
        oldList.get(i).next = null;
    }
}
