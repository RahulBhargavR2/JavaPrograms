package rahul;

import java.io.*;
import java.util.Random;

public class MergeSort {

    public static void input(int[]arr)  {
        Random random = new Random();
        for (int i = 0; i<arr.length;i++)
            arr[i] = random.nextInt(100000);

    }

    public static void output(int[]arr) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("C:\\Users\\Toshiba\\Desktop\\FilesOutput\\MergedTenMillion.txt"));
            for (int j : arr) {
                writer.write(String.valueOf(j));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mergeSort(int[] arr){
        int size = arr.length;
        if (size < 2)
            return;
        int midIndex = size/2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[size - midIndex];

        for (int i =0 ; i<midIndex; i++)
            leftHalf[i] = arr[i];
        for (int i = midIndex; i<size; i++)
            rightHalf[i - midIndex] = arr[i];

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(arr,leftHalf,rightHalf);
    }

    public static void merge(int[] arr, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i=0, j=0, k=0;
        while (i < leftSize && j < rightSize){
            if (leftHalf[i] <= rightHalf[j]){
                arr[k] = leftHalf[i];
                i++;
            }
            else {
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftSize){
            arr[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize){
            arr[k] = rightHalf[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = new int[10000000];
        input(arr);
        long s = System.currentTimeMillis();
        mergeSort(arr);
        long e = System.currentTimeMillis();
        output(arr);
        System.out.println("Time = "+(e-s));

    }
}
