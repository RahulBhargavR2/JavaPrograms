package rahul;

import java.util.*;

public class PickingNumbers {
    private static int count1(ArrayList<Integer>arr){
        List<Integer> setNum = new ArrayList<>(new HashSet<>(arr));
        List<Integer> freq = new ArrayList<>();
        for (Integer integer : setNum) {
            freq.add(Collections.frequency(arr, integer));
        }
        System.out.println(setNum);
        System.out.println(freq);
        int max1 = Collections.max(freq);
        int max = max1 != 1 ?  max1 : 0;
        if (setNum.size() == 1) return arr.size();
        for (int i = 0; i < setNum.size()-1; i++) {
            int num = 0;
            if (setNum.get(i+1)-setNum.get(i)<=1) num = freq.get(i+1) + freq.get(i);
            if (num > max) max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scan.nextInt());
        }
        System.out.println(count1(arr));
    }

}