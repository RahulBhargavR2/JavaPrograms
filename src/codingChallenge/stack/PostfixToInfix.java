package codingChallenge.stack;

import java.util.Scanner;
import java.util.Stack;

public class PostfixToInfix {
    private static String postfixToInfix(String s) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch))
                st.push(ch + "");
            else {
                String sec = st.pop(), fir = st.pop();
                StringBuilder sb = new StringBuilder();
                sb.insert(0, "(");
                sb.append(fir).append(ch).append(sec).append(")");
                st.push(sb.toString());
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            String s = scan.next();
            System.out.println(postfixToInfix(s));
        }
    }
}
