package rahul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CuttingSticks {
    public int[] cutTheList(ArrayList<Integer> arr){
        ArrayList<Integer> li = new ArrayList<>();
        while (!arr.isEmpty()){
            int min = Collections.min(arr),st=0;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i)>=min) {
                    arr.set(i,arr.get(i)-min);
                    st++;
                }
            }
            li.add(st);
            arr.removeIf(m->m<=0);
        }
        int[] aa = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            aa[i] = li.get(i);
        }
        return aa;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        CuttingSticks c = new CuttingSticks();
        int[] a = c.cutTheList(arr);

        System.out.println(Arrays.toString(a));
    }
}