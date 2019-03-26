package Practice.Amazon;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInStream {

    PriorityQueue<Integer> minHeap, maxHeap;

    public FindMedianInStream() {

        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() == minHeap.size()) {
            return ((maxHeap.peek() + minHeap.peek()) / 2.0);
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {

        FindMedianInStream findMedianInStream = new FindMedianInStream();
        findMedianInStream.addNum(1);
        findMedianInStream.addNum(2);
        System.out.println(findMedianInStream.findMedian());
        findMedianInStream.addNum(3);
        System.out.println(findMedianInStream.findMedian());
    }
}
