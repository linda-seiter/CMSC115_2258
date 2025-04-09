import java.util.Scanner;

/**
 * The CustomerServiceChatBot class simulates a simple text-based chatbot
 * that provides basic customer service responses based on user input.
 * 
 * The chatbot uses a do-while loop to continuously prompt the user for input
 * until they type "bye" or "exit". It analyzes the user's message using a set
 * of keyword-based rules to generate responses:
 * 
 * Rules:
 * - If the message contains "problem" or "issue", the chatbot expresses
 * sympathy.
 * - If the message contains "shipping", it provides shipping details.
 * - If the message contains "return", it explains the return policy.
 * - For all other messages (that are not "bye"/"exit"), it asks for more
 * details.
 * 
 * @author Your Name
 * @version 1.0
 */

public class CustomerServiceChatBot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userMessage;

        System.out.println("Customer Support: Welcome! Type 'bye' or 'exit' to end the chat.");

        do {
            System.out.print("You: ");
            userMessage = input.nextLine().toLowerCase();

            if (userMessage.contains("problem") || userMessage.contains("issue")) {
                System.out.println("Customer Support: I'm sorry to hear that.");
            } else if (userMessage.contains("shipping")) {
                System.out.println("Customer Support: Our standard shipping takes 5-7 business days.");
            } else if (userMessage.contains("return")) {
                System.out.println("Customer Support: Returns are accepted within 30 days.");
            } else if (!userMessage.equals("bye") && !userMessage.equals("exit")) {
                System.out.println("Customer Support: Can you tell me more?");
            }

        } while (!userMessage.equals("bye") && !userMessage.equals("exit"));

        System.out.println("Customer Support: Thanks for reaching out. Goodbye!");
        input.close();
    }
}
