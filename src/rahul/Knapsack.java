package rahul;

import java.util.Arrays;

public class Knapsack {
    static class Item {
        int profit, weight;

        Item(int profit, int weight) {
            this.profit = profit;
            this.weight = weight;
        }
    }

    private static double fractionalKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, (Item a, Item b) -> {
            double cp1 = a.profit / (double) a.weight;
            double cp2 = b.profit / (double) b.weight;
            return Double.compare(cp2, cp1);//reverse order;
        });
        double totalVal = 0d;
        for (Item i : items) {
            int wt = i.weight, pro = i.profit;
            if ((capacity - wt) >= 0) {
                capacity -= wt;
                totalVal += pro;
            } else {
                double fraction = capacity / (double) wt;
                totalVal += fraction * pro;
                break;
            }
        }
        return totalVal;
    }

    public static void main(String[] args) {

    }
}

