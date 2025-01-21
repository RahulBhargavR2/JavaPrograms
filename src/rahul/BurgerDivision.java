 package rahul;

 import java.util.Scanner;

class BurgerDivision {
    private static int[] check(int nor, int pre, int noOfB, int cost) {
        if(nor*noOfB>cost) return new int[]{-1};
        int prem = Math.min(noOfB,(cost-nor*noOfB)/(pre-nor));
        return new int[]{noOfB-prem,prem};

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-->0){
            int nor = scan.nextInt();
            int pre = scan.nextInt();
            int noOfB = scan.nextInt();
            int cost = scan.nextInt();
            int[] arr = check(nor,pre,noOfB,cost);
            System.out.println((arr.length==1)?-1:arr[0]+" "+arr[1]);
        }
    }
}