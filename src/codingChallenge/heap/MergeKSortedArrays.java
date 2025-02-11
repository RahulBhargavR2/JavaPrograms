package codingChallenge.heap;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    private static ArrayList<Integer> mergeUsingMergeSort(ArrayList<Integer> arr1, int[] arr2, int k) {
        int i = 0, j = 0;
        ArrayList<Integer> arr = new ArrayList<>(k * 2);
        while (i < arr1.size() && j < k) {
            if (arr1.get(i) < arr2[j])
                arr.add(arr1.get(i++));
            else arr.add(arr2[j++]);
        }
        while (i < arr1.size()) {
            arr.add(arr1.get(i++));
        }
        while (j < k) {
            arr.add(arr2[j++]);
        }
        return arr;
    }

    private static ArrayList<Integer> mergeWithSort(int[][] arr, int k) {
        if (k == 1)
            return new ArrayList<Integer>(List.of(arr[0][0]));
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int[] row : arr) {
            arrayList = mergeUsingMergeSort(arrayList, row, k);
        }
        return arrayList;
    }


    static class Node implements Comparable<Node> {
        int x;
        int y;
        int data;

        public Node(int x, int y, int data) {
            this.x = x;
            this.y = y;
            this.data = data;
        }
        @Override
        public int compareTo(@NotNull Node o) {
            return this.data <= o.data ? -1 : 1;

        }
    }

    private static ArrayList<Integer> mergeK(int[][] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
//        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(value -> value.data));
        PriorityQueue<Node> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++)
            heap.add(new Node(i, 0, arr[i][0]));

        while (!heap.isEmpty()) {
            Node top = heap.poll();
            res.add(top.data);
            if (top.y < arr[top.x].length - 1)
                heap.add(new Node(top.x, top.y + 1, arr[top.x][top.y + 1]));
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {2, 2, 3, 4}, {5, 5, 6, 6}, {7, 8, 9, 9}};
        ArrayList<Integer> list = mergeK(arr, 4);
        System.out.println(list);
    }
}
