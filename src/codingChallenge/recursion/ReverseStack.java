package codingChallenge.recursion;

import java.util.Random;
import java.util.Stack;

public class ReverseStack {
    private static void reverse(Stack<Integer> st, Stack<Integer> st1){
        if (st.isEmpty())
            return;
        st1.push(st.pop());
        reverse(st,st1);
    }

    private static void print(Stack<Integer>st){
        System.out.println(st);
        Stack<Integer>s;
        reverse(st,s = new Stack<>());
        System.out.println(st);
        st = s;
        System.out.println(st);

    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st1 = new Stack<>();

        for (int i = 0; i < 10; i++) {
            st.push(new Random().nextInt(0,100));
        }
       print(st);
    }
}
