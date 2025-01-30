package codingChallenge.stack;

import java.util.*;


public class NextGreaterElement {
    public static int[] nextGreater(int[] query, int[] arr) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            while (!st.isEmpty() && st.peek() < i)
                map.put(st.pop(), i);
            st.push(i);
        }
        System.out.println(st);
        for (int i = 0; i < query.length; i++) {
            query[i] = map.getOrDefault(query[i], -1);
        }
        return query;
    }

    private static int[] nextGreater2(int[] arr) {
        int n = arr.length;
        int[] a = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i % n])
                st.pop();

            if (!st.isEmpty())
                a[i % n] = st.peek();
            st.push(arr[i % n]);
        }

        return a;
    }

    private static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] a = new int[n];

        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i % n])
                st.pop();
            if (!st.isEmpty())
                a[i % n] = st.peek();
            st.push(arr[i % n]);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] query = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] arr = {1, 0, 2, 0, 0};
        System.out.println(Arrays.toString(nextGreater(arr)));
    }
}
