package codingChallenge.heap;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TopKFrequentEle {
    static class Node {
        int ele;
        int count;

        Node(int ele, int count) {
            this.ele = ele;
            this.count = count;
        }
    }
    public static  int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count,o1.count));
        for (int i : nums)
            map.merge(i, 1, Integer::sum);
        for (int i : map.keySet())
            heap.add(new Node(i,map.get(i)));
        int[]arr = new int[k];
        int i=0;
        while (!heap.isEmpty() && k-->0)
            arr[i++] = heap.poll().ele;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr,2)));
    }
}
