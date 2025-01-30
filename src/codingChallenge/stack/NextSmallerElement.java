package codingChallenge.stack;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i : arr) {
            while (!st.isEmpty() && st.peek() >= i)
                st.pop();
            res.add(st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {34, 35, 27, 42, 5, 28, 39, 20, 28};
        ArrayList<Integer> a = new ArrayList<>();
        for (int i : arr)
            a.add(i);
        System.out.println(prevSmaller(a));
    }
}
