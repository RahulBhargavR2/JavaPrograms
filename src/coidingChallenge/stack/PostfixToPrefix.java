package coidingChallenge.stack;

import java.util.Stack;

public class PostfixToPrefix {
//    Read the Postfix expression from left to right
//    If the symbol is an operand, then push it onto the Stack
//    If the symbol is an operator, then pop two operands from the Stack
//    Create a string by concatenating the two operands and the operator before them.
//            string = operator + operand2 + operand1
//    And push the resultant string back to Stack
//    Repeat the above steps until end of Postfix expression.

//    first follow normal procedure of postfix to infix but rather than printing the result locally convert it to
//    prefix to that we can skip the process of double conversion
    static String postToPre(String s) {
        // code here
        Stack<String> st = new Stack<>();
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch))
                st.push(ch+"");
            else{
                String op1 = st.pop();
                String op2 = st.pop();
                StringBuilder sb = new StringBuilder();
                sb.append(ch)
                        .append(op2)
                        .append(op1);
                st.push(sb.toString());
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {

    }
}
