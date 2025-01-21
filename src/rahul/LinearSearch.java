package rahul;

import java.util.Scanner;

public class LinearSearch {
    private int linear(int[] arr,int n,int ele){
        if (n > arr.length-1) return -1;
        if (arr[n] == ele) return n;
        return linear(arr,++n,ele);
    }
    private int linear(int[] arr,int ele){
        return linear(arr,0,ele);
    }
    public void Linear(int[] arr, int ele) {
        long start=System.nanoTime();
        int pos=-1;
        int n=arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == ele)
                pos = i;
        }
        long end = System.nanoTime();
        if (pos != -1)
            System.out.println("Element found at " + pos + " position");
        else
            System.out.println("Element not found");
        System.out.println("Run time is " + (end - start));
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,8,9};


        System.out.println(new LinearSearch().linear(arr,9));


    }
}
