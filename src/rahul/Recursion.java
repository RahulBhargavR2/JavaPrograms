package rahul;

import org.jetbrains.annotations.NotNull;

public class Recursion {
   public static String fact(@NotNull String n){
        if (n.isEmpty()) return "";
        else return fact(n.substring(1))+n.charAt(0);

    }

    public static void main(String[] args)throws StackOverflowError {
        System.out.println("The String after reversing is : " +fact("palindrome"));
    }
}
class Recursion2{
    public static int fact(int n){
        if(n <= 1) return 1;
        else return n * fact(n-1);
    }

    private static int tailR(int n,int count){
        if (n == 0 || n == 1) return count;
        return tailR(n-1, count * n);
    }
    private static int tailR(int n){
        return tailR(n,1);
    }

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println("Factorial is "+fact(15));
        long e = System.currentTimeMillis();
        System.out.println(tailR(15));
        long fi = System.currentTimeMillis();
        System.out.println((e-s)+"\n"+(fi-e));
    }
}

