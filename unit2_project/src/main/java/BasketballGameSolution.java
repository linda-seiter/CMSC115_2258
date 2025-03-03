import java.util.Scanner;

/**
 * The {@code BasketballGameSolution} class simulates the scoring of a basketball game
 * through four quarters, demonstrating the use of various arithmetic operations on
 * the scores of both the home and away teams.
 *
 * <p>The program prompts the user to input the scores for the home and away teams in the
 * first quarter and then updates and prints the scores after each of the subsequent quarters.
 * The game progresses through several events including score updates, challenges, and
 * free throws.</p>
 *
 * <p>Each quarter uses different arithmetic operations such as multiplication, addition,
 * subtraction, and increment/decrement operators to simulate the game events.</p>
 *
 * @author [Your Name]
 * @version 1.0
 */
public class BasketballGameSolution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int homeScore, awayScore, home1stQtr, away1stQtr;

        System.out.print("Home and away points for 1st quarter: ");
        home1stQtr = input.nextInt();
        away1stQtr = input.nextInt();

        //Initialize scores for 1st quarter
        homeScore = home1stQtr;
        awayScore = away1stQtr;
        System.out.println("1st quarter scores: home " + homeScore + " away " + awayScore);

        //2nd quarter
        //TODO: Home team doubles their score. Use multiplication assignment operator.
        homeScore *= 2;

        //TODO: Away team ties the game.
        awayScore = homeScore;

        //Print 2nd quarter scores
        System.out.println("2nd quarter scores: home " + homeScore + " away " + awayScore);

        //Away team challenges last play by home team.
        //TODO: Use subtraction assignment operator to decrease home team score by 3
        homeScore -= 3;

        //Print scores after challenge
        System.out.println("After challenge: home " + homeScore + " away " + awayScore);

        //TODO: Use addition assignment to increase home team score by 10 points
        homeScore += 10;

        //TODO: Away team leads the game by 5 points
        awayScore = homeScore + 5;

        //Print 3rd quarter scores
        System.out.println("3rd quarter scores: home " + homeScore + " away " + awayScore);

        //Home team challenge results in free throw.
        //TODO: Use increment operator to increase home team score by 1
        homeScore++;

        //Print scores after challenge
        System.out.println("After challenge: home " + homeScore + " away " + awayScore);

        //Home team scores 1 fewer point in 4th quarter than they did in 1st quarter
        //TODO: Use the addition assignment operator and the decrement operator
        homeScore += --home1stQtr;

        //TODO: Away team wins loses the game by 1 point.
        awayScore = homeScore - 1;

        //Print 4th quarter scores
        System.out.println("4th quarter scores: home " + homeScore + " away " + awayScore);

    }
}