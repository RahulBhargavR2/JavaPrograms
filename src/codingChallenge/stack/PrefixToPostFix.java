package codingChallenge.stack;

import java.util.Stack;

public class PrefixToPostFix {
    //    Read the Prefix expression from right to left
//    If the symbol is an operand, then push it onto the Stack
//    If the symbol is an operator, then pop two operands from the Stack
//    Create a string by concatenating the two operands and the operator before them.
//            string = operand1 + operand2 + operator
//    And push the resultant string back to Stack
//    Repeat the above steps until end of Prefix expression.
    //    first follow normal procedure of postfix to infix by
    //     reading the string in reverse rather than printing the result locally convert it to
//    postfix to that we can skip the process of double conversion
    static String preToPost(String s) {
        // code here
        Stack<String> st = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch))
                st.push(ch + "");
            else {
                String op1 = st.pop();
                String op2 = st.pop();
                StringBuilder sb = new StringBuilder();
                sb.append(op1).append(op2).append(ch);
                st.push(sb.toString());
            }
        }
        return st.pop();
    }

}
