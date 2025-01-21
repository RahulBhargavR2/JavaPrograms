package rahul;

import java.util.Scanner;
import java.util.ArrayList;

public class Happy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> ar = new ArrayList<>();
        System.out.println("Enter the starting,ending and dividing number");
        int q = scan.nextInt();//starting num
        int w = scan.nextInt();//ending num
        int e = scan.nextInt();//dividing num
        for (int i = q; i <= w; i++)
            arr.add(i);
        for (int i = q; i <= w; i++) {
            int z = i;
            int rem, dig = 0;
            while (z != 0) {
                rem = z % 10;
                dig = dig * 10 + rem;
                z = z / 10;
            }
            ar.add(dig);
        }
        int r = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (Math.abs(arr.get(i) - ar.get(i)) % e == 0)
                r++;
        }
        System.out.println(r);

    }
}
