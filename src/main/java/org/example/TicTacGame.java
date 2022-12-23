package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TicTacGame {

    static int[][] board = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    static int whichField;
    static Set<Integer> choicesMade = new HashSet();
    static int player = 2;
    static boolean draw =true;

    static void putTheFigureOnTheBoard(int choice, int playerOneOrTwo, int[][] board) {
        switch(choice) {
            case 1:
                board[0][0] = playerOneOrTwo;
                break;
            case 2:
                board[0][1] = playerOneOrTwo;
                break;
            case 3:
                board[0][2] = playerOneOrTwo;
                break;
            case 4:
                board[1][0] = playerOneOrTwo;
                break;
            case 5:
                board[1][1] = playerOneOrTwo;
                break;
            case 6:
                board[1][2] = playerOneOrTwo;
                break;
            case 7:
                board[2][0] = playerOneOrTwo;
                break;
            case 8:
                board[2][1] = playerOneOrTwo;
                break;
            case 9:
                board[2][2] = playerOneOrTwo;
        }

    }

    static boolean wasItAVictory(int[][] board, int player) {
        if (board[0][0] == player && board[0][1] == player && board[0][2] == player) {
            System.out.print("Victory of player");
            return true;
        } else if (board[1][0] == player && board[1][1] == player && board[1][2] == player) {
            System.out.print("Victory of player");
            return true;
        } else if (board[2][0] == player && board[2][1] == player && board[2][2] == player) {
            System.out.print("Victory of player");
            return true;
        } else if (board[0][0] == player && board[1][0] == player && board[2][0] == player) {
            System.out.print("Victory of player");
            return true;
        } else if (board[0][1] == player && board[1][1] == player && board[2][1] == player) {
            System.out.print("Victory of player");
            return true;
        } else if (board[0][2] == player && board[1][2] == player && board[2][2] == player) {
            System.out.print("Victory of player");
            return true;
        } else if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            System.out.print("Victory of player");
            return true;
        } else if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
            System.out.print("Victory of player");
            return true;
        } else {
            return false;
        }
    }

    static int playerChange(int player) {
        return player == 1 ? 2 : 1;
    }

    static void displayBoardOnTheScreen(int whichField) {
        if (whichField != 0) {
            for(int i = 0; i < 3; ++i) {
                for(int j = 0; j < 3; ++j) {
                    if (board[i][j] == 1) {
                        System.out.print('x');
                    } else if (board[i][j] == 2) {
                        System.out.print('o');
                    } else {
                        System.out.print('_');
                    }
                }

                System.out.println();
            }
        }
    }

    public static void isADraw(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    draw = false;
                }
            }
        }
    }

    public static void printingWonPlayer(){
        if (!draw && whichField != 0) {
            if (player == 2) {
                System.out.print(" \"o\"!");
            } else {
                System.out.print(" \"x\"!");
            }
        }
    }

    public static void TicTacToeRun() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Available fields:");
        System.out.println("1|2|3\n4|5|6\n7|8|9");

        do {
            if (player == 2) {
                System.out.println("\"x\" player's move. Choose a field.");
            } else {
                System.out.println("\"o\" player's move. Choose a field.");
            }

            for(whichField = sc.nextInt(); choicesMade.contains(whichField); whichField = sc.nextInt()) {
                System.out.println("This field is occupied. Choose other one.");
            }

            choicesMade.add(whichField);
            player = playerChange(player);
            putTheFigureOnTheBoard(whichField, player, board);
            displayBoardOnTheScreen(whichField);
            boolean victory = wasItAVictory(board, player);
            if (victory) {
                break;
            }

            isADraw();

            if (draw) {
                System.out.println("No one won. Draw!");
                break;
            }
        } while(whichField != 0);

        printingWonPlayer();
    }
}
