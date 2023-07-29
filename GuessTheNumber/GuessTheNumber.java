//Number guessing game
package GuessTheNumber;

import java.util.Scanner;
import java.util.Random;


class Game {

    private int number;
    private int guessNumber;
    private int numberOfGuesses = 0;


    Game() {
        generateRandomNumber();
    }

    private void generateRandomNumber() {
        Random random = new Random();
        number = random.nextInt(10) + 1;
    }

    void playGame() {
        do {
            numberOfGuesses++;
            System.out.println("Enter your guess: ");
            guessNumber = getUserInput();
            isCorrect();
        }while(guessNumber != number);
        System.out.println("Congratulations! You guessed the number in " + numberOfGuesses + " guesses.");
    }

    private int getUserInput() {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.next(); // Consume invalid input
            return getUserInput();
        }
    }

    private void isCorrect() {
        if (guessNumber == number)
            System.out.println("You win");
        else if (guessNumber > number)
            System.out.println("Number is too large");
        else
            System.out.println("Number is too small");
    }
}


public class GuessTheNumber {
    public static void main(String[] args) {
        Game game1 = new Game();
        game1.playGame();
    }
}


//Encapsulate class members: To improve encapsulation, we should make the class members private and provide access to
// them through methods (getters and setters).

