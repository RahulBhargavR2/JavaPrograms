package codingChallenge.stack;

import java.util.Stack;

public class InfixToPostfix {
    static int priority(char ch) {
        if (ch == '^')
            return 3;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '+' || ch == '-')
            return 1;
        return 0;
    }

    public static String infixToPostfix(String s) {
        // Your code here
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch))
                sb.append(ch);
            else if (ch == '(')
                st.push('(');
            else if (ch == ')') {
                char c;
                while (!st.isEmpty() && (c = st.pop()) != '(')
                    sb.append(c);
            }else {
                while (!st.isEmpty() && priority(ch) <= priority(st.peek()))
                    sb.append(st.pop());
                st.push(ch);
            }
        }
        while (!st.isEmpty())
            sb.append(st.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(s));
    }
}