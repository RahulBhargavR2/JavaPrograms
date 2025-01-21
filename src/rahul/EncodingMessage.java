package rahul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.codechef.com/problems/ENCMSG">Encoding Message</a>
 */
public class EncodingMessage {
    private static String encode(String s, int size) {
        if (size == 1) return String.valueOf((char) (219 - s.charAt(0)));
        int actualIte = (size % 2 == 0) ? size - 1 : size - 2;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < actualIte; i += 2) {
            char ch = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(i + 1));
            sb.setCharAt(i + 1, ch);
        }
        for (int i = 0; i < size; i++) {
            sb.setCharAt(i, (char) (219 - sb.charAt(i)));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            int size = Integer.parseInt(in.readLine());
            String s = in.readLine();
            System.out.println(encode(s, size));
        }

    }


}