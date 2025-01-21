package reflection;

import java.util.Arrays;

public class CatReflection {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat("cattle",20);
        /*Field[] catFields = cat.getClass().getDeclaredFields();

        for (Field field:catFields){
            if(field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(cat, "notCattle");

            }
        }
        Method[] catMethods = cat.getClass().getDeclaredMethods();
        for (Method method: catMethods) {
            if(method.getName().equals("privateStatic")){
                method.setAccessible(true);
                method.invoke(null);
            }
        }*/
        //Method information
       /* List<Method> methods = List.of(c.getDeclaredMethods());
        for (Method method : methods){
            System.out.println("\n");
            System.out.println(method.getName()+" "+method.getGenericReturnType());
            System.out.println("parameters taken");
            List<Type> types = List.of(method.getGenericParameterTypes());
            for (Type type : types) System.out.println(type);
        }*/
        System.out.println(cat.getClass().getPackageName());
    }
}
