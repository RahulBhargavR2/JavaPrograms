package rahul;
/*Write a program to convert 12 hour time to 24-hour time format
 * input format
 * Enter time in HH:MM:SS format with AM or PM with no space after SS
 * Eg 04:30:24AM
 * output 04:30:24
 * Eg 04:30:24PM
 * output 16:30:24
 */
import java.io.*;
public class TimeConversion
{
    public static void main(String[] args)throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("Enter the time in HH:MM:SS AM_PM format");
        String s=in.readLine();
        String s1=s.substring(8,10);//s1 for am or pm
        String s2=s.substring(0,8);//string without am or pm
        int s6=Integer.parseInt(s.substring(0,2));//hour string is converted to int
        int s3=Integer.parseInt(s.substring(0,2))+12;//12 has been added to hour to change the format
        String s4=s2.substring(2,8);// gives :mm:ss
        String s5=(String.valueOf(s3)).concat(s4);//if hour is pm and greater than 12
        String s7="00";
        if(s1.equalsIgnoreCase("AM"))
        {
            if(s6==12)
                System.out.println("The time in 24 hour format is : "+s7.concat(s4));
            else
                System.out.println("The time in 24 hour format is : "+s2);
        }
        else
        if(s6==12)
            System.out.println("The time in 24 hour format is : "+s2);
        else
            System.out.println("The time in 24 hour format is : "+s5);


    }
}





