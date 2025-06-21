public class HtmlElementExtractor {

    /**
     * Extracts the inner content between the first occurrence of the given tag
     * (case-insensitive).
     *
     * @param html    the input HTML-like string
     * @param tagName the tag to search for (e.g., "title", "body")
     * @return the content between the tag, or null if not found properly
     */
    public static String extractTagContent(String html, String tagName) {
        String lowerHtml = html.toLowerCase();
        String openTag = "<" + tagName.toLowerCase() + ">";
        String closeTag = "</" + tagName.toLowerCase() + ">";

        int start = lowerHtml.indexOf(openTag);
        if (start == -1)
            return null;

        int contentStart = start + openTag.length();
        int end = lowerHtml.indexOf(closeTag, contentStart);
        if (end == -1)
            return null;

        return html.substring(contentStart, end); // return original content
    }

    public static void main(String[] args) {
        String html = "<TItLe>Welcome to My Site</tiTle><BODY>This is the homepage.</body><p>Missing end tag.<footer>Contact us</footer>";

        System.out.println(extractTagContent(html, "title")); // Welcome to My Site
        System.out.println(extractTagContent(html, "BoDy")); // This is the homepage.
        System.out.println(extractTagContent(html, "FOOTER")); // Contact us
        System.out.println(extractTagContent(html, "header")); // null
        System.out.println(extractTagContent(html, "p")); // null
    }
}
