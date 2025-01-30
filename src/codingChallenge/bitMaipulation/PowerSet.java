package codingChallenge.bitMaipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    //    using bitwise methods ,
//    when the size of array is n then the number of possible subsets are 2 ^ n,
//    which is same as no of elements that can be generated for a no of bits n,
//    ie if the size is 4 then 2 ^ 4 numbers can be generated , each number will have unique bit pattern
//    eg 2,
//    00, 01, 10, 11,
//    using this method we can consider the set bits as the elements that is to be included in it,
//    which ensures all the possible sets are generated, time -> O(2^n)
    private static List<List<Integer>> usingBit(int[] arr) {
        List<List<Integer>> powerSet = new ArrayList<>(1 << arr.length);
        int size = arr.length;
        for (int i = 0; i < (1 << size); i++) {
            List<Integer> subSet = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                int pos = i & (1 << j);
                if (pos > 0)
                    subSet.add(arr[j]);
            }
            powerSet.add(subSet);
        }
        return powerSet;
    }

    // using recursion


    public static void main(String[] args) {

    }

}
