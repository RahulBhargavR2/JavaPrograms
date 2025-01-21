package rahul;

@SuppressWarnings("unused")
public class StringMatching {
    //    KMP ALGORITHM
    private static int[] createLps(String pat, int size) {
        int[] lps = new int[size];
        lps[0] = 0;
        int len = 0, i = 1;
        while (i < size) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0)
                    len = lps[len - 1];
                else
                    lps[i++] = len;
            }
        }
        return lps;
    }

    private static void kmpSearch(String text, String pat) {
        int textLen = text.length();
        int patLen = pat.length();
        int i = 0, j = 0;
        int[] lps = createLps(pat, patLen);
        while ((textLen - i) >= (patLen - j)) {
            if (text.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == patLen) {
                System.out.println("Patten found at pos " + (i - j));
                j = lps[j - 1];
            } else if (i < textLen && text.charAt(i) != pat.charAt(j)) {
                if (j == 0) ++i;
                else j = lps[j - 1];
            }
        }
    }

    public static void main(String[] args) {

    }
}
