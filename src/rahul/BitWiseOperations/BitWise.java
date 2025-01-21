package rahul.BitWiseOperations;

import java.util.Scanner;
@SuppressWarnings("all")
public class BitWise {
    //Brian Kernighan algo says that if you bitwise and n and n-1
    //they right most bit set will be unset
    //everything to its left remains unchanged
    //everything to right becomes zero
    //as the binary equ of powers of 2 will only contain one bit set so applying the alog will result
    // in zero after first iteration
    private static boolean isPowerOf2(int n){
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    private static int longestOnes(int n){
        int count = 0;
        while (n != 0){
            n &= n << 1;
            count++;
        }
        return count;
    }

    /* Prints two numbers that occur odd
       number of times. The function assumes
       that the array size is at least 2 and
       there are exactly two numbers occurring
       odd number of times. */
    static void printTwoOdd(int[] arr, int size)
    {
        /* Will hold XOR of two odd occurring elements */
        int xor2 = arr[0];

        /* Will have only single set bit of xor2 */
        int set_bit_no;
        int i;
        int n = size - 2;
        int x = 0, y = 0;

      /* Get the xor of all elements in arr[].
         The xor will basically be xor of two
         odd occurring elements */
        for(i = 1; i < size; i++)
            xor2 = xor2 ^ arr[i];

      /* Get one set bit in the xor2. We get
         rightmost set bit in the following
         line as it is straightforward to get */
        set_bit_no = xor2 & -xor2;

      /* Now divide elements in two sets:
            1) The elements having the
               corresponding bit as 1.
            2) The elements having the
               corresponding bit as 0.  */
        for(i = 0; i < size; i++)
        {
         /* XOR of a first set is finally going
            to hold one odd occurring number x */
            if((arr[i] & set_bit_no)>0)
                x = x ^ arr[i];

         /* XOR of a second set is finally going
            to hold the other odd occurring number y */
            else
                y = y ^ arr[i];
        }

        System.out.println("The two ODD elements are "+
                x + " & " + y);
    }
    private static boolean isKthBit(int n,int k){
        int kth = 1 << k;
        return (n&kth) == 0;
    }

    //method to find the position of the right most set bit
    private static int findRightMostSetBit(int n){
        int mask = n & n-1; // make all the bits to the no's right as zero
        int pos = n ^ mask;//use xor to locate the set bit
        //eg 10 -> 1010
        // 10 & 9 -> 1000
        // xor 1010
        //     1000
        //  =  0010 => 2 is binary equ . use log to take out its power so we can get the position
        int finalAns =(int) (Math.log10(pos) / Math.log10(2));
        return ++finalAns;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no");
        int n = scan.nextInt();
        System.out.println(isPowerOf2(n));
        System.out.println(longestOnes(n));
    }
}