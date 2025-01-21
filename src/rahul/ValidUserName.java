package rahul;

import java.util.Scanner;
import java.util.regex.*;


public class ValidUserName{

    private static String checker(String s){
       int len = s.length();
       if (len <8 || len > 30) return "Invalid";
       Pattern pattern = Pattern.compile("[^a-zA-Z0-9_]");
       Matcher matcher = pattern.matcher(s);
       if (matcher.find()) return "Invalid";
       return "Valid";

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-->0){
            String s = scan.next();
            System.out.println(checker(s));
        }
    }
}