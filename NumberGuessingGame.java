import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I have generated a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (!guessedCorrectly && attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += attempts;
                    guessedCorrectly = true;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            rounds++;
            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing! You completed " + rounds + " rounds with a final score of " + score);
        scanner.close();
    }
}
