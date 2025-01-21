package rahul;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CardSwipe {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int swipes = scan.nextInt();
            int[] arr = new int[swipes];
            for (int i = 0; i < swipes; i++) {
                arr[i] = scan.nextInt();
            }
            Map<Integer, Boolean> map = new HashMap<>();
            int peopleCount = 0, max = 0;
            for (int i = 0; i < swipes; i++) {
                if (map.get(arr[i]) == null || !map.get(arr[i])) {
                    map.put(arr[i], true);
                    peopleCount++;
                } else {
                    map.put(arr[i], false);
                    peopleCount--;
                }
                max = Math.max(max, peopleCount);
            }
            System.out.println(max);
        }
    }
}
