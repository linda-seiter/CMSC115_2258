
/**
 * JunitHelper class provides static utility methods for Junit tests
 */
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.Tree;
import com.sun.source.util.JavacTask;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class JunitHelper {
    private static PrintStream standardOut = System.out;
    private static InputStream standardIn = System.in;

    /**
     * Executes the main method of the given class using the provided input.
     *
     * @param className - The class to execute
     * @param input     - The user input
     * @return The output of the executed main method
     */
    public static String executeClassWithInput(String className, String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        return captureClassOutput(className);
    }

    /**
     * Captures the output from the main method of the given class.
     *
     * @param className - The class to execute
     * @return The output from the main method
     */
    public static String captureClassOutput(String className) {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        try {
            final Class<?> clazz = Class.forName(className);
            final Method main = clazz.getMethod("main", String[].class);
            final Object[] args = new Object[1];
            args[0] = new String[] {}; // You can customize this if needed
            main.invoke(null, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.setIn(standardIn); // Reset standard input
        System.setOut(standardOut); // Reset standard output
        return outputStreamCaptor.toString();
    }

    /**
     * @param className  - The class name
     * @param methodName - The method name
     * @param pattern    - The regular expression
     * @return The number of times the pattern appears in the method
     */
    public static int countOccurrences(String className, String methodName, String pattern) {
        String methodBodyAsText = getMethodBody(className, methodName);
        Matcher matcher = Pattern.compile(pattern).matcher(methodBodyAsText);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * @param className - The class to read as a file
     * @return The file contents as a String
     */
    public static String getClassAsString(String className) {
        String userDirectory = System.getProperty("user.dir");
        String filePath = userDirectory + "/src/" + className + ".java";
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * @param className  - The class name
     * @param methodName - The method name
     * @return The method body
     */
    public static String getMethodBody(String className, String methodName) {
        // Use absolute path from the project directory, or use a relative path based on
        // the working directory
        String projectPath = Paths.get("").toAbsolutePath().toString(); // Get the root directory of the project

        // IntelliJ Maven build path
        String fileName = projectPath + "/src/main/java/" + className.replace('.', '/') + ".java"; // Adjust file path
                                                                                                   // for Java class

        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        try (final StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null,
                StandardCharsets.UTF_8)) {
            final Iterable<? extends JavaFileObject> compilationUnits = fileManager
                    .getJavaFileObjectsFromFiles(Arrays.asList(new File(fileName)));
            final JavacTask javacTask = (JavacTask) compiler.getTask(null, fileManager, null, null, null,
                    compilationUnits);
            final Iterable<? extends CompilationUnitTree> compilationUnitTrees = javacTask.parse();
            final ClassTree classTree = (ClassTree) compilationUnitTrees.iterator().next().getTypeDecls().get(0);
            final List<? extends Tree> classMemberList = classTree.getMembers();
            final List<MethodTree> classMethodMemberList = classMemberList.stream()
                    .filter(MethodTree.class::isInstance)
                    .map(MethodTree.class::cast)
                    .collect(Collectors.toList());
            final MethodTree method = classMethodMemberList.stream()
                    .filter(m -> m.getName().toString().equals(methodName))
                    .findFirst()
                    .orElse(null);
            return method != null ? method.getBody().toString() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
