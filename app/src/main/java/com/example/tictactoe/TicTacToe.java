package com.example.tictactoe;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        String[][] ticTacToe = startGame();
        int counterOfMovements = 1;
        String player;

        while (!isNoMovement(ticTacToe))
            try {
                if (counterOfMovements % 2 == 1) {
                    player = "X";
                } else player = "0";

                System.out.println("Move " + player + ". Enter two numbers from 1 to 9.");

                int cellNumber = writeIndex();
                int[] indexes = getNumberOfCell(cellNumber);
                int index1 = indexes[0];
                int index2 = indexes[1];

                if (isCorrectIndex(cellNumber)) {
                    if (isEmpty(ticTacToe, cellNumber)) {
                        ticTacToe[index1][index2] = player;
                        counterOfMovements++;
                        for (int i = 0; i < 3; i++) {
                            System.out.println(Arrays.deepToString(ticTacToe[i]));
                        }
                    } else {
                        System.out.println("Error! Cell is busy.");
                    }
                } else {
                    System.out.println("Error! The cell with that number doesn't exist.");
                }

                if (isGameOver(ticTacToe, player)) {
                    System.out.println("Game is over. The winner is " + player + ". Congratulations!!! ");
                    break;
                } else if (isNoMovement(ticTacToe)) {
                    System.out.println("Game is over. No sides! ");
                }

            } catch (Exception e) {
                System.out.println("Error! Enter a number in the range from 1 to 9.");
                continue;
            }
    }

    // Functions:
    static String[][] startGame() {
        String[][] ticTacToe = new String[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(ticTacToe[i], "#");
            System.out.println(Arrays.deepToString(ticTacToe[i]));
        }
        return ticTacToe;
    }

    static int writeIndex() {
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        return index;
    }

    static boolean isEmpty(String[][] base, int cellNumber) {
        int[] indexes = getNumberOfCell(cellNumber);
        int index1 = indexes[0];
        int index2 = indexes[1];
        boolean isEmpty = base[index1][index2] == "#" ? true : false;
        return isEmpty;
    }

    static boolean isCorrectIndex(int index) {
        boolean isCorrectIndex = index > 0 && index <= 9 ? true : false;
        return isCorrectIndex;
    }

    static boolean isGameOver(String[][] base, String x) {
        boolean isGameOver;
        if (Objects.equals(base[0][0], x) && Objects.equals(base[1][0], x) && Objects.equals(base[2][0], x) ||
                Objects.equals(base[0][1], x) && Objects.equals(base[1][1], x) && Objects.equals(base[2][1], x) ||
                Objects.equals(base[0][2], x) && Objects.equals(base[1][2], x) && Objects.equals(base[2][2], x) ||
                Objects.equals(base[0][0], x) && Objects.equals(base[0][1], x) && Objects.equals(base[0][2], x) ||
                Objects.equals(base[1][0], x) && Objects.equals(base[1][1], x) && Objects.equals(base[1][2], x) ||
                Objects.equals(base[2][0], x) && Objects.equals(base[2][1], x) && Objects.equals(base[2][2], x) ||
                Objects.equals(base[0][0], x) && Objects.equals(base[1][1], x) && Objects.equals(base[2][2], x) ||
                Objects.equals(base[0][2], x) && Objects.equals(base[1][1], x) && Objects.equals(base[2][0], x)) {
            isGameOver = true;
        } else {
            isGameOver = false;
        }
        return isGameOver;
    }

    static boolean isNoMovement(String[][] base) {
        boolean isNoMovement;
        int counterFreeCells = 0;
        for (String[] cell : base) {
            for (String cell1 : cell) {
                if (cell1 == "#") {
                    counterFreeCells++;
                }
            }
        }
        isNoMovement = counterFreeCells <= 0;
        return isNoMovement;
    }

    static int[] getNumberOfCell(int cellNumber) {
        int[] indexOfCell = new int[2];
        switch (cellNumber) {
            case 1:
                indexOfCell[0] = 0;
                indexOfCell[1] = 0;
                break;
            case 2:
                indexOfCell[0] = 0;
                indexOfCell[1] = 1;
                break;
            case 3:
                indexOfCell[0] = 0;
                indexOfCell[1] = 2;
                break;
            case 4:
                indexOfCell[0] = 1;
                indexOfCell[1] = 0;
                break;
            case 5:
                indexOfCell[0] = 1;
                indexOfCell[1] = 1;
                break;
            case 6:
                indexOfCell[0] = 1;
                indexOfCell[1] = 2;
                break;
            case 7:
                indexOfCell[0] = 2;
                indexOfCell[1] = 0;
                break;
            case 8:
                indexOfCell[0] = 2;
                indexOfCell[1] = 1;
                break;
            case 9:
                indexOfCell[0] = 2;
                indexOfCell[1] = 2;
                break;
        }
        return indexOfCell;
    }
}
