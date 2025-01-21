package rahul;

import java.util.HashMap;
import java.util.Scanner;

public class SumOfTarget {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int target = scanner.nextInt();

        for (int j = 0; j < k; j++) {
            int n = scanner.nextInt();

            int[] num = new int[n];

            for (int i = 0; i < n; i++)
                num[i] = scanner.nextInt();

            for (int i = 0; i < num.length; i++) {
                Integer a = map.get(num[i]);
                if (a != null)
                    System.out.println(i + " " + a);
                map.put(target - num[i], i);

            }
        }
    }
}
