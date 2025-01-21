package rahul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class string_mani {
    public static void main(String[] args)throws IOException
    {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.println("Enter the string ");
        String a = in.readLine();
        System.out.println("Enter your choice\nFor String builder method type '1'\nFor normal algorithm method type '2' ");
        int z = Integer.parseInt(in.readLine());
        switch (z) {
            case 1 -> {
                StringBuilder bu = new StringBuilder();
                bu.append(a);
                bu.reverse();
                System.out.println("String after reversing is " + bu);
                if (a.contentEquals(bu))
                    System.out.println("String is palindrome");
                else
                    System.out.println("String is not palindrome");
            }
            case 2 -> {
                String c = "";
                for (int i = a.length() - 1; i >= 0; i--)
                    c += a.charAt(i);
                System.out.println("String after reversing is " + c);
                if (a.equals(c))
                    System.out.println("String is palindrome");
                else
                    System.out.println("String is not palindrome");
            }
            default -> System.out.println("Invalid choice ");
        }
    }
}
