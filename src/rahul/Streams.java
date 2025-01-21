package rahul;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Streams {
    public static void main(String[] args)  {
        List<Integer> arr =new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) arr.add(random.nextInt(100));

        System.out.println(arr);
         arr.stream()
                 .map(m -> m*m) //make it to desired output
                 .sorted()//sort
                 .filter(x -> x%2 == 0)
                 .forEach(x -> System.out.print(x+" "));


    }
}
