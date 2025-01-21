package rahul;

import java.util.Scanner;

public class ModifiedKaprekarNumber {
    public static boolean kapreakar(long n){
        int d = Long.toString(n).length();
        String squaredNum = Long.toString(n*n);
        int squaredNumLen = squaredNum.length();
        int lPartLen = squaredNumLen-d;
        String rPart = squaredNum.substring(lPartLen);

        String lPart = squaredNum.substring(0,lPartLen);
        long finalSum = Integer.parseInt(lPart)+Integer.parseInt(rPart);
        return (n == finalSum);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the range ");
        int start = scan.nextInt();
        int end = scan.nextInt();
        int k=0;
        System.out.println("result");
        for (int i = start; i <= end; i++){
            if (i==1) {
                System.out.print(1+" ");
            }
            if (i>3 && kapreakar(i)){
                k++;
                System.out.print(i+" ");
            }
        }
        if (k==0) System.out.println("INVALID RANGE");

    }
}