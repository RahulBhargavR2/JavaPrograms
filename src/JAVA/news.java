package JAVA;

import java.util.ArrayList;
import java.util.Random;

public class news {

    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer>list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(r.nextInt(2));
        }
        int sum =0;
        for (int a : list) { //lambda
            lambda l = (c) -> c;
            sum += l.sum(a);
        }
        System.out.println(list);
        System.out.println(sum);
    }
//    lambda lambda = new lambda() {
//        @Override
//        public int sum(int a,int b) {
//            return a*b;
//        }
//    };
//    for (int i:list)
//        sum+= lambda.sum(i,i);
//    System.out.println(sum);
//}
}
