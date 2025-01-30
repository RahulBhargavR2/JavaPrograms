package codingChallenge.bitMaipulation;

public class MinimumFlips {

    private static int BrianKernighan(int start, int goal){
        //efficient way to count setbits
//        when a number is subratcted by one the rightmost set bit will be changed
        // when this number is bitwised and with n-1 all the rightmost set bit will become zero
        //when it is repeated until the number is zero thus gives the count of set bits
        int count = 0, required = start ^ goal;
        while (required!=0){
            required &= required-1;
            count++;
        }
        return count;
    }
}
