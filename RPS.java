import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RockPaperScissors {
    public static void main(String[] args) {
        String[] cards = {"Rock", "Paper", "Scissors", "Joker", "Rock", "Paper", "Scissors", "Paper", "Scissors"};
        List<String> list = Arrays.asList(cards);

        Collections.shuffle(list);
        System.out.println(list);

    }
}
