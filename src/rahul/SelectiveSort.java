package rahul;

import java.util.Arrays;
public class SelectiveSort
{
    private void selectiveSort1(int[] arr){
        int min,temp;
        for(int i = 0; i < arr.length; i++)
        {
            min=i;
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[j] < arr[min])
                    min = j;
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
    private void selectiveSort2(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            int j=i;
            for (int k = i+1; k < arr.length ; k++) {
                if(arr[k] < arr[j])
                    j = k;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main (String[]args) {
        int[] arr ={4,5,3,4,6,7,3,2,6,9};
        System.out.println(Arrays.toString(arr));
        SelectiveSort s = new SelectiveSort();
        s.selectiveSort2(arr);
    }
}