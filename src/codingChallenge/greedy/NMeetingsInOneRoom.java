package codingChallenge.greedy;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class NMeetingsInOneRoom {
    static class Meetings implements Comparable<Meetings> {
        int start;
        int end;

        public Meetings(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(@NotNull Meetings o) {
            return Integer.compare(this.end, o.end);
        }

        @Override
        public String toString() {
            return "{" +
                    "start=" + start +
                    ", end=" + end +
                    "}";
        }
    }

    private static int meetings(int[] start, int[] end) {
        Meetings[] meetings = new Meetings[start.length];
        for (int i = 0; i < start.length; i++) {
            meetings[i] = new Meetings(start[i], end[i]);
        }
        Arrays.sort(meetings);
        int e = meetings[0].end, count = 1;
        for (int i = 1; i < meetings.length; i++) {
            if (e < meetings[i].start) {
                count++;
                e = meetings[i].end;
            }
        }
        System.out.println(Arrays.toString(meetings));
        return count;
    }

    public static void main(String[] args) {
        int[] start = {25, 0, 14, 24, 18, 3, 17};
        int[] end = {29, 25, 24, 26, 25, 23, 18};
        System.out.println(meetings(start, end));
    }
}
