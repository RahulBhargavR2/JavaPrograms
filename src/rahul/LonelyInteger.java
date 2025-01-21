package rahul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class LonelyInteger {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        ArrayList<Integer>arr=new ArrayList<>();
        ArrayList<Integer>ar=new ArrayList<>();
        System.out.println("Enter the size of array");
        int n=scan.nextInt();
        System.out.println("Enter the elements into array");
        for(int i=0;i<n;i++)
            arr.add(scan.nextInt());
        int m= Collections.max(arr);
        if(m>n)
        {
            for(int i=0;i<=m;i++)
                ar.add(0);
        }
        else
        {
            for(int i=0;i<=n;i++)
                ar.add(0);
        }

        for (int i : arr) {
            ar.set(i, ar.get(i) + 1);
        }
        for(int i=0;i<ar.size();i++)
        {
            if(ar.get(i)==1)
            {
                System.out.println(i);
            }
        }
    }
}