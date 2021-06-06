package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String nineSymbols = sc.next();
        System.out.println(nineSymbols);

        char[] input = new char[9];

        for (int i = 0; i < 9; i++){
            input[i] = nineSymbols.charAt(i);
        }

        System.out.println("---------");
        for (int j = 0; j < 3; j++) {
            System.out.print("| ");
            for (int i = 0; i < 3; i++) {
                System.out.print(input[i + 3 * j] + " ");
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }
}
