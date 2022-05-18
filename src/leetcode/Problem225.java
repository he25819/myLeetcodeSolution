package leetcode;

import java.util.LinkedList;

public class Problem225 {

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
    //Memory Usage: 41.6 MB, less than 60.44% of Java online submissions for Implement Stack using Queues.
    private class MyStack {
        private LinkedList<Integer> linkedList;
        private int top;

        public MyStack() {
            linkedList = new LinkedList<>();
        }

        public void push(int x) {
            linkedList.addLast(x);
        }

        public int pop() {
            return linkedList.removeLast();
        }

        public int top() {
            return linkedList.getLast();
        }

        public boolean empty() {
            return linkedList.isEmpty();
        }
    }
}