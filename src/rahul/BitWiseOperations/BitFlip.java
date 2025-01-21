package rahul.BitWiseOperations;

import java.util.Arrays;
import java.util.Scanner;

public class BitFlip {
    private static Long flip(Long a) {
        char[] arr = new char[32];
        int len = arr.length;
//        for (int i = 0; i < len; i++) arr[i] = '0';
        Arrays.fill(arr, '0');
        String st = Long.toBinaryString(a);
        for (int i = len - st.length(), j = 0; i < len; i++) {
            arr[i] = st.charAt(j++);
        }
        for (int i = 0; i < len; i++) {
            arr[i] = (char) (arr[i] ^ 1);
        }
        return toNumber(new String(arr));
    }

    private static Long toNumber(String st) {
        long num = 0L;
        char[] ch = st.toCharArray();
        for (int i = ch.length - 1, pow = 0; i >= 0; i--, pow++) {
            num += (long) (Integer.parseInt(String.valueOf(ch[i])) * Math.pow(2, pow));
        }
        return num;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        while (n-- > 0) {
//            Long a = scan.nextLong();
//            System.out.println(flip(a));
//        }
        System.out.println(flip(0L));
//        System.out.println(toNumber("1000"));
    }
}
