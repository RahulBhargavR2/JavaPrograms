package rahul;

import java.util.Scanner;
public class Happy2
{
    public static void main(String[]args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the starting ending and dividing num");
        int i= scan.nextInt();
        int j= scan.nextInt();
        int k= scan.nextInt();
        String rev;
        int cou=0;
        int re;
        StringBuilder st=new StringBuilder();
        for(int q=i;q<=j;q++)
        {
            st.setLength(0);
            st.append((q));
            rev=st.reverse().toString();
            re=Integer.parseInt(rev);
            if(Math.abs(q-re)%k==0)
                cou++;
        }
        System.out.println("The number of happy days = "+cou);
    }
}
