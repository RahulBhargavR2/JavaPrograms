package rahul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// use extra space otherwise it won't work
public class AlternatingSigns {
    private static void rearrange(ArrayList<Integer> arr) {
        // code here

        int pos = 0, neg = 1, size = arr.size(), i = 0;
        ArrayList<Integer> fin = new ArrayList<>(Collections.nCopies(size,0));

        System.out.println(fin);
        while (pos < size && neg < size) {
            if (arr.get(i) >= 0) {
                fin.set(pos,arr.get(i));
                pos += 2;
            } else {
                fin.set(neg,arr.get(i));
                neg += 2;
            }
            i++;
        }
        while (pos < size) {
            fin.set(pos,arr.get(pos));
            pos++;
        }
        while (neg < size) {
            fin.set(neg,arr.get(neg));
            neg++;
        }
        arr.clear();
        arr.addAll(fin);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(35, -43, 29, 32, 29, -37, 46, 39, -3, -43, -19, 32, 43, 27, 28, 11, 43, -21, -35, -25, -2, 36, -13, -6, 2, -45, -37, -4, -37, 35, -46, 5, -13, 10, 41, -34, -30, 28, -47, -9, 26, 21, -44, 17, 16, -5, 39, 14, -35, 24, -9, 12, -15, 31, -32, 32, 47, 16, -30
        ));
        System.out.println(arr.size());
        rearrange(arr);
        System.out.println(arr);
    }
}
