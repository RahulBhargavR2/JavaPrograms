package rahul;

//import java.util.LinkedList;
import java.util.Scanner;

 public class MaxProtein {
//     static LinkedList<Integer> li = new LinkedList<>();
    private int maxProtein(int[] type, int[] val){
        int i = 0, j , max, maxSum = 0;
        while(i < type.length){
            max = val[i];
            j = i+1;
            while (j<type.length && type[i] == type[j]){
                max = val[j]>0?Math.max(max,val[j]):0;
                j++;
            }
            i = j;
            maxSum += Math.max(max, 0);
        }
        return maxSum;

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        MaxProtein c = new MaxProtein();
        while (n-- > 0) {
            int size = scan.nextInt();
            int[] type = new int[size];
            int[] val = new int[size];
            for (int i = 0; i < size; i++) type[i] = scan.nextInt();
            for (int i = 0; i < size; i++) val[i] = scan.nextInt();

//            c.maxProtein(type, val);
            System.out.println(c.maxProtein(type,val));
        }
//        for (Integer i:li) {
//            System.out.println(i);
//
//        }
    }
}