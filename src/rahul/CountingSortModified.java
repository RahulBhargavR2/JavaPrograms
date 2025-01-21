package rahul;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CountingSortModified {
    private static void CountingSort(long[]arr){
        Map<Long,Long> map = new HashMap<>();
        for (Long j : arr) {
            if (map.get(j) == null) map.put(j, 1L);
            else map.put(j, map.get(j) + 1);
        }
        for (Map.Entry<Long,Long> set:map.entrySet()){
            for (int i = 0; i < set.getValue(); i++) {
                System.out.println(set.getKey());
            }
        }
//        map.forEach((key,value)->{
//            for (int i = 0; i < value; i++) {
//                System.out.println(key);
//            }
//        });
//        System.out.println(map);

    }
    public static void main(String[] args) {
        Random random = new Random();
        long[] arr = new long[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextLong(1000);
        }
        CountingSort(arr);

    }
}
