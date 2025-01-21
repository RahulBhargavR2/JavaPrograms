package rahul;

import java.util.Map;
import java.util.Scanner;

public class RockPaperScissors {
    private static final Map<Character, Character>
            rpc = Map.of('R', 'P',
                        'P', 'S',
                        'S', 'R'
                 );

    private static int check(String s, int len) {
        int wins = 0;
        char ch = rpc.get(s.charAt(0));
        for (int i = 1; i < len; i++) {
            if (rpc.get(s.charAt(i)) != ch) {
                wins++;
                ch = rpc.get(s.charAt(i));
            }
            else ch = rpc.get(ch);
        }


        return wins;
    }

    public static void main(String[] args)  {
        // your code goes here
//

        System.out.println(rpc);
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int len = scan.nextInt();
            String s = scan.next();
            System.out.println(check(s, len));
        }

    }
}
