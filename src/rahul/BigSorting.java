package rahul;

import java.math.BigInteger;
import java.util.*;

public class BigSorting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        ArrayList<String>arr = new ArrayList<>();
        ArrayList<BigInteger>a = new ArrayList<>();

        for (int i = 0; i < n; i++)
            arr.add(scan.next());

        for (int i =0;i<n;i++)
            a.add(new BigInteger(arr.get(i)));

        Collections.sort(a);
        System.out.println(a);

    }
}
