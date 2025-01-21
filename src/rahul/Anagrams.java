package rahul;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//https://www.baeldung.com/java-strings-anagrams
public class Anagrams {
    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();
        Map<Character, Integer> s1M = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1M.containsKey(s1.charAt(i)))
                s1M.put(s1.charAt(i), s1M.get(s1.charAt(i)) + 1);
            else
                s1M.put(s1.charAt(i), 1);
        }

        //or
//        for(int i=0;i<s1.length();i++) s1M.merge(s1.charAt(i),1,Integer::sum);

        for (int i = 0; i < s2.length(); i++)
            if (s1M.containsKey(s2.charAt(i)))
                s1M.put(s2.charAt(i), s1M.get(s2.charAt(i)) - 1);

        Set<Character> set = s1M.keySet();

        for (Character key : set)
            if (s1M.get(key) != 0) return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s1 = scan.nextLine();
        String s2 = scan.nextLine();

        System.out.println(isAnagram(s1, s2) ? "Anagrams" : "Not Anagrams");
    }
}
