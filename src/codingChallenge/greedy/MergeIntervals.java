package codingChallenge.greedy;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {
    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(@NotNull Interval o) {
            return Integer.compare(this.start, o.start);
        }
    }

    private static int[][] mergeIntervals(int[][] arr) {
        Interval[] intervals = new Interval[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intervals[i] = new Interval(arr[i][0], arr[i][1]);
        }
        Arrays.sort(intervals);
        Stack<Interval> st = new Stack<>();
        st.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval top = st.peek();

            if (top.end < intervals[i].start)
                st.push(intervals[i]);
            else if (top.end < intervals[i].end) {
                top.end = intervals[i].end;
                st.pop();
                st.push(top);
            }
        }
        int[][] res = new int[st.size()][2];
        for (int i = st.size() - 1; !st.isEmpty(); i--) {
            Interval in = st.pop();
            res[i][0] = in.start;
            res[i][1] = in.end;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
