package rahul;

public class Palindrome {
    private boolean checkIte(String s){
        int st = 0,end = s.length()-1;
        while (st<end){
            if(s.charAt(st) != s.charAt(end)) return false;
            st++; end--;
        }
        return true;
    }

    private boolean checkRec(String s, int le, int ri){
        if(le >= ri) return true;
        if(s.charAt(ri) != s.charAt(le)) return false;
        return checkRec(s,le+1,ri+1);
    }



}
