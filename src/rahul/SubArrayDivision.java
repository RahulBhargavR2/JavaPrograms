/*Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.
Lily decides to share a contiguous segment of the bar selected such that:
The length of the segment matches Ron's birth month, and,
The sum of the integers on the squares is equal to his birthday.
Determine how many ways she can divide the chocolate.
EG:
s=[2,2,1,3,2]
d=4
m=2
Lily wants to find segments summing to Ron's birthday, d=4 with a length equalling his birth month m=2,
In this case, there are two segments meeting her criteria:[2,2] and [1,3] .
*/

package rahul;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class SubArrayDivision {
    @Contract(pure = true)
    public static int Division(@NotNull int[] arr, int requiredSum, int noOfSquares) {
        int returnValue = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < noOfSquares; j++) {
                if ((j + i) == arr.length)
                    break;
                sum += arr[i + j];
            }
//            System.out.println("sum is "+sum);
            if (sum == requiredSum) {
                returnValue++;
            }
        }
        return returnValue;
    }

    private static int slidingWindow(int[] arr, int birthDay, int birthMonth) {
        int temp = 0, sum = 0;
        for (int i = 0; i < birthMonth; i++) sum += arr[i];
        System.out.println(sum);
        for (int i = birthMonth; i < arr.length; i++) {
            System.out.println(sum);
            if (sum == birthDay) temp++;
            sum += arr[i] - arr[i - birthMonth];
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
//        System.out.println("Enter the no of squares and fum required");
        int birthDay = scan.nextInt();
        int birthMonth = scan.nextInt();
//        int result = Division(arr,noOfSquares,requiredSum);
        int result = slidingWindow(arr, birthDay, birthMonth);
        System.out.println("result is " + result);

    }
}
