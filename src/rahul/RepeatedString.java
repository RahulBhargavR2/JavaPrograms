//program to find the no of occurrences of a char in given no of substring
package rahul;

import java.util.Scanner;

public class RepeatedString {
    private static long count(String st, long n){
        int length = st.length();
        int noOfa = (int) st.chars().filter(ch -> ch=='a').count();
        long counted = n / length;
        long noOfA = counted*noOfa;
        long remaining = n % length;
        noOfA += st.substring(0, (int) remaining).chars().filter(ch -> ch == 'a').count();
        return noOfA;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String st = scan.next();
        long n = scan.nextLong();
        System.out.println(count(st,n));

    }
}