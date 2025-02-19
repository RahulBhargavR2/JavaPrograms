package codingChallenge.greedy;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FractionalKnapsack {
    static class KnapSack implements Comparable<KnapSack> {
        int value;
        int weight;
        double vwRatio;

        public KnapSack(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.vwRatio = (double) value / weight;
        }

        @Override
        public int compareTo(@NotNull KnapSack o) {
            return Double.compare(o.vwRatio, this.vwRatio);
        }

        @Override
        public String toString() {
            return "[" + this.value + "," + this.weight + "," + this.vwRatio + "]";
        }
    }


    private static double fractionalKnapsack(List<Integer> value, List<Integer> weight, int capacity) {
        List<KnapSack> list = new ArrayList<>(value.size());
        for (int i = 0; i < value.size(); i++) {
            list.add(new KnapSack(value.get(i), weight.get(i)));
        }
        Collections.sort(list);
        double maxValue = 0.0D;
        int currWeight = 0, i = 0;
        for (; i < list.size(); i++) {
            KnapSack k = list.get(i);
            if (currWeight + k.weight > capacity)
                break;
            currWeight += k.weight;
            maxValue += k.value;
        }
        if (currWeight < capacity) {
            maxValue += list.get(i).vwRatio * (capacity - currWeight);
        }
//        System.out.println(list);
        return maxValue;
    }

    public static void main(String[] args) {
        List<Integer> val = new ArrayList<>(List.of(60, 100, 120));
        List<Integer> wei = new ArrayList<>(List.of(10, 20, 30));
        System.out.println(fractionalKnapsack(val, wei, 50));
    }
}
