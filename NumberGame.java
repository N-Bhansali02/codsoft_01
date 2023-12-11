import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = generateRandomNumber();
            int attempts = 0;

            System.out.println("Guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND);

            while (attempts < MAX_ATTEMPTS) {
                int userGuess = getUserGuess(scanner);

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }

            totalScore += MAX_ATTEMPTS - attempts;

            System.out.println("Your current score: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing! Your final score: " + totalScore);
        scanner.close();
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
    }

    private static int getUserGuess(Scanner scanner) {
        int userGuess = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter your guess: ");
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }
        }

        return userGuess;
    }
}
