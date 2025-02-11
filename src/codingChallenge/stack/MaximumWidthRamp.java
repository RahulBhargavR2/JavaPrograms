package codingChallenge.stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumWidthRamp {
    private static int[] nextGreater(int[] arr, Map<Integer,Integer>map){
        Stack<Integer> st = new Stack<>();
        for (int i =0;i<arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i])
                map.put(arr[st.pop()], i);
            st.push(i);
        }
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = map.getOrDefault(arr[i], -1);
        }
        return temp;
    }

    private static  int maxWidthRamp(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int[] next = nextGreater(arr,map);
        int max = -1, ele=0;
        for(int i=0;i<arr.length;i++){
            while(map.get(arr[i])!=-1){
                max = Math.max(max,ele);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {6,0,8,2,1,5};
        maxWidthRamp(arr);
    }
}
