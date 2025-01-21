package rahul;

import java.util.HashMap;
import java.util.Scanner;
public class MigratoryBirds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= 5; i++)
            map.put(i, 0);

        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();
            map.put(num, map.get(num) + 1);
        }

        int[]max={(-1)};
        map.forEach((key, value) -> {
            if (value > max[0])
                max[0] = (value);
        });

        for(int i = 1; i <= 5; i++){
            if(max[0] == map.get(i)){
                System.out.println(i);
                 break;
            }
        }
    }
}