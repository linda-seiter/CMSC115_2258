/**
 * DebugIt class demonstrates common operator errors.
 * 
 * @author First Last
 */
public class DebugIt {

	// TODO: Fix the operator errors
	public static void main(String[] args) {
		int planesOnRunway = 2;

		// 5 planes land on runway, increase planesOnRunway by 5
		planesOnRunway = +5; // expected value: 7
		// 3 planes take off, decrease planesOnRunway by 3
		planesOnRunway = -3; // expected value: 4

		System.out.println("Planes on runway = " + planesOnRunway);
	}

}
