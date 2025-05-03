package codingChallenge.recursion;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class SortStack {
    private static void insert(Stack<Integer> st , int ele){
        if(st.isEmpty() || st.peek()<ele){
            st.push(ele);
            return;
        }
        int temp = st.pop();
        insert(st,ele);
        st.push(temp);
    }

    private static void sort(Stack<Integer>st){
        if (st.isEmpty())
            return;
        int ele = st.pop();
        sort(st);
        insert(st,ele);
    }
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("001101");
//        StringBuilder s = new StringBuilder("110001");
        Set<StringBuilder>set = new HashSet<>();
        prefixReverse(s,0,set);
        System.out.println(set.size()+1);
//
//        StringBuilder sb = new StringBuilder(s.substring(0,6)).reverse();
//        System.out.println(sb);
//        s.replace(0,6,sb.toString());
//        System.out.println(s);

    }



    private static void prefixReverse(StringBuilder sb, int prev, Set<StringBuilder> set){
        if (prev == sb.length()-1)
            return ;
        int z=0,o=0;
        for (int i = 0; i < sb.length(); i++) {

            if (sb.charAt(i)=='0')
                o++;
            else z++;
            if (i == prev)
                continue;
            if (o == z){
                StringBuilder temp = new StringBuilder(sb.substring(0, i + 1)).reverse();
//                System.out.println(temp);
                sb.replace(0,i+1,temp.toString());
                System.out.println(set);
                if (set.contains(sb))
                    return;
                set.add(new StringBuilder(sb));
                prefixReverse(sb,i,set);
            }
        }
    }
}
