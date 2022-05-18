package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problem295 {
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

    // Time Limit Exceeded
    class MedianFinder {
        private List<Integer> list = new ArrayList<>();

        public MedianFinder() {

        }

        public void addNum(int num) {
            list.add(num);
        }

        public double findMedian() {
            list.sort(Integer::compareTo);
            int size = list.size();
            int l = (size - 1) / 2;
            int r = size - 1 - l;
            return (list.get(l) + list.get(r)) / 2D;
        }
    }


    // Runtime: 560 ms, faster than 5.00% of Java online submissions for Find Median from Data Stream.
    //Memory Usage: 109.3 MB, less than 68.81% of Java online submissions for Find Median from Data Stream.
    class MedianFinder2 {
        private List<Integer> list = new ArrayList<>();

        public MedianFinder2() {

        }

        public void addNum(int num) {
            int i = Collections.binarySearch(list, num);
            if (i < 0)
                i = -i - 1;
            list.add(i, num);
        }

        public double findMedian() {
            int size = list.size();
            int l = (size - 1) / 2;
            int r = size - 1 - l;
            return (list.get(l) + list.get(r)) / 2D;
        }
    }


    // 参考官方答案1的思路
    // Runtime: 245 ms, faster than 19.25% of Java online submissions for Find Median from Data Stream.
    //Memory Usage: 126.5 MB, less than 16.62% of Java online submissions for Find Median from Data Stream.
    class MedianFinder3 {
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        public MedianFinder3() {
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
                maxHeap.add(num);
                if (maxHeap.size() - 1 > minHeap.size())
                    minHeap.add(maxHeap.poll());
            } else {
                minHeap.add(num);
                if (minHeap.size() - 1 > maxHeap.size())
                    maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size())
                return (maxHeap.peek() + minHeap.peek()) / 2D;
            if (maxHeap.size() > minHeap.size())
                return maxHeap.peek();
            return minHeap.peek();
        }
    }
}
