package comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;


public class MergeIntervals {
    static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    private static void mergeInterval1(Interval[] arr) {
        if (arr.length == 0) return;
        Stack<Interval> intervals = new Stack<>();

        Arrays.sort(arr, Comparator.comparingInt(o -> o.start));
//        normal comparator
//          Arrays.sort(arr, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });
//        lambda function
//        Arrays.sort(arr,(a,b) -> a.start-b.start);

        intervals.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            Interval top = intervals.peek();

            if (top.end < arr[i].start)
                intervals.push(arr[i]);
            else if (top.end < arr[i].end) {
                top.end = arr[i].end;
                intervals.pop();
                intervals.push(top);
            }
        }

        while (!intervals.empty()) {
            Interval i = intervals.pop();
            System.out.print("[" + i.start + "," + i.end + "] ");
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = List.of(
//                new Interval(6, 8),
//                new Interval(1, 2),
//                new Interval(3, 4),
//                new Interval(4, 7)
                new Interval(1,4),
                new Interval(3,6)
        );
        Interval[] arr = intervals.toArray(new Interval[0]);

        mergeInterval1(arr);
    }
}