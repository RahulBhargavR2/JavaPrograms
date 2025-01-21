package rahul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
@SuppressWarnings("unused")
public class SuffixSort {
    private static void sort(int []first,int[]second){
        int max = second[0], len = first.length;
        for (int value : second) max = Math.max(max, value);
        int[]cpy = new int[max];
        int startIndex = len-max;
        for (int j = startIndex,k=0; j <len ; j++) cpy[k++] = first[j];
        Arrays.sort(cpy);
        for(int j=startIndex,k=0;j<len;j++) first[j] = cpy[k++];
        for(int i:first) System.out.print(i+" ");
        System.out.println();
    }

    private static void sort(ArrayList<Integer>first,ArrayList<Integer>second){
        int max = Collections.max(first), len = first.size();
        ArrayList<Integer>cpy = new ArrayList<>(max);
        int startIndex = len - max;
        for (int i = startIndex; i < len; i++) cpy.add(first.get(i));
        Collections.sort(cpy);
        for(int i=startIndex,k=0;i<len;i++) first.set(i,cpy.get(k++));
        for (Integer i: first) System.out.print(i+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-->0){
            int fir = scan.nextInt();
            int s = scan.nextInt();
            int []f = new int[fir];
            int []se = new int[s];
            for(int i=0;i<fir;i++) f[i] = scan.nextInt();
            for(int i=0;i<s;i++) se[i] = scan.nextInt();
            ArrayList<Integer>first = new ArrayList<>();
            sort(f,se);
        }
    }
}
