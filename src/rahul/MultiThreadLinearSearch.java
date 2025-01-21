package rahul;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadLinearSearch {
    private static void prin(int i) throws InterruptedException {
        for (int k = 0; k < 4; k++) {
            System.out.println("current thread is "+i);
            Thread.sleep(1000);
        }
    }


    private static boolean stat= false;
    private static void linearSearch(int num, int [] arr,int key){
        int max = arr.length;
        for (int i = num * (max/4); i < ((num+1) * (max/4)) ; i++) {
            if (arr[i] == key) {
                stat = true;
            }
        }

    }
    private static int j = 0;
    public static void main(String[] args)throws InterruptedException  {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        int[] arr = new int[16];
        for (int i = 0; i < 16; i++) {
            arr[i] = new Random().nextInt(10);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < 4; i++) {
            executor.execute(()->linearSearch(j++, arr,3));

        }
        executor.shutdown();

        if (stat) System.out.println("fount");
        else System.out.println("not found");
    }
}
