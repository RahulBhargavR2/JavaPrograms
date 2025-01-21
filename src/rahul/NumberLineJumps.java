package rahul;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberLineJumps {

    public static @NotNull String kangaroo(int x1, int x2, int v1, int v2) {
        double dx = Math.abs(x1 - x2);
        double dv = v1 - v2;
        if (dv < 0)
            return "NO";
        else if (dx % dv == 0)
            return "YES";
        return "NO";

    }

    public static void main(String[] args) throws IOException {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        String[] firstMultipleInput = in.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        System.out.println(kangaroo(x1, x2, v1, v2));

    }
}
