package rahul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigSorting2 {
    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        long[]arr = new long[n];
        for(int i = 0;i < n; i++)
            arr[i] = Integer.parseInt(in.readLine());

    }
}
