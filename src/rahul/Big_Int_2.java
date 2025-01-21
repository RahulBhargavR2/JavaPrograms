package rahul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Big_Int_2
{
    public static void main(String[]args)throws IOException {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("Enter the first number and second number");
        String fi=in.readLine();
        String se=in.readLine();
        BigInteger a,b;
        a=new BigInteger(fi);
        b=new BigInteger(se);
        System.out.println("The sum is \n"+a.add(b));
        System.out.println("The product is \n"+a.multiply(b));

    }
}
