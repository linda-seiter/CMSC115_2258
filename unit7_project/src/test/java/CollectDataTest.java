import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CollectDataTest {

    @Test
    @DisplayName("Collect data for 2 trainees")
    public void input_2_trainees() throws Exception {
        // Simulated user input: (each entry is separated by a newline)
        String simulatedInput = "Jordan 50 62\nTaylor 40 48\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Create arrays with fixed size (matching number of input lines)
        String[] names = new String[2];
        int[] pushUps = new int[2];
        int[] sitUps = new int[2];

        // Use Scanner to read from simulated input
        Scanner scanner = new Scanner(System.in);
        PTPerformanceAnalyzer.collectExerciseData(scanner, names, pushUps, sitUps);
        scanner.close();

        // Expected results after input is processed
        String[] expectedNames = {"Jordan", "Taylor"};
        int[] expectedPushUps = {50, 40};
        int[] expectedSitUps = {62, 48};

        // Assertions to validate data was collected correctly
        assertArrayEquals(expectedNames, names);
        assertArrayEquals(expectedPushUps, pushUps);
        assertArrayEquals(expectedSitUps, sitUps);
    }

    @Test
    @DisplayName("Collect data for 5 trainees")
    public void input_5_trainees() throws Exception {
        // Simulated user input with 5 soldiers (Name PushUps SitUps)
        String simulatedInput = """
            Alex 50 80
            Jordan 40 60
            Taylor 55 75
            Morgan 45 65
            Casey 60 85
            """;

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Create arrays with fixed size (5 soldiers)
        String[] names = new String[5];
        int[] pushUps = new int[5];
        int[] sitUps = new int[5];

        // Use Scanner to read from simulated input
        Scanner scanner = new Scanner(System.in);
        PTPerformanceAnalyzer.collectExerciseData(scanner, names, pushUps, sitUps);
        scanner.close();

        // Expected results after input is processed
        String[] expectedNames = {"Alex", "Jordan", "Taylor", "Morgan", "Casey"};
        int[] expectedPushUps = {50, 40, 55, 45, 60};
        int[] expectedSitUps = {80, 60, 75, 65, 85};

        // Assertions to validate data was collected correctly
        assertArrayEquals(expectedNames, names);
        assertArrayEquals(expectedPushUps, pushUps);
        assertArrayEquals(expectedSitUps, sitUps);
    }
}
