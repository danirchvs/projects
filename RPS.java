import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner name = new Scanner(System.in);

        System.out.print("Enter name for Player 1: ");
        String player1 = name.nextLine().trim();
        if (player1.isEmpty()) player1 = "Player 1";

        System.out.print("Enter name for Player 2   : ");
        String player2 = name.nextLine().trim();
        if (player2.isEmpty()) player2 = "Player 2";

        String[] cards = {"Rock", "Paper", "Scissors", "Joker"};
        List<String> list = Arrays.asList(cards);

        Collections.shuffle(list);
        System.out.println(list);

    }
}
