package codingChallenge.arrays;

public class NextPermutation {
    private static void reverse(int[] arr) {
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    void nextPermutation(int[] arr) {
        //breakpoint is the position where the current element is larger than
        // its previous element from rear end of array  we do this because we need to find the next greatest number
        // available in the permutation
        int breakPoint = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                breakPoint = i - 1;
                break;
            }
        }
//        the element of array are in such order that no greater element can be chosen from the given elements
        // then we need to return the reverse of the array
        if (breakPoint == -1) {
            reverse(arr);
            return;
        }
        //swap the breakpoint element with then next largest element from end for array
        for (int i = arr.length - 1; i > breakPoint; i--) {
            if (arr[breakPoint] < arr[i]) {
                int temp = arr[breakPoint];
                arr[breakPoint] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        reverse(arr, breakPoint + 1, arr.length - 1);
    }
}
