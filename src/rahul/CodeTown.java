package rahul;

import java.util.Scanner;
import java.util.function.Function;

public class CodeTown {
//    private static Function<Character, Boolean> isVowel = character ->
//            "AEIOU".indexOf(Character.toUpperCase(character)) != -1;

    private static boolean isVowel(char ch) {
        return "AEIOU".indexOf(ch) != -1;
    }

    private static String isPossible(String s) {
        boolean b = true;
        for (int i = 1; i <= 5; i += 2)
            b &= isVowel(s.charAt(i));

        for (int i = 0; i < 7; i += 2)
            b &= !isVowel(s.charAt(i));

        b &= !isVowel(s.charAt(7));
        return b ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            String s = scan.next();
            System.out.println(isPossible(s));
        }
    }
}