package com.jspm;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (true) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts;
            
            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange);
            
            for (attempts = 1; attempts <= maxAttempts; attempts++) {
                System.out.print("Attempt " + attempts + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }
            
            System.out.println("Your current score: " + score);
            
            System.out.print("Do you want to play again? (yes/no): ");
            if (!scanner.next().equalsIgnoreCase("yes")) {
                break;
            }
        }
        
        System.out.println("Thank you for playing!");
    }
}
