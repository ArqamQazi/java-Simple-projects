package BaiscPractice.RockPaoperScissor;

import java.util.Random;
import java.util.Scanner;

enum Choice{
    ROCK,
    PAPER,
    SCISSORS
}

class RockPaperScissor {
    private Choice userChoice;
    private final Choice botChoice;

    public RockPaperScissor() {
        Random random = new Random();
        botChoice = Choice.values()[random.nextInt(Choice.values().length)];
    }

    public void playGame() {
        userChoice = takeInput();
        displayChoice();
        checkGame();
    }

    void displayChoice() {
        System.out.println("You chose " + userChoice.toString());
        System.out.println("Computer chose " + botChoice.toString());
    }

    private void checkGame() {
        if (userChoice == botChoice) {
            System.out.println("It's a draw");
        }
        if ((userChoice == Choice.ROCK && botChoice == Choice.PAPER) ||
                (userChoice == Choice.PAPER && botChoice == Choice.SCISSORS) ||
                (userChoice == Choice.SCISSORS && botChoice == Choice.ROCK))
            System.out.println("You loose");
        else
            System.out.println("You win");


    }

    private Choice takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1 for Rock\n2 for Paper\n3 for Scissors\n");

        while (true) {
            int userInput = sc.nextInt();
            if (userInput <= 3 && userInput >= 1) {
                sc.close();
                return Choice.values()[userInput - 1];
            } else {
                System.out.println("Please enter a valid number (1, 2, or 3)");
            }
        }


    }
}

public class Game {
    public static void main(String[] args) {
        RockPaperScissor game1 = new RockPaperScissor();
        game1.playGame();
    }
}
