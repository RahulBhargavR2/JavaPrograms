package rahul;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer>map=new HashMap<>();
        int n=Integer.parseInt(in.readLine());
        for(int i=0;i<n;i++)
        {
            String s=in.readLine();
            s=s.replaceAll("\\s","");
            map.put((s.substring(0,s.length()-8)),Integer.parseInt(s.substring(s.length()-7)));
        }
        String []a=new String[n];
        for(int i=0;i<n;i++)
            a[i]=in.readLine();
        for(int i=0;i<n;i++){
            if(map.get(a[i])!=null)
                System.out.println(a[i]+"="+map.get(a[i]));
            else
                System.out.println("Not found");

    }
    }
}
