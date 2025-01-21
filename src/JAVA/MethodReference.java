package JAVA;

import java.util.List;

public class MethodReference {
    private static void print(String s){
        System.out.println("Hello "+s);
    }

    public static void main(String[] args) {
        List<String> list = List.of("First","second","third");
        list.forEach(MethodReference::print);
    }
}
