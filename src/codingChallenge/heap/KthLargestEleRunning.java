package codingChallenge.heap;

import java.util.PriorityQueue;

public class KthLargestEleRunning {
    PriorityQueue<Integer> heap;
    int i;

    //carry only top k elements and throw remaining
    public KthLargestEleRunning(int k, int[] nums) {
        heap = new PriorityQueue<>();
        for (int i : nums)
            heap.add(i);
        while (heap.size() > k)
            heap.poll();
        i = k;
    }

    //add value, remove smallest , peek to get n-k th smallest or k th largest element
    public int add(int val) {
        heap.add(val);
        if (heap.size() > i)
            heap.poll();
        return !heap.isEmpty()?heap.peek():Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] arr = {1,2,3,1,23,8};
        KthLargestEleRunning eleRunning = new KthLargestEleRunning(k,arr);
    }
}
