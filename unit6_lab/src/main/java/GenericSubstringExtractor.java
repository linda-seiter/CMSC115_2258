public class GenericSubstringExtractor {

    /**
     * Extracts all substrings between the given start and end delimiters
     * (case-sensitive match), and returns them as a single string.
     *
     * The returned substrings preserve the original casing/content from the input.
     *
     * @param text       The input text with delimited content.
     * @param startDelim The start delimiter (must match exactly).
     * @param endDelim   The end delimiter (must match exactly).
     * @return A single string of extracted substrings, separated by newlines.
     */
    public static String extractAllBetween(String text, String startDelim, String endDelim) {
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < text.length()) {
            int start = text.indexOf(startDelim, index);
            if (start == -1)
                break;

            int end = text.indexOf(endDelim, start + startDelim.length());
            if (end == -1)
                break;

            String found = text.substring(start + startDelim.length(), end);
            result.append(found).append("\n");

            index = end + endDelim.length();
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String tasks = "Tasks: [[Buy groceries]], [[Call mom]], and [[Finish homework]].";
        String extractedTasks = extractAllBetween(tasks, "[[", "]]");
        System.out.println("Tasks:");
        System.out.println(extractedTasks);

        String employees = "Name:Alpha Jones,Age:38; NAME:Beta Lee,Age:52; Name:Gamma Nilamo,Age:24; Name:no comma";
        String employeeNames = extractAllBetween(employees, "Name:", ",");
        System.out.println("Names:");
        System.out.println(employeeNames);
    }
}
