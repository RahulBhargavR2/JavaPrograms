package rahul;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        String st = scan.nextLine();
        String st = "He is a very very good boy, isn't he?";
        String[] arr = st.split("\\W");
        System.out.println(arr.length);
        for(String s:arr)
            if(!Pattern.matches("\\n",s))
                System.out.println(s);
//        System.out.println(Arrays.toString(arr));
    }
}
