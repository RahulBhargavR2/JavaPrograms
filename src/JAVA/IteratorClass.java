package JAVA;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorClass {
    public static void main(String[] args) {
        List<Integer> li = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            li.add((int) (Math.random()*10));
        System.out.println(li);

        Iterator<Integer> i = li.iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (n %2 == 0) i.remove();
        }
        i = li.iterator();
        while (i.hasNext()) System.out.print(i.next()+" ");

    }
}
