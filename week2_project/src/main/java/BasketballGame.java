import java.util.Scanner;

/**
 * BasketballGame class demonstrates augmented assignment,
 * increment and decrement operators
 * 
 * @author First Last
 */
public class BasketballGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int homeScore, awayScore, home1stQtr, away1stQtr;

		System.out.print("Home and away points for 1st quarter: ");
		home1stQtr = input.nextInt();
		away1stQtr = input.nextInt();

		// Initialize scores for 1st quarter
		homeScore = home1stQtr;
		awayScore = away1stQtr;
		System.out.println("1st quarter scores: home " + homeScore + " away " + awayScore);

		// 2nd quarter
		// TODO: Home team doubles their score. Use multiplication assignment operator.

		// TODO: Away team ties the game.

		// Print 2nd quarter scores
		System.out.println("2nd quarter scores: home " + homeScore + " away " + awayScore);

		// Away team challenges last play by home team.
		// TODO: Use subtraction assignment operator to decrease home team score by 3

		// Print scores after challenge
		System.out.println("After challenge: home " + homeScore + " away " + awayScore);

		// TODO: Use addition assignment to increase home team score by 10 points

		// TODO: Away team leads the game by 5 points

		// Print 3rd quarter scores
		System.out.println("3rd quarter scores: home " + homeScore + " away " + awayScore);

		// Home team challenge results in free throw.
		// TODO: Use increment operator to increase home team score by 1

		// Print scores after challenge
		System.out.println("After challenge: home " + homeScore + " away " + awayScore);

		// Home team scores 1 fewer point in 4th quarter than they did in 1st quarter
		// TODO: Use the addition assignment operator and the decrement operator

		// TODO: Away team wins loses the game by 1 point.

		// Print 4th quarter scores
		System.out.println("4th quarter scores: home " + homeScore + " away " + awayScore);

	}

}
