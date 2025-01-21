package rahul;

public class Equality {
    private static String prepareIt(int len){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len-1)
                stringBuilder.append(1);
            else stringBuilder.append(0);
        }
        return stringBuilder.toString();

    }
//    private static boolean checker(String s){
//
//        int i = 0, first = 0, sec = 0;
//        while (i < s.length()-1){
//            if (s.startsWith("10", i)) first++;
//            else if(s.startsWith("01",i)) sec++;
//            i++;
//        }
//        return first == sec;
//    }

    public static void main(String[] args) {
        int a = 2;
        while (a++< 10){
           System.out.println(prepareIt(a));
        }
    }
}
