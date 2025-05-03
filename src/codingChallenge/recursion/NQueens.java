package codingChallenge.recursion;

import java.util.ArrayList;
import java.util.List;


//not yet working, need to code.
public class NQueens {
    private static boolean isSafe(List<String> list, int n, int row, int col) {
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i).charAt(col) == 'Q') a++;
            if (list.get(row).charAt(col) == 'Q') b++;
        }
        int rl = row - Math.min(row, col), cl = col - Math.min(row, col);
        int rr = row - Math.min(row, n - col - 1), cr = col + Math.min(row, n - col);
        while (rl < n && cl < n) {
            if (list.get(rl).charAt(cl) == 'Q')
                c++;
            rl++;
            cl++;
        }
        while (rr < n && cr < n) {
            if (list.get(rr).charAt(cr) == 'Q')
                d++;
            rr++;
            cr--;
        }
        return a < 2 && b < 2 && c < 2 && d < 2;


    }

    private static void generate(List<String> list, List<List<String>> res, int curr, int n) {
        if (curr == n) {
            res.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(list.get(i));
            String temp = list.get(i);
            for (int j = 0; j < n; j++) {
                sb.replace(j,j+1,"Q");
                list.set(i,sb.toString());
                if (isSafe(list,i,j,n))
                    generate(list,res,i,n);
                list.set(i,temp);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>>res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int n = 4;
        for (int i = 0; i < n; i++) {
            list.add(".".repeat(n));
        }
        generate(list,res,0,n);
        System.out.println(res);
    }
}
