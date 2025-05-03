package rahul;

import java.util.*;

public class Checking {
    private static void check(int n, String s1, String s2){
        if (s1.charAt(0)!=s2.charAt(0)){
            System.out.println(-1);
            return;
        }

        List<Integer>list = new ArrayList<>();
        for(int i=1;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                list.add(i);
            }
        }
        System.out.println(list.size());
        for(int i:list)
            System.out.print(i);
        System.out.println();
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-->0){
            int size = scan.nextInt();
            String s1 = scan.next();
            String s2 = scan.next();
            check(size,s1,s2);
        }
    }
}

