import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        playAgain(scanner); // Oyunu başlatan çağrı
        scanner.close();
    }

    public static void playAgain(Scanner scanner) {
        Random rnd = new Random();
        String[] words = {"Apple", "Banana", "Phone", "Driver", "Table"};
        String compWord = words[rnd.nextInt(words.length)];
        char[] guessedWord = new char[compWord.length()];

        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int attempts = 6;
        boolean wordGuessed = false;

        while (attempts > 0 && !wordGuessed) {
            System.out.println("\nCurrent guess: " + new String(guessedWord));
            System.out.print("Guess a letter: ");
            char guess = Character.toLowerCase(scanner.nextLine().charAt(0));
            boolean correctGuess = false;

            for (int a = 0; a < compWord.length(); a++) {
                if (Character.toLowerCase(compWord.charAt(a)) == guess) {
                    guessedWord[a] = compWord.charAt(a);
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attempts--;
                System.out.println("Wrong guess! Remaining attempts: " + attempts);
            }


            wordGuessed = true;
            for (int i = 0; i < guessedWord.length; i++) {
                if (guessedWord[i] == '_') {
                    wordGuessed = false;
                    break;
                }
            }
        }

        if (wordGuessed) {
            System.out.println("Congratulations! You have guessed the word: " + compWord);
        } else {
            System.out.println("Sorry, you have run out of attempts. The word was: " + compWord);
        }

        System.out.print("Do you want to play again? (YES/NO): ");
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("yes")) {
            playAgain(scanner);
        } else {
            System.out.println("Thanks for playing!");
        }
    }
}
