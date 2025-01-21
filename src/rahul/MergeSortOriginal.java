package rahul;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
public class MergeSortOriginal{
    public static void mergeSort(int[] arr){
        int size = arr.length;
        if (size < 2)
            return;
        int midIndex = size/2;

//
//        for (int i =0 ; i<midIndex; i++)
//            leftHalf[i] = arr[i];
        int[] leftHalf = Arrays.copyOfRange(arr,0,midIndex);
//        for (int i = midIndex; i<size; i++)
//            rightHalf[i - midIndex] = arr[i];
        int[] rightHalf = Arrays.copyOfRange(arr,midIndex,size);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(arr,leftHalf,rightHalf);
    }

    private static int inversionCount(int[] arr){
        return 0;
    }
    public static void merge(int[] arr, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i=0, j=0, k=0;
        while (i < leftSize && j < rightSize){
            if (leftHalf[i] <= rightHalf[j]){
                arr[k] = leftHalf[i++];
            }
            else {
                arr[k] = rightHalf[j++];
            }
            k++;
        }
        while (i < leftSize){
            arr[k++] = leftHalf[i++];
        }
        while (j < rightSize){
            arr[k++] = rightHalf[j++];
        }
    }

    public static void printArray(int[] arr){
        for (int i: arr)
            System.out.print(i+" ");
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++)
            arr[i] = rand.nextInt(1000);
        long s = System.currentTimeMillis();
        mergeSort(arr);
        long e = System.currentTimeMillis();
        System.out.println("Time = "+(e-s));
        printArray(arr);
    }
}
