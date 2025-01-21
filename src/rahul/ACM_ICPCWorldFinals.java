package rahul;

import java.util.Arrays;
import java.util.Scanner;

public class ACM_ICPCWorldFinals
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] arr = new  String[n];
        for (int i = 0; i < n; i++) {
            arr[i]= scan.next();
        }

        System.out.println(Arrays.toString(arr));
    }
}
