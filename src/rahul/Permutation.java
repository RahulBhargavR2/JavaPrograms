package rahul;

public class Permutation {
    private void perm(int[] a,int k,int n){
        if(k == n){
            for (int i=1;i<=n;i++) System.out.print(a[i]+" ");
            System.out.println();
        }
        else {
            for (int i = k; i <= n ; i++) {
                int t = a[i];
                a[k] = a[i];
                a[i] = t;
                perm(a,k+1,n);
                t = a[k];
                a[k] = a[i];
                a[i] = t;
            }
        }
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        int[] a = {1,2,3,4,5,6,7,8,9,10,22,12};
        p.perm(a,2,4);
    }
}
