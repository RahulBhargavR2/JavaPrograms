package rahul;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisMatching {
    static Stack<Character> st;

    private static int value(char ch) {
        if (ch == '(' || ch == '{' || ch == '[') return st.push(ch);
        else if (!st.isEmpty() && priority(st.peek()) == priority(ch)) return st.pop();
        return -1;
    }

    private static int priority(char ch) {
        if (ch == '(' || ch == ')') return 1;
        if (ch == '{' || ch == '}') return 2;
        return 3;
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (value(s.charAt(i)) == -1) return false;
        }
        return st.isEmpty();
    }
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<Character>();
//        for (char c : s.toCharArray()) {
//            if (c == '(')
//                stack.push(')');
//            else if (c == '{')
//                stack.push('}');
//            else if (c == '[')
//                stack.push(']');
//            else if (stack.isEmpty() || stack.pop() != c)
//                return false;
//        }
//        return stack.isEmpty();
//    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            String st = scan.next();
            System.out.println(isValid(st));
        }


    }
}