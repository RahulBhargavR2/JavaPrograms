package rahul;

import java.util.Arrays;
import java.util.Scanner;

public class MaxScoreCricketTeam {
    private static int solve(int[] bat, int[] bow) {
        if (bat.length < 4 || bow.length < 4 || bat.length + bow.length < 11 ) return -1;
        Arrays.sort(bat);
        Arrays.sort(bow);
        int total = 0, strength = 0, i = bat.length - 1, j = bow.length - 1;
        for (int k = 0; k < 4; k++) {
            strength += bat[i--] + bow[j--];
            total += 2;
        }
        while (total < 11 && i >= 0 && j >= 0) {
            if (bat[i] >= bow[j])
                strength += bat[i--];
            else
                strength += bow[j--];
            total++;
        }
        while (total < 11 && i >= 0) {
            strength += bat[i--];
            total++;
        }
        while (total < 11 && j >= 0) {
            strength += bow[j--];
            total++;
        }
        return strength;
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int bat = scan.nextInt(), bow = scan.nextInt();
            int[] batM = new int[bat];
            int[] bowM = new int[bow];
            for (int i = 0; i < bat; i++) batM[i] = scan.nextInt();
            for (int i = 0; i < bow; i++) bowM[i] = scan.nextInt();
            System.out.println(solve(batM, bowM));
        }

    }
}
