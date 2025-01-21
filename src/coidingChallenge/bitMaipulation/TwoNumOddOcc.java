package coidingChallenge.bitMaipulation;

import java.util.HashMap;
import java.util.Map;

public class TwoNumOddOcc {
    private static int[] usingMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i))
                map.put(i, map.get(i) - 1);
            else map.put(i, 1);
        }
        int[] res = new int[2];
        int count = 0;
        for (int i : map.keySet()) {
            if (i != 0)
                res[count] = i;
            count++;
        }
        if (res[0] < res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return res;
    }


    //    intuition is that when 2 numbers are XOR ed then the set bit of resultant number is due to the
//    difference in bits of the XOR ed number
//    eg 2 ^ 3 -> 10 ^ 11 -> 01, here the set bit of result is generated due to difference in bits,
//    as XOR of a element even no of times tends to zero , whereas odd time tends to the same number
    private static int[] usingXOR(int[] arr) {
        int res = 0;
        for (int i : arr)
            res ^= i;
        int dup = res, pos = 0;

//        int lastSetBitNum = res & -res; used to find last set bit of a number , doesn't provide position
//        or int lastSetBitNum = res & (~(res-1));
        while ((dup & 1) != 1) {
            pos++;
            dup >>= 1;
        }
        int fir = 0, sec = 0;

//        for(int i : arr){
//            if((i & lastSetBitNum) == 0)
//                fir ^= i;
//            else sec ^= i;
//        }
        for (int i : arr) {
            if ((i & (1 << pos)) != 0)
                fir ^= i;
            else sec ^= i;
        }


        return new int[]{Math.max(fir, sec), Math.min(fir, sec)};
    }
}
