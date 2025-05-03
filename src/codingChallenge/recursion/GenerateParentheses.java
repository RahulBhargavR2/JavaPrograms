package codingChallenge.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    private static void generate(String s, int n,int open, int close, List<String>res){
        if(open == n && close == n){
            res.add(s);
            return;
        }
        if (open < n)
         generate(s+"(",n,open+1,close,res);
        if (close < n && open > close )
         generate(s+")",n,open,close+1,res);
    }

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        generate("",3,0,0,res);
        System.out.println(res);
    }
}
