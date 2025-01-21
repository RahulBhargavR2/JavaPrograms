package reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@nameSetter(name = "hello")
public class DogReflection {

    String name;

    public String getName(){
        return name;
    }
    public static void main(String[] args) {
        nameSetter n = DogReflection.class.getAnnotation(nameSetter.class);
        System.out.println(n.name());
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface nameSetter{
     String name() default "nu";
}
