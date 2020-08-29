import java.io.IOException;
import java.util.Scanner;

public class HangmanApplication {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");

        boolean letsPlay = true;
        while (letsPlay) {
            System.out.println();
            System.out.println(" Lets play Hangman !");
            Hangman game = new Hangman();
            do {
                System.out.println();
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                System.out.println();


                System.out.println("Enter a character");
                char guess = (sc.next().toLowerCase()).charAt(0);
                System.out.println();


                if (game.isGuessedAlready(guess)) {
                    System.out.println("Try again. You guessed already");
                    guess = (sc.next().toLowerCase()).charAt(0);
                }

                if (game.playGuess(guess)) {
                    System.out.println(" Guess correct");
                }
                else {
                    System.out.println("sorry that word is not in the guess");
                }
            }
            while (!game.gameover());

            System.out.println();
            System.out.println("Do you want to play another game. Enter Y if you do or press any other word to exit.");
            char response = (sc.next().toUpperCase()).charAt(0);
            letsPlay = (response == 'Y');
        }
    }
}
