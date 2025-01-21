package rahul;

import java.util.Scanner;

public class CountingSort
{
    public static void main(String[]args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n= scan.nextInt();
        int[] arr =new int[n];
        int[]ar=new int[100];
        System.out.println("Enter the elements into array");
        for(int i=0;i<n;i++)
            arr[i]= scan.nextInt();
        for(int i=0;i<n;i++)
            ar[arr[i]]++;

        for (int j : ar)
            System.out.print(j + " ");

    }
}
