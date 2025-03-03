/**
 * BusRoute class demonstrates augmented assignment operators and increment operator.
 * @author First Last
 */
public class BusRouteSolution {

    public static void main(String[] args) {
        int passengers = 0;
        int busStop = 0;
        System.out.println("Bus begins its route");

        //first stop, 8 people get on (addition assignment operator)
        busStop++;
        System.out.println("8 passengers get on at stop#" + busStop);
        passengers += 8;
        System.out.println("Departing stop#" + busStop + " with " + passengers + " passengers");

        //next stop, 2 get off (subtraction assignment operator)
        busStop++;
        System.out.println("2 passengers get off at stop#" + busStop);
        passengers -= 2;
        System.out.println("Departing stop#" + busStop + " with " + passengers + " passengers");

        //TODO: next stop, half the passengers get off (use division assignment operator)
        busStop++;
        passengers /= 2;
        System.out.println("Half the passengers get off at stop#" + busStop);
        System.out.println("Departing stop#" + busStop + " with " + passengers + " passengers");

        //TODO: next stop, the number of passengers triples (use multiplication assignment operator)
        busStop++;
        passengers *= 3;
        System.out.println("The number of passengers triples at stop#" + busStop);
        System.out.println("Departing stop#" + busStop + " with " + passengers + " passengers");

    }

}
