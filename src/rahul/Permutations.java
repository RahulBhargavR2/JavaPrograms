package rahul;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {


//    private static String stringPermutations(String s){
//
//    }
//    public static void main(String[] args) {
//    }
}

class IntegerPermutations{
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void permutation(ArrayList<int[]>finalList,int[] arr,int start, int end){
        if(start == end) {
            finalList.add(Arrays.copyOf(arr, arr.length));
            return;
        }
        for (int i=start; i <=end ; i++) {
            swap(arr,start,i);
            permutation(finalList, arr, start+1, end);
            swap(arr, start, i);
        }
    }

    public static ArrayList<int[]> permutations(int[] arr){
        ArrayList<int[]> res = new ArrayList<>();
        permutation(res,arr,0, arr.length-1);
        return res;
    }
//    IntegerPermutations.permutations(arr)
//            .forEach(a-> System.out.println(Arrays.toString(a)));



}