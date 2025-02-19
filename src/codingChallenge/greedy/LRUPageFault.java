package codingChallenge.greedy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class LRUPageFault {
    private static int pageFaults(int n, int c, int[] pages) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int i = 0, faults = 0;
        for (; queue.size() < c && i < pages.length; i++) {
            if (!set.contains(pages[i])) {
                set.add(pages[i]);
                queue.add(pages[i]);
                ++faults;
            }
        }
        for (; i < pages.length; i++) {
            if (!set.contains(pages[i])) {
                if (set.size() == c)
                    set.remove(queue.poll());
                ++faults;
                set.add(pages[i]);
                queue.add(pages[i]);
            }
        }
        System.out.println(faults);
        return faults;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(new File("fileInput.txt")));
        int n = scanner.nextInt();
//        System.out.println(n);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int c = scanner.nextInt();
//        int[] arr = {5, 0, 1, 3, 2, 4, 1, 0, 5};
        pageFaults(n, c, arr);

    }
}
