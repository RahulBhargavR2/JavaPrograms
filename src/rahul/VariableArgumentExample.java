package rahul;

class VariableArgument {
    String na;
    VariableArgument(String na){
        this.na=na;
    }
    public int re(int...a) {
        int sum = 0, re;
        for (int i : a)
            sum += i;
        if (sum >= 0 && sum < 10000)
            re = 1000;
        else if (sum > 10000)
            re = 10000;
        else
            re = 0;
        return re;
    }
    public String getNa(){return na;}
}
public class VariableArgumentExample {
    public static void main(String[] args) {
        VariableArgument v1 = new VariableArgument("hello hi");
        int re = v1.re(1000, 2000, 30000, 4000);
        System.out.println(v1.getNa() + " " + re);

    }
}

