package codingChallenge.stack;

import java.util.Stack;

public class RemoveKDigits {
    private static String removeDigits(String s, int k){
        if (s.length() == k)
            return "0";
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            while (k > 0 && i < sb.length() - 1 && i >= 0) {
                if (sb.charAt(i) > sb.charAt(i + 1)) {
                    sb.deleteCharAt(i--);
                    k--;
                } else i++;
            }
        }
        int i = sb.length() - 1;
        while (k-- > 0) {
            sb.deleteCharAt(i--);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }

    public String removeKDigits(String num, int k) {
        // Base case: If K equals the length of the number, we remove all digits
        if(k==num.length()){
            return "0";
        }
        // Using a stack to store the digits of the resulting number
        StringBuilder stack=new StringBuilder();
        for(char digit: num.toCharArray()){
            // Removing the top of the stack while the current digit is smaller
            // than the top digit and we still need to remove digits
            while(!stack.isEmpty() && k>0 && stack.charAt(stack.length()-1)>digit){
                stack.deleteCharAt(stack.length()-1); // Poppint the top digit
                k--; // Decrementing the count of digits to remove
            }
            // Adding the current digit to the stack
            stack.append(digit);
        }
        // If there are still digits to remove, remove them from the end
        while(k>0){
            stack.deleteCharAt(stack.length()-1);
            k--;
        }
        // Removing leading zeroes from the result
        while(!stack.isEmpty() && stack.charAt(0)=='0'){
            stack.deleteCharAt(0);
        }
        // If the stack becomes empty, return "0"
        return stack.isEmpty() ?"0":stack.toString();
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // Remove remaining k digits from the end of the stack
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Construct the resulting string from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse(); // Reverse to get the correct order

        // Remove leading zeros
        while (!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Handle edge case where result might be empty
        return !sb.isEmpty() ? sb.toString() : "0";
    }
    public static void main(String[] args) {
        System.out.println(removeDigits("10001",4));
    }
}
