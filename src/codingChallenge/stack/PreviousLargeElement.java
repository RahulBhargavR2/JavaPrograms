package codingChallenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreviousLargeElement {
    public static int[] previousLargeElement(int[]arr){
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=arr.length-1;i>=0;i--){
            while (!st.isEmpty() && st.peek()<arr[i])
                st.pop();
            arr[i] = st.isEmpty()?-1:st.peek();
            st.push(arr[i]);
        }
        return arr;
    }
}
