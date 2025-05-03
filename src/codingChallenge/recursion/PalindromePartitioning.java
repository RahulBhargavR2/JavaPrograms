package codingChallenge.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    private static boolean isPalindrome(String s){
            int i=0,j=s.length()-1;
            while (i<j){
                if (s.charAt(i)!=s.charAt(j))
                    return false;
                i++;j--;
            }
        return true;
    }
    private static void palindromePartition(String s, int curr,List<String>list,List<List<String>> res){
        if(curr == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = curr; i < s.length(); i++) {
            String str = s.substring(curr,i+1);
            if (isPalindrome(str)) {
                list.add(str);
                palindromePartition(s, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }

    }
    public static void main(String[] args) {
        String s = "aac";
        List<List<String>> res = new ArrayList<>();
        palindromePartition(s,0,new ArrayList<>(),res);
        System.out.println(res);
    }
}
