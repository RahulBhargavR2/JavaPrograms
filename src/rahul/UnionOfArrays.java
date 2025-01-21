package rahul;

import java.util.ArrayList;

public class UnionOfArrays {
    private static ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(Math.min(a[0], b[0]));
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                if (arr.get(k) < a[i]) {
                    arr.add(a[i]);
                    k++;
                }
                i++;
            } else {
                if (arr.get(k) < b[j]) {
                    arr.add(b[j]);
                    k++;
                }
                j++;
            }
        }
        while (i < a.length) {
            if (arr.get(k) < a[i]) {
                arr.add(a[i]);
                k++;
            }
            i++;
        }
        while (j < b.length) {
            if (arr.get(k) < b[j]) {
                arr.add(b[j]);
                k++;
            }
            j++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {5, 6, 7, 8};
        int[] b = {1, 2, 3, 4};
        System.out.println(findUnion(a, b));
    }
}
