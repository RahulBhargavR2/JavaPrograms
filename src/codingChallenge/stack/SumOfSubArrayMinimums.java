package codingChallenge.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SumOfSubArrayMinimums {
    //more towards Dynamic programming
    private static int sumSubArrayMin(int[] arr) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            // use ">=" to deal with duplicate elements
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                stack.pop();
            }

            int j = stack.isEmpty() ? -1 : stack.peek()[1];
            res[i] = stack.isEmpty() ? arr[i] * (i + 1) : res[j] + arr[i] * (i - j);
            stack.push(new int[]{arr[i], i});
        }

        long MOD = (long) 1000000007;
        long ans = 0;

        for (int i = 0; i < arr.length; i++) {
            ans = (ans + (long) res[i]) % MOD;
        }
        return (int) ans;
    }
    public static int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];

        Arrays.fill(left, -1);
        Arrays.fill(right, length);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int mod = (int) 1e9 + 7;
        long answer = 0;

        for (int i = 0; i < length; ++i) {
            answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }

        return (int) answer;
    }
    //using previous and next smaller element concept
    public static int sumSubarrayMins2(int[] arr) {
        Deque<Integer>st = new ArrayDeque<>();
        int len = arr.length;
        int[] previousSmall = new int[len];
        int[] nextSmall = new int[len];
        for(int i = 0;i<len;i++){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
                st.pop();
            previousSmall[i] = st.isEmpty()?i+1:i-st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = len-1;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]>arr[i])
                st.pop();
            nextSmall[i] = st.isEmpty()?len-i:st.peek()-i;
            st.push(i);
        }
        System.out.println(Arrays.toString(previousSmall));
        System.out.println(Arrays.toString(nextSmall));
        long mod = 1000000007,sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += ((long) previousSmall[i] * nextSmall[i]) % mod * arr[i] % mod;
            sum %= mod;
        }
        return (int)sum;
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins2(new int[]{2,4,6,4,14,5,1,3}));
    }
}
