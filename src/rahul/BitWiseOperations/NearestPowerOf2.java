package rahul.BitWiseOperations;

public class NearestPowerOf2 {
    /**
     * <a href="https://www.geeksforgeeks.org/highest-power-2-less-equal-given-number/">GFG nearest power of 2</a>
     */
    private static int nearPowerOf2(int x) {
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        return x ^ (x >> 1);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++)
            System.out.println(i + " " + nearPowerOf2(i));
    }
}
