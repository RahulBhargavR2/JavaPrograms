package rahul;

import java.util.Random;
import java.util.Scanner;
public class Insertion_Sort_2
{
    //filling array with random integers
    public static void initialization(int size,int[]arr){
        Random random = new Random();
        for (int i=0; i < size; i++)
            arr[i]= random.nextInt(100);
    }
    //sorting array
    public static void insertionSort(int[]arr){
        for (int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i-1;
            while (j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }

    }

    public static void printArray(int[]arr){
        for(int i:arr)
            System.out.print(i+" ");
    }

    public static void main(String[]args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=scan.nextInt();
        int[]arr=new int[n];
        initialization(n,arr);
        System.out.println("Before");
        printArray(arr);
        System.out.println("\nAfter");
        insertionSort(arr);
        printArray(arr);
    }
}