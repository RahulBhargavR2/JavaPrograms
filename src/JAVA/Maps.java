package JAVA;

import java.util.HashMap;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(101, 6);
        hashMap.put(102, 8);
        hashMap.put(103, 10);
        hashMap.put(104, 5);

        hashMap.replace(102, hashMap.get(102), hashMap.get(102) + 1);
        System.out.println(hashMap);
    }


}

