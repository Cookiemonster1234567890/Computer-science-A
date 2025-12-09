import java.util.*;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner textbox = new Scanner(System.in);
        int sizeOfGuess = textbox.nextInt();
        Random randomNumber = new Random();
        String again = "YEEHAWWW";
        int total = 0;
        int games = 0;
        int best = 9999;
        int yourGuess = 0;
        int tries = 0;

        while (again.toLowerCase().startsWith("y")) {
            int number = randomNumber.nextInt(sizeOfGuess) + 1;

            System.out.println("I'm thinking of a number 1–100.");
            while (yourGuess != number) {
                System.out.print("Your guess? ");
                yourGuess = textbox.nextInt();
                tries++;
                if (yourGuess < number) System.out.println("its higher");
                else if (yourGuess > number) System.out.println("its lower");
                else System.out.println("you got it right in " + tries + " guesses");
            }
            total += tries;
            games++;
            if (tries < best) best = tries;
            System.out.print("Play again? ");
            again = textbox.next();
        }
        System.out.println("Overall results:");
        System.out.println("Total games = " + games);
        System.out.println("Total guesses = " + total);
        System.out.println("guesses/game = " + total / games);
        System.out.println("Best game = " + best);
    }
}