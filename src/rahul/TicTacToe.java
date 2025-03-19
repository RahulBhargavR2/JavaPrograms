package rahul;

import java.util.Scanner;

public class TicTacToe {
    static String[][] arr;
    static int noOfPlays;

    private static void createMatrix(int no) {
        arr = new String[no][no];
        for (int i = 0, k = 1; i < no; i++) {
            for (int j = 0; j < no; j++) {
                arr[i][j] = Integer.toString(k++);
            }
        }
    }

    private static int[] getPos(int pos) {
        int si = arr.length;
        int rem = pos % si; // to locate the pos in the column
        int row = (rem != 0) ? pos / si : pos / si - 1;
        int col = (rem != 0) ? rem - 1 : si - 1;
        return new int[]{row, col};
    }

    private static void mark(int pos, String player) {
        int[] po = getPos(pos);
        if (arr[po[0]][po[1]].equals("X") || arr[po[0]][po[1]].equals("Y")) {
            System.out.println("Already marked");
            return;
        }
        noOfPlays++;
        arr[po[0]][po[1]] = player;
    }

    private static void displayMatrix() {
        for (String[] a : arr) {
            for (String ele : a) System.out.print(ele + " ");
            System.out.println();
        }
        System.out.println("---------------");
    }


    private static void check(int pos, String player) {
        int[] po = getPos(pos);
        int row = po[0], col = po[1];
        mark(pos, player);//to mark specified position
        int size = arr.length;
        int rc = 0, cc = 0, rd = 0, ld = 0;
        for (int i = 0; i < size; i++) {
            if (arr[row][i].equals(player)) rc++;// row column , downwards
            if (arr[i][col].equals(player)) cc++;//column  column, from left to right
            if (arr[i][i].equals(player)) rd++;//right diagonal
            if (arr[i][size - 1 - i].equals(player)) ld++;//left diagonal
        }
        if (rc == size || cc == size || ld == size || rd == size) {
            System.out.println("Player " + player + " is winner");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        int m = 3;
        createMatrix(m);
        noOfPlays = 0;
        String[] players = {"X", "Y"};
        Scanner scan = new Scanner(System.in);
        do {
            String play = players[noOfPlays % 2];
            System.out.format("Player %s chance\nEnter the position\n", play);
            displayMatrix();
            int n = scan.nextInt();
            check(n, play);
        } while (noOfPlays < 9);
        System.out.println("Game ended as tie");
//        Integer.bitCount();
    }
}