package rahul;

import java.util.Arrays;
import java.util.Random;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] arr2 = new int[10];
        int[] res = new int[20];
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = r.nextInt(20);
            arr2[i] = r.nextInt(20);
        }
        Arrays.sort(arr2);
        Arrays.sort(arr);
        int i = 0, j = 0, k = 0;
        while (i < arr.length && j < arr2.length) {
            if (arr[i] <= arr2[j]) {
                res[k++] = arr[i++];
            } else res[k++] = arr2[j++];
        }
        while (i < arr.length) {
            res[k++] = arr[i++];
        }
        while (j < arr2.length) {
            res[k++] = arr2[j++];
        }

        System.out.println("first");
        System.out.println(Arrays.toString(arr));
        System.out.println("Second\n" + Arrays.toString(arr2));
        System.out.println(Arrays.toString(res));
    }
}
