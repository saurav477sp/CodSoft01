/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numbergame;

/**
 *
 * @author psaur
 */
import java.util.*;

class NumberGame {
    int gamesWon = 0;
    int totalGamesPlayed = 0;

    public static void main(String args[]) {
        NumberGame game = new NumberGame();
        game.guessnumber();
    }

    public void guessnumber() {
        int number, i, randomNumber, count = 0, attempts = 10;
        String playAgain;

        Random random = new Random();
        randomNumber = random.nextInt(100);

        Scanner sc = new Scanner(System.in);

        System.out.println("In this game you have only 10 attempts");
        System.out.print("Enter the number you guess : ");
        number = sc.nextInt();

        for (i = 0; i < attempts; i++) {

            if (number > randomNumber) {
                System.out.print("Guess number is too high, please enter a smaller number : ");
                number = sc.nextInt();
            } else if (number < randomNumber) {
                System.out.print("Guess number is too low, please enter a higher number : ");
                number = sc.nextInt();
            } else {
                count++;
                break;
            }

        }

        totalGamesPlayed++;

        if (count == 0) {
            System.out.println("You ran out of attempts. The correct number was: " + randomNumber);
        } else {
            System.out.println("Wow! Your guess was correct");
            gamesWon++;
        }
        

        double winningScore = calculateWinningScore();

        System.out.println("Total games won: " + gamesWon);
        System.out.println("Total games played: " + totalGamesPlayed);
        System.out.println("Winning Score: " + String.format("%.2f", winningScore));

        System.out.print("Do you want to play again? (yes/no): ");
        playAgain = sc.next();
        if (playAgain.equals("yes")) {
            guessnumber();
        }
        sc.close();
    }

    public double calculateWinningScore() {
        if (totalGamesPlayed == 0) {
            return 0.0;
        }
        return (double) gamesWon / totalGamesPlayed;
    }
}
