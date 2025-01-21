package reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Dog implements Animal{
    private final String name;
    private final int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void sound() {
        System.out.println("Bark");
    }

    @Override
    public void sleep() {
        System.out.println("in side home");
    }
}

