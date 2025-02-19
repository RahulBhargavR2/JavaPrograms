package codingChallenge.greedy;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MinimumPlatform {
    private static class Train implements Comparable<Train>{
        int arrival;
        int departure;

        public Train(int arrival, int departure) {
            this.arrival = arrival;
            this.departure = departure;
        }

        @Override
        public int compareTo(@NotNull Train o) {
//            return Integer.compare(this.departure,o.departure);
            return Integer.compare(this.arrival,o.arrival);
        }

        @Override
        public String toString() {
            return "[Arrival = "+this.arrival+",Departure = "+this.departure+"]\n";
        }
    }

    private static int minPlatform(int[] arr, int[] dep){
        Train[] trains = new Train[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            trains[i] = new Train(arr[i],dep[i]);
        }
        Arrays.sort(trains);
        System.out.println(Arrays.toString(trains));
        int platforms = 0;
        int currMax = trains[0].departure;
        for(int i=1;i<trains.length;i++){
            if (trains[i].arrival<currMax){
                platforms++;
            }
            currMax = Math.max(currMax,trains[i].departure);
        }


        System.out.println(platforms);
        return platforms;
    }

    public static void main(String[] args) {
        int[]arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
//        int[]arr={1000, 935, 1100};
//        int[]dep={1200, 1240, 1130};
//        Train[] trains = new Train[arr.length];
//        for (int i = 0; i < arr.length ; i++) {
//            trains[i] = new Train(arr[i],dep[i]);
//        }
//        Arrays.sort(trains);
//        System.out.println(Arrays.toString(trains));
        minPlatform(arr,dep);

    }
}
