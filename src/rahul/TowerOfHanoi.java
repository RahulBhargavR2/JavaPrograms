package rahul;

import java.util.Scanner;

public class TowerOfHanoi {
    private void tower(int n,Tower a,Tower c,Tower b){
        if(n == 1){
            System.out.println("Move disc 1 from pole "+ a +" to "+c);
            return;
        }
        tower(n-1,a,b,c);
        System.out.format("move disc %d from %s to %s\n",n,a,c);
        tower(n-1,b,c,a);

    }

    public static void main(String[] args) {
        TowerOfHanoi hanoi = new TowerOfHanoi();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no of discs");
        int n = scan.nextInt();
        hanoi.tower(n,Tower.a,Tower.c,Tower.b);
    }
}
enum Tower{
a,b,c
}
