package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // step 1: print empty board
        // step 2: input and test the quality
        // step 3: test the input is O or X (use count)
        // step 4: recreate printBoard
        // step 5: test who just won else if no one won loop back to step 2
        //
        // step 2 to 5 is the while loop

        Scanner sc = new Scanner(System.in);
        boolean result = true;

        char[] inputList = new char[9];
        for (int i = 0; i < 9; i++) {
            inputList[i] = ' ';
        }

        int[][] in = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        int count = 0;
        int input1;
        int input2;
        int x = 0;
        int o = 0;

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print("  ");
                if (j == 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println("---------");

        while (result) {
            System.out.print("Enter the coordinates: ");
            if (!sc.hasNextInt()) {
                System.out.println("You should enter numbers!");
            } else {
                input1 = sc.nextInt();
                input2 = sc.nextInt();

                if (input1 >= 4 || input2 >= 4) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    int index1 = in[input1 - 1][input2 - 1];
                    if (inputList[index1] == ' ') {
                        if (count % 2 == 0) {
                            inputList[index1] = 'X';
                            x++;
                        } else {
                            inputList[index1] = 'O';
                            o += 1;
                        }

                        switchCo(inputList);
                        count++;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
            }

            char[][] matrix = new char[3][3];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = inputList[j + 3 * i];
                }
            }
            int xWin = 0, oWin = 0;

            for (int i = 0; i < 3; i++) {
                int orig = 0;
                for (int j = 0; j < 3; j++) {
                    orig += matrix[i][j];
                }
                if (orig == 264) {
                    xWin = 1;
                } else if (orig == 237) {
                    oWin = 1;
                }
            }
            for (int i = 0; i < 3; i++) {
                int orig = 0;
                for (int j = 0; j < 3; j++) {
                    orig += matrix[j][i];
                }
                if (orig == 264) {
                    xWin = 1;
                } else if (orig == 237) {
                    oWin = 1;
                }
            }
            for (int i = 0; i < 3; i++) {
                int orig = 0;
                orig += matrix[i][i];
                if (orig == 264) {
                    xWin = 1;
                } else if (orig == 237) {
                    oWin = 1;
                }
            }

            if (matrix[0][2] + matrix[1][1] + matrix[2][0] == 264) {
                xWin = 1;
            } else if (matrix[0][2] + matrix[1][1] + matrix[2][0] == 237) {
                oWin = 1;
            }

            if (xWin == 1 && oWin == 0) {
                System.out.println("X wins");
                result = false;
            } else if (xWin == 0 && oWin == 1) {
                System.out.println("O wins");
                result = false;
            } else if (x + o ==9 && xWin == 0 && oWin == 0){
                System.out.println("Draw");
                result = false;
            }
        }
    }

    public static void switchCo(char[] inputList) {

        System.out.println("---------");
        int p1 = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(inputList[p1++] + " ");
                if (j == 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }
}



