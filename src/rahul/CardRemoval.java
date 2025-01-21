package rahul;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CardRemoval {
    private static int check(int size, int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for(int ele:arr){
            map.merge(ele,1,Integer::sum);
        }
        Set<Integer> keys = map.keySet();
        int maxRep = 0;
        for(int key: keys){
            maxRep = Math.max(maxRep,map.get(key));
        }
        System.out.println(map);
        if(maxRep == size) return 0;
        if (maxRep == 1) return size-1;
        return size-maxRep;

    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-->0){
            int size = scan.nextInt();
            int[] arr = new int[size];
            for(int i=0;i<size;i++) arr[i] = scan.nextInt();
            System.out.println(check(size, arr));
        }

    }
}
