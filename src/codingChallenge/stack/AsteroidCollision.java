package codingChallenge.stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    private static boolean isSameSign(int n, int m) {
        return n < 0 && m < 0 || n > 0 && m > 0;
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            if (st.isEmpty()) {
                st.push(asteroid);
                continue;
            }
            if (isSameSign(asteroid, st.peek()))
                st.push(asteroid);
            else {
                if (asteroid < 0) {
                    while (!st.isEmpty() && !isSameSign(st.peek(), asteroid) && Math.abs(st.peek()) < Math.abs(asteroid))
                        st.pop();
                    if (st.isEmpty())
                        st.push(asteroid);
                    else if (st.peek() == Math.abs(asteroid))
                        st.pop();
                    else if (!st.isEmpty() && st.peek() < Math.abs(asteroid))
                        st.push(asteroid);
                } else
                    st.push(asteroid);
            }
        }
        int[] res = new int[st.size()];
        for (int i = res.length - 1; !st.isEmpty(); i--) {
            res[i] = st.pop();
        }
        return res;
    }

    private static int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!st.isEmpty() && (st.peek() > 0 && asteroid < 0)) {
                if (Math.abs(st.peek()) < Math.abs(asteroid)) {
                    st.pop();
                    continue;
                } else if (Math.abs(st.peek()) == Math.abs(asteroid)) {
                    st.pop();
                }
                flag = false;
                break;
            }
            if (flag) {
                st.push(asteroid);
            }
        }
        int[] remainingAsteroids = new int[st.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = st.peek();
            st.pop();
        }
        return remainingAsteroids;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -2, 1, -2};
        System.out.println(Arrays.toString(asteroidCollision2(arr)));
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }
}
