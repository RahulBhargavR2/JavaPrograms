package rahul;

public class overloading {
    int name(int c, int b) {
        return c + b;
    }

    int man(int a, int t, int n) {
        return a * t * n;

    }

    public static void main(String[] args) {
        overloading a = new overloading();
        System.out.println(a.name(4, 3));
        System.out.println(a.man(47, 33, 24));
    }

}