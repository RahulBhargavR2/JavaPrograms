package rahul;
import java.util.Scanner;
import java.util.function.Function;

public class EasyPronunciation {
    static Function<Character,Boolean> isVowel = c -> "AEIOU".indexOf(Character.toUpperCase(c)) != -1;
    private static boolean isVowel(char ch){
        return "AEIOU".indexOf(Character.toUpperCase(ch)) != -1;
    }
    private static String checker(String st,int len){
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (!isVowel.apply(st.charAt(i))){
                count++;
                if (count>=4)return "YES";
            }
            else count = 0;
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-->0){
            int len = scan.nextInt();
            String st = scan.next();
            System.out.println(checker(st,len));
        }
    }
}
