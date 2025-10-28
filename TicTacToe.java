package projects;

import java.util.Scanner;

public class TicTacToe {

    // Prints the current board
    public static void printBoard(String[] board) {
        System.out.println("+---+---+---+");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("+---+---+---+");
    }

    // Checks if there is a winner
    public static String checkWinner(String[] b) {
        int[][] winCombos = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}              // diagonals
        };

        for (int[] combo : winCombos) {
            if (b[combo[0]].equals(b[combo[1]]) && b[combo[1]].equals(b[combo[2]])) {
                return b[combo[0]]; // Return "X" or "O"
            }
        }

        // Check for draw
        boolean full = true;
        for (String s : b) {
            if (s.matches("[1-9]")) {
                full = false;
                break;
            }
        }

        if (full) return "draw";

        return null; // No winner yet
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] board = new String[9];

        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }

        System.out.println("Play Tic Tac Toe with a friend!\n");

        // Ask for player names
        System.out.print("Enter name for Player 1 (X): ");
        String player1 = input.nextLine().trim();
        if (player1.isEmpty()) player1 = "Player 1";

        System.out.print("Enter name for Player 2 (O): ");
        String player2 = input.nextLine().trim();
        if (player2.isEmpty()) player2 = "Player 2";

        System.out.println("\nLet's start the game!");
        printBoard(board);

        String winner = null;
        String currentPlayer = "X";

        while (winner == null) {
            String playerName = currentPlayer.equals("X") ? player1 : player2;

            System.out.print(playerName + " (" + currentPlayer + ") turn, pick a slot number (1 to 9): ");
            String move = input.nextLine();

            int pos;
            try {
                pos = Integer.parseInt(move) - 1;
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number from 1 to 9.");
                continue;
            }

            // Check valid move
            if (pos < 0 || pos > 8 || !(board[pos].matches("[1-9]"))) {
                System.out.println("Slot already taken or invalid. Try again.");
                continue;
            }

            // Place move
            board[pos] = currentPlayer;
            printBoard(board);

            // Check for winner or draw
            winner = checkWinner(board);

            // Switch player
            if (winner == null) {
                currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
            }
        }

        // Display result
        if (winner.equals("draw")) {
            System.out.println("it's a draw! great game, " + player1 + " and " + player2 + "!");
        } else {
            String winningPlayer = winner.equals("X") ? player1 : player2;
            System.out.println( winningPlayer + " won! congratulations !");
        }

        System.out.println("game over <//3 thanks for playing!");
        input.close();
    }
}
