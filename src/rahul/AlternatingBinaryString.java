package rahul;

import java.util.Scanner;

public class AlternatingBinaryString {

    private static int check(String s, int size) {
        int count = 0;
        for (int i = 0; i < size - 1; i++)
            if (s.charAt(i) == s.charAt(i + 1))
                count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int size = scan.nextInt();
            String s = scan.next();
            System.out.println(check(s, size));
        }
    }
}
