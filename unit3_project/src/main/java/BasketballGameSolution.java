import java.util.Scanner;

/**
 * The {@code BasketballGame} class simulates the scoring of a
 * basketball game through four quarters, demonstrating the use of various
 * arithmetic operations on the scores of both the home and away teams.
 *
 * <p>
 * The program prompts the user to input the scores for the home and away teams
 * in the first quarter and then updates and prints the scores after each of the
 * subsequent quarters. The game progresses through several events including
 * score updates, challenges, and free throws.
 * </p>
 *
 * <p>
 * Each quarter uses different arithmetic operations such as multiplication,
 * addition, subtraction, and increment/decrement operators to simulate the game
 * events.
 * </p>
 *
 * @author [Your Name]
 * @version 1.0
 */
public class BasketballGameSolution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int homeScore, awayScore, home1stQtr, away1stQtr;

        // Prompt for home and away scores in the 1st quarter
        System.out.print("Home and away points for 1st quarter: ");
        home1stQtr = input.nextInt();
        away1stQtr = input.nextInt();

        // Initialize scores for the 1st quarter
        homeScore = home1stQtr;
        awayScore = away1stQtr;
        System.out.println("1st quarter scores: home " + homeScore + " away " + awayScore);

        // Home team doubles their score from the 1st quarter using the multiplication
        // assignment operator
        homeScore *= 2;

        // Away team ties the game by matching the home team's score
        awayScore = homeScore;

        // Print the updated scores for the 2nd quarter
        System.out.println("2nd quarter scores: home " + homeScore + " away " + awayScore);

        // Away team challenges the home team's last play. The home team's score
        // decreases by 3 using the subtraction assignment operator.
        homeScore -= 3;

        // Print scores after the challenge
        System.out.println("After challenge: home " + homeScore + " away " + awayScore);

        // Home team increases their score by 10 points using the addition assignment
        // operator.
        homeScore += 10;

        // Away team leads by 5 points, so their score is set to be 5 points ahead of
        // the home team's score.
        awayScore = homeScore + 5;

        // Print the updated scores for the 3rd quarter
        System.out.println("3rd quarter scores: home " + homeScore + " away " + awayScore);

        // Home team receives a free throw from a challenge, increasing their score by 1
        // using the increment operator.
        homeScore++;

        // Print the scores after the free throw challenge
        System.out.println("After challenge: home " + homeScore + " away " + awayScore);

        // In the 4th quarter, the home team scores 1 fewer point than in the 1st
        // quarter. This is achieved by subtracting 1 from their 1st quarter score using
        // the prefix decrement operator, and then adding the result to their current
        // score using the increment assignment operator.
        homeScore += --home1stQtr;

        // Away team loses by 1 point, so their score is set to be 1 point less than the
        // home team's score.
        awayScore = homeScore - 1;

        // Print the final scores for the 4th quarter
        System.out.println("4th quarter scores: home " + homeScore + " away " + awayScore);
    }
}
