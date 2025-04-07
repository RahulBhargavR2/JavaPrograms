package codingChallenge.stack;

import java.util.*;

public class GenerateBinaryString {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        queue.add("1");
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        res.add("0");
        for (int i = 0; i < n; i++) {
            String curr = queue.poll();
            res.add(curr);
            queue.add(curr + "0");
            queue.add(curr + "1");
        }
        res.forEach(System.out::println);
    }
}
