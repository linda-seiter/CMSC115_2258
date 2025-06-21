public class ParenthesisExtractor {

    /**
     * Extracts the first substring found between '(' and ')'.
     *
     * @param text The input string to search.
     * @return The substring between the first pair of parentheses, or null if not
     *         found.
     */
    public static String extractBetweenParentheses(String text) {
        int start = text.indexOf('(');
        int end = text.indexOf(')', start + 1);

        if (start != -1 && end != -1) {
            return text.substring(start + 1, end);
        }

        return null;
    }

    public static void main(String[] args) {
        String result1 = extractBetweenParentheses("Today's task is (complete the report) before lunch.");
        System.out.println(result1); // complete the report

        String result2 = extractBetweenParentheses("3 * (4 - 7) + (n / m)");
        System.out.println(result2); // 4 - 7

        String result3 = extractBetweenParentheses("((3))");
        System.out.println(result3); // (3

        String result4 = extractBetweenParentheses("(missing right paren");
        System.out.println(result4); // null

        String result5 = extractBetweenParentheses(") ( ");
        System.out.println(result5); // null

        String result6 = extractBetweenParentheses("a ) + (4 + 6) ");
        System.out.println(result6); // 4 + 6
    }
}
