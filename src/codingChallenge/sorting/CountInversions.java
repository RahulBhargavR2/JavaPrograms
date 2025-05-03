package codingChallenge.sorting;

public class CountInversions {
    static int count;

    private static void mergeSort(int[] arr) {
        if (arr.length == 1)
            return;
        int size = arr.length, mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        if (size - mid >= 0) System.arraycopy(arr, mid, right, 0, size - mid);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                count += left.length - i;
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = left[j++];
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 4, 1};
        count = 0;
        mergeSort(arr);
        System.out.println(count);
    }
}
