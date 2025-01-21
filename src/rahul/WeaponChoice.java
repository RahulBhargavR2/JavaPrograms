package rahul;

import java.util.Scanner;

public class WeaponChoice {
    private static int minimumHits(int hp, int x, int y1, int y2, int k) {
        int xHits = (int) Math.ceil(hp/(double)x);
        int TotalY1Damage = y1 * k;
        int remHp = (hp>TotalY1Damage)? hp-TotalY1Damage : 0;
        int yHitsPossible = (int) Math.ceil(hp/(double)y1);
        int yHits =  Math.min(yHitsPossible, k)+ (int) Math.ceil((double) remHp/y2);
        return Math.min(xHits, yHits);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n--> 0) {
            int hp = scan.nextInt();
            int x = scan.nextInt();
            int y1 = scan.nextInt();
            int y2 = scan.nextInt();
            int k = scan.nextInt();

            System.out.println(minimumHits(hp, x, y1, y2, k));
        }
    }
}
