package codingChallenge.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    private static int longestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
//        int size = s.length(), i = 0, j = 0;
//        while (j < size) {
//            char ch = s.charAt(j);
//            if (map.containsKey(ch)) {
//                i = map.get(ch)>=i?map.get(ch):i; //get the position of repeated char
//                map.put(ch, j+1); // update the position of repeated char to recent repetition position
//            }
//            map.put(ch, j + 1);
//            longest = longest < (j - i + 1) ? j - i + 1 : longest;
//            j++;
//        }
        //solution
        int le = 0;
        for (int ri = 0; ri < s.length(); ri++) {
            char ch = s.charAt(ri);
            if (map.containsKey(ch))
                le = Math.max(map.get(ch),le); // if the left pointer have moved further right from the repeated char
                                                // should choose the rightmost value for left pointer
            map.put(ch, ri + 1);
            longest = Math.max(longest,ri-le+1);
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(longestSubstring(s));

    }
}
