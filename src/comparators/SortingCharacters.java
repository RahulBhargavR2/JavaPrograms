package comparators;

import java.util.*;

public class SortingCharacters {

    private static ArrayList<String> sortItems(int n, String[] arr){
        Arrays.sort(arr,(a,b)->{
            if(a.length()!=b.length()) return Integer.compare(a.length(),b.length());
            else{
                for (int i = 0; i < a.length(); i++) {
                    if(a.charAt(i)!=b.charAt(i))  return Integer.compare(a.charAt(i),b.charAt(i));
                }
            }
            return 0;
        });

        return new ArrayList<>(List.of(arr));
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-->0){
            int size = scan.nextInt();
            String[] arr = scan.nextLine().trim().split(" ");
            System.out.println(sortItems(size, arr));
        }

    }
}
