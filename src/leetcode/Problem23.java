package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-12 16:09
 **/

public class Problem23 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        System.out.println(new Problem23().mergeKLists(null).val);
    }

    // Runtime: 5 ms, faster than 51.12% of Java online submissions for Merge k Sorted Lists.
    //Memory Usage: 40.5 MB, less than 15.35% of Java online submissions for Merge k Sorted Lists.
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0)
            return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (null != node)
                heap.add(node);
        }

        ListNode result = null;
        ListNode nowNode = null;
        ListNode tmp;
        while ((tmp = heap.poll()) != null) {
            if (null == result) {
                nowNode = tmp;
                result = tmp;
            } else {
                nowNode.next = tmp;
                nowNode = tmp;
            }
            if (tmp.next != null)
                heap.add(tmp.next);
        }
        return result;
    }
}
