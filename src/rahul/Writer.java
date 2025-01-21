package rahul;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Writer {
    public static void write(int[]arr,boolean nextLine) throws IOException {
        BufferedWriter in = new BufferedWriter(
                new FileWriter("C:\\Users\\rahul\\Desktop\\testcase.txt\\"));
        for(int i:arr){
            in.write(i+" ");
            if( nextLine) in.newLine();
        }
        in.close();
    }
    public static void main(String[] args) throws IOException {
        int[]arr= new int[10000];
        Random r = new Random();
        for (int i=0;i<10000;i++)
            arr[i] = r.nextInt(1,10000);
        write(arr,false );
    }
}
