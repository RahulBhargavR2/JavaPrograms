package codingChallenge.greedy;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();
        int sCount = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                sCount++;
                continue;
            }
            if(ch == '(')
                st.push(')');
            else if(!st.isEmpty()){
                st.pop();
            }else if(sCount > 0)
                sCount--;
            else return false;
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        System.out.println(checkValidString(s));
    }
}
