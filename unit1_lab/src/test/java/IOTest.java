import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public abstract class IOTest {
    private final InputStream standardIn = System.in;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // Utility to provide simulated input
    public void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    public String getOutput() { return outputStreamCaptor.toString();}

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture the output
    }

    @AfterEach
    public void tearDown() {
        System.setIn(standardIn); // Restore standard input
        System.setOut(standardOut); // Restore standard output
    }
}
