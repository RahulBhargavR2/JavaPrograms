package codingChallenge.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MonotonicStack {
    private static Stack<Integer> increasingStack(int[] arr) {
        Stack<Integer>st = new Stack<>();
        for(int i:arr){
            while (!st.isEmpty() && st.peek()>i)
                st.pop();
            st.push(i);
        }
        return st;
    }

    private static List<Integer> decreasingStack(int[] arr){
        Stack<Integer> st = new Stack<>();
        List<Integer>list =  new ArrayList<>();
        for (int i:arr){
            while (!st.isEmpty()&&st.peek()<i)
                st.pop();
            if(!st.isEmpty())
                list.add(st.peek());
            st.push(i);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr ={1,4,3,2,2,1,9} ;
        System.out.println(decreasingStack(arr));
    }
}
