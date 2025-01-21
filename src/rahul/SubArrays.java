package rahul;

public class SubArrays {
    private static void printSubArray(int[] arr, int start, int end) {
        if (end == arr.length) return;
        if (start > end) printSubArray(arr, 0, end + 1);
        else {
            for (int i = start; i <= end; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
            printSubArray(arr, start + 1, end);
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        printSubArray(arr, 0, 0);
    }
}
