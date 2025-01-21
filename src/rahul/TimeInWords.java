package rahul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeInWords
{
    public static void main(String[]args)throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        String min,q;
        System.out.println("Enter the hours");
        int h=Integer.parseInt(in.readLine());//stores hour
        System.out.println("Enter the minutes");
        int m=Integer.parseInt(in.readLine());//stores minutes
        String[]st={"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve"
        ,"thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty","twenty one","twenty two",
         "twenty three","twenty four","twenty five","twenty six","twenty seven","twenty eight","twenty nine"};
        if(h>12||m<0||m>59)
            System.out.println("Invalid input");
        if(h==12)
            q=st[1];
        else
            q=st[h+1];
        if(m==1||m==59)
            min="minute";
        else
            min="minutes";
        if(m==0)
            System.out.println(st[h]+" o' clock");
        if(m==15)
            System.out.println("quarter past "+st[h]);
        if(m==30)
            System.out.println("half past "+st[h]);
        if(m==45)
            System.out.println("quarter to "+q);
        if(m<30&&m!=15&&m>0)
            System.out.println(st[m]+" "+min+" past "+st[h]);
        if(m>30&&m!=45&&m<60)
            System.out.println(st[60-m]+" "+min+" to "+q);
    }
}
