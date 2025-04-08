import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

        @Test
        @DisplayName("PTPerformanceAnalyzer.main prints correct output for 5 trainees")
        public void ptPerformance() throws Exception {
                // Arrange
                String input = """
                                5
                                Morgan 50 60
                                Abel 28 48
                                Tay 43 45
                                Nela 50 50
                                Dina 49 38
                                44
                                48
                                """;
                String expectedOutput = """
                                Enter the number of trainees: Enter Name PushUps SitUps: Enter Name PushUps SitUps: Enter Name PushUps SitUps: Enter Name PushUps SitUps: Enter Name PushUps SitUps:\s
                                Trainee names, push-ups, sit-ups:
                                [Morgan, Abel, Tay, Nela, Dina]
                                [50, 28, 43, 50, 49]
                                [60, 48, 45, 50, 38]

                                Performance Metrics:
                                *** Push-ups *** Max: 50, Min: 28, Mean: 44.00
                                *** Sit-ups *** Max: 60, Min: 38, Mean: 48.20

                                Performance Summaries:
                                Enter minimum push-ups required: Enter minimum sit-ups required: Morgan - Push-ups: 50, Sit-ups: 60 - Pass
                                Abel - Push-ups: 28, Sit-ups: 48 - Fail
                                Tay - Push-ups: 43, Sit-ups: 45 - Fail
                                Nela - Push-ups: 50, Sit-ups: 50 - Pass
                                Dina - Push-ups: 49, Sit-ups: 38 - Fail
                                """;

                // Redirect System.in to simulate user input
                ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
                System.setIn(inputStream);

                // Capture the system output
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(outputStream);
                System.setOut(printStream);

                // Act: Call the main method of PTPerformanceAnalyzer
                PTPerformanceAnalyzer.main(new String[] {});

                // Assert: Compare expected and actual outputs
                String actualOutput = outputStream.toString().trim(); // Removing leading/trailing spaces
                assertEquals(expectedOutput.trim(), actualOutput, "PTPerformanceAnalyzer.main fails for 5 trainees");
        }
}
