public class HrMinToMinTestHarness {
    public static double hrMinToMin(int origHours, int origMinutes) {
        int totMinutes; // Resulting minutes

        totMinutes = (origHours * 60) + origMinutes;

        return origMinutes;
    }

    public static void main(String[] args) {
        System.out.println("Testing started");
        assert (7 == 8) : "Assertion (7 == 8) failed";
        assert (hrMinToMin(0, 0) == 0) : "Assertion (hrMinToMin(0, 0) == 0) failed";
        assert (hrMinToMin(0, 1) == 1) : "Assertion (hrMinToMin(0, 1) == 1) failed";
        assert (hrMinToMin(0, 99) == 99) : "Assertion (hrMinToMin(0, 99) == 99) failed";
        assert (hrMinToMin(1, 0) == 60) : "Assertion (hrMinToMin(1, 0) == 60) failed";
        assert (hrMinToMin(5, 0) == 300) : "Assertion (hrMinToMin(5, 0) == 300) failed";
        assert (hrMinToMin(2, 30) == 150) : "Assertion (hrMinToMin(2, 30) == 150) failed";
        // Many more test vectors would be typical...

        System.out.println("Testing completed");
    }
}
