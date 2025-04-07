package codingChallenge.arrays;

import java.util.HashMap;

public class LargestSubarrayWith0Sum {
    int maxLen(int[] arr) {
        // code here
        HashMap<Integer,Integer>map = new HashMap<>();
        int sum = 0,max = 0;
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
                max = Math.max(i - map.get(sum), max);
            }else{
                map.put(sum,i);
            }
        }
        return max;
    }
}
