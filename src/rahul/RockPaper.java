package rahul;

import java.util.HashMap;
import java.util.Scanner;

public class RockPaper {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        HashMap<Character,Integer>rock = new HashMap<>();
        rock.put('P',1);
        rock.put('R',2);
        rock.put('S',3);
        while (n-->0) {
            int len = scan.nextInt();
            String chef = scan.next();
            String elen = scan.next();
            int cs = 0,es=0;
            for (int i = 0; i < chef.length(); i++) {
                int c1 = rock.get(chef.charAt(i)),c2 = rock.get(elen.charAt(i));
                if (c1 == c2) continue;
                int s = c1-c2;
                if (s == -1 || s == 2 ) cs++;
                else es++;
            }
//            System.out.println("chef " +cs + " "+ "cheffing "+ es);
            int diff =  cs - es;
            if (len == 0 || len == 1) System.out.println(1);
            else if (diff > 0) System.out.println(0);
            else if (diff == 0) System.out.println(1);
            else System.out.println(Math.abs(diff));
        }
    }
}