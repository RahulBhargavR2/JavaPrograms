package rahul;

import java.util.*;

public class PrimeFactors {
    private static List<Integer> primeFactors(int n, LinkedList<Integer> li){
        int i = 2;
        if (PrimeNo.isPrime(n)){
            li.add(1); li.add(n);
            return li;
        }
        while (n>1){
            while (n%i == 0){
                li.add(i);
                n/=i;
            }
            i++;
        }
        return li;
    }

    private static Map<Integer,Integer> countSet(List<Integer> li, HashMap<Integer,Integer> hm){
        if (li.isEmpty()) return hm;
        li.forEach((val) -> {
            if (hm.containsKey(val)) {
                hm.put(val,hm.get(val)+1);
            } else
                hm.put(val,1);
        });
        return hm;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long s = System.currentTimeMillis();
        Map<Integer,Integer>hm =  countSet(primeFactors(n,new LinkedList<>()),new HashMap<>());
        long e = System.currentTimeMillis();
        System.out.println(e-s);
        System.out.println("no of times each prime repeats is");
        System.out.println(hm);
    }
}
