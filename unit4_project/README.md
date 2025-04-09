# CMSC 115 Unit 4 Programming Projects

### Learning Objectives

### Introduction

In this project, you'll simulate an AI-Powered Sales Assistant that tracks
sales, provides recommendations for inventory restocking, and determines if
sales targets have been met. It will use loops to manage user interactions and
process data.

### Task 1: `for` Loop - Sales Assistant

**Objective**: The `SalesAssistant` class simulates a sales assistant tool that
helps users track their daily sales progress toward a specified target. Using a
`for` loop, the program collects daily sales input, calculates cumulative sales,
average daily sales, and predicts whether the target will be met. At the end, it
provides feedback on the final sales performance and offers suggestions for
improvement if the target is not achieved.

Sample where sales meet the $800 target within 4 days:

```text
Enter your sales target: $800
Enter the number of days: 4

Enter sales for day 1: $100
Current Total: $100.00 | Daily Avg: $100.00 | Days Left: 3 | Predicted Total: $400.00
PREDICTION: TARGET AT RISK.

Enter sales for day 2: $250
Current Total: $350.00 | Daily Avg: $175.00 | Days Left: 2 | Predicted Total: $700.00
PREDICTION: TARGET AT RISK.

Enter sales for day 3: $300
Current Total: $650.00 | Daily Avg: $216.67 | Days Left: 1 | Predicted Total: $867.00
PREDICTION: TARGET ACHIEVABLE.

Enter sales for day 4: $200
Current Total: $850.00 | Daily Avg: $212.50 | Days Left: 0 | Predicted Total: $850.00
PREDICTION: TARGET ACHIEVABLE.

Target: $800.00 | Total: $850.00 | Congratulations! You met your target.
```

Sample where sales do not meet the $1000 target within 5 days:

```text
Enter your sales target: $1000
Enter the number of days: 5

Enter sales for day 1: $150
Current Total: $150.00 | Daily Avg: $150.00 | Days Left: 4 | Predicted Total: $750.00
PREDICTION: TARGET AT RISK.

Enter sales for day 2: $200
Current Total: $350.00 | Daily Avg: $175.00 | Days Left: 3 | Predicted Total: $525.00
PREDICTION: TARGET AT RISK.

Enter sales for day 3: $300
Current Total: $650.00 | Daily Avg: $216.67 | Days Left: 2 | Predicted Total: $1083.33
PREDICTION: TARGET ACHIEVABLE.

Enter sales for day 4: $100
Current Total: $750.00 | Daily Avg: $187.50 | Days Left: 1 | Predicted Total: $937.50
PREDICTION: TARGET AT RISK.

Enter sales for day 5: $180
Current Total: $930.00 | Daily Avg: $186.00 | Days Left: 0 | Predicted Total: $930.00
PREDICTION: TARGET AT RISK.

Target: $1000.00 | Total: $930.00 | Target not met. Focus on high-value sales or expanding your outreach.
```

### Task 2: `while` Loop - Inventory Management

**Objective**: The `InventoryManager` program helps manage inventory by
prompting the user to input the initial stock and a low stock threshold. Using a
while loop, it allows the user to enter order quantities, adjusting the
inventory and providing feedback after each transaction; it will not fulfill an
order if there is insufficient inventory. The program alerts the user when
inventory falls below the threshold and stops once the inventory is depleted,
prompting for a restock.

| **Rule**                                                                  | **Specific Output**                          |
| ------------------------------------------------------------------------- | -------------------------------------------- |
| **Order quantity exceeds available stock**                                | "Insufficient inventory. Only X items left." |
| **Order successfully processed**                                          | "Order filled. Remaining inventory: X"       |
| **Inventory falls below the low stock threshold (after order is filled)** | "Low stock. Time to restock."                |
| **Inventory is fully depleted**                                           | "Inventory empty. Restock required."         |

Here is a sample user interaction:

```text
Enter initial inventory and low stock threshold: 100 20

Enter order quantity: 30
Order filled. Remaining inventory: 70

Enter order quantity: 25
Order filled. Remaining inventory: 45

Enter order quantity: 30
Order filled. Remaining inventory: 15
Low stock. Time to restock.

Enter order quantity: 10
Order filled. Remaining inventory: 5
Low stock. Time to restock.

Enter order quantity: 10
Insufficient inventory. Only 5 items left.

Enter order quantity: 5
Order filled. Remaining inventory: 0

Inventory empty. Restock required.
```

### Task 3: `do-while` - Customer Service Chatbot

**Objective**: The `CustomereServiceChatBot` class simulates interactions with
users through a text-based interface. The chatbot uses a `do-while` loop to
continuously ask for user input, and based on specific keywords in the user's
messages, it provides relevant responses such as addressing issues, shipping
details, or return policies. The loop continues until the user types "bye" or
"exit", allowing them to end the conversation at any time.

| **Trigger Keywords**                     | **Response**                                                       |
| ---------------------------------------- | ------------------------------------------------------------------ |
| "problem", "issue"                       | "Customer Support: I'm sorry to hear that."                        |
| "shipping"                               | "Customer Support: Our standard shipping takes 5-7 business days." |
| "return"                                 | "Customer Support: Returns are accepted within 30 days."           |
| Any input not containing "bye" or "exit" | "Customer Support: Can you tell me more?"                          |

```text
Customer Support: Welcome! Type 'bye' or 'exit' to end the chat.

You: I have a problem with my order.
Customer Support: I'm sorry to hear that.

You: Can you tell me about shipping?
Customer Support: Our standard shipping takes 5-7 business days.

You: What is your return policy?
Customer Support: Returns are accepted within 30 days.

You: I'd like  to place an order.
Customer Support: Can you tell me more?

You: exit
Customer Support: Thanks for reaching out. Goodbye!
```

## Submitting your project

TBD

<style>
 th, td {
  border: 1px solid black;
  padding: 4px;
  border-collapse: collapse;

  }
</style>

```

```
