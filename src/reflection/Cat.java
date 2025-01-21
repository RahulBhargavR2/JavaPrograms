package reflection;

@SuppressWarnings("unused")
public class Cat {

    private final String name;
    private  int age;

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void meow(){
        System.out.println("Meow");
    }
    private void Private(){
        System.out.println("How is it possible??");
    }
    public static void publicStatic(){
        System.out.println("This is public and static");
    }
    private static void privateStatic(){
        System.out.println("This is private and static");
    }
}