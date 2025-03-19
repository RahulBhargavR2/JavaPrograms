package rahul;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;

public class TicTacToe2 {
    static char[][] arr;
    static Queue<Integer> xQ;
    static Queue<Integer> yQ;
    static int noOfPlays;
    static int boardSize;

    private static void createMatrix(int no) {
        arr = new char[no][no];
        xQ = new LinkedList<>();
        yQ = new LinkedList<>();
        for (int i = 0; i < no; i++) {
            for (int j = 0; j < no; j++) {
                arr[i][j] = ' ';
            }
        }
    }

    private static void checkFill(int playerPos, char player) {
        int pos = 0;
        Optional<Integer> optional;
        if (player == 'X') {
            xQ.add(playerPos);
            if (xQ.size() > boardSize) {
                optional = Optional.ofNullable(xQ.poll());
                pos = optional.orElse(-1);
            }

        } else {
            yQ.add(playerPos);
            if (yQ.size() > boardSize) {
                optional = Optional.ofNullable(xQ.poll());
                pos = optional.orElse(-1);
            }
        }
//        pos--;
        arr[pos / boardSize][pos % boardSize ] = ' ';
    }

    private static int[] getPos(int pos) {
        int si = arr.length;
        int rem = pos % si; // to locate the pos in the column
        int row = (rem != 0) ? pos / si : pos / si - 1;
        int col = (rem != 0) ? rem - 1 : si - 1;
        return new int[]{row, col};
    }

    private static void mark(int pos, char player) {
        int[] po = getPos(pos);
        if (arr[po[0]][po[1]] == 'X' || arr[po[0]][po[1]] == 'Y') {
            System.out.println("Already marked");
            return;
        }
        noOfPlays++;
        arr[po[0]][po[1]] = player;
    }

    private static void displayBoard() {
        for (char[] a : arr) {
            System.out.println(" -------------");
            System.out.print(" | ");
            for (char ele : a) System.out.print(ele + " | ");
            System.out.println();
        }
        System.out.println("=================================");
    }


    private static void checkCompleted(int pos, char player) {
        int[] po = getPos(pos);
        int row = po[0], col = po[1];
        mark(pos, player);//to mark specified position
        int size = arr.length;
        int rc = 0, cc = 0, rd = 0, ld = 0;
        for (int i = 0; i < size; i++) {
            if (arr[row][i] == player) rc++;
            if (arr[i][col] == player) cc++;
            if (arr[i][i] == player) rd++;
            if (arr[i][size - 1 - i] == player) ld++;
        }
        if (rc == size || cc == size || ld == size || rd == size) {
            System.out.println("Player " + player + " is winner");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of board");
        boardSize = scan.nextInt();
        createMatrix(boardSize);
        noOfPlays = 0;
        char[] players = {'X', 'Y'};
        do {
            char play = players[noOfPlays % 2];
            System.out.format("Player %c chance\nEnter the position\n", play);
            displayBoard();
            int n = scan.nextInt();
            checkCompleted(n, play);
            checkFill(n, play);
            System.out.println("board");
            System.out.println(xQ + " " + yQ);
        } while (noOfPlays < (boardSize * boardSize));
        System.out.println("Game ended as tie");

    }
}