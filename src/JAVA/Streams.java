package JAVA;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

@SuppressWarnings("unused")
public class Streams {
    public static void main(String[] args) {
        //        HashSet<Character> set = s.chars()
//                .mapToObj(e -> (char)e)
//                .collect(Collectors.toCollection(HashSet::new));
//        if (set.size() == 1) return s.length();
//        return (2*s.length())-1;
//    }
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        IntSummaryStatistics sum  =  Arrays.stream(arr)
                        .summaryStatistics();
        System.out.println(sum);

    }
}