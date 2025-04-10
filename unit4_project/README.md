# CMSC 115 Unit 4 Programming Projects

## Learning Objectives

## Introduction

### Task 1: `while` Loop – Inventory Management

**Objective**:  
The `InventoryManager` program manages inventory by prompting the user to enter
the initial inventory quantity and a low stock threshold. It uses a `while` loop
to process order quantities, updating the inventory and providing feedback after
each transaction. If an order exceeds the available inventory, it will not be
fulfilled. The program also notifies the user when inventory falls to or below
the low stock threshold and stops processing orders once inventory is fully
depleted.

| **Condition**                                 | **Output**                                   |
| --------------------------------------------- | -------------------------------------------- |
| Order quantity exceeds available stock        | "Insufficient inventory. Only X items left." |
| Order successfully processed                  | "Order filled. Remaining inventory: X"       |
| Inventory at or below the low stock threshold | "Low stock. Time to restock."                |
| Inventory is fully depleted                   | "Inventory empty."                           |

The implementation is divided into two phases:

---

#### **Phase 1: Processing Orders and Adjusting Inventory**

In this phase, the program will:

1. Prompt the user to enter the initial inventory and low stock threshold (used
   again in Phase 2).
2. Use a `while` loop to continue processing orders until the inventory is
   depleted.
3. For each iteration, prompt the user for an order quantity and subtract it
   from the current inventory.
4. The loop ends when the inventory reaches zero or below.

> **Note**: This phase does not check whether the order quantity exceeds the
> current inventory or provide low stock warnings. It simply subtracts the order
> quantity from the inventory.

**Sample I/O:**

```text
Enter initial inventory and low stock threshold: 100 20

Enter order quantity: 30
Order filled. Remaining inventory: 70

Enter order quantity: 25
Order filled. Remaining inventory: 45

Enter order quantity: 30
Order filled. Remaining inventory: 15

Enter order quantity: 10
Order filled. Remaining inventory: 5

Enter order quantity: 20
Order filled. Remaining inventory: -15

Inventory empty.
```

---

#### **Phase 2: Enforcing Inventory Limits and Monitoring Low Stock**

In this phase, the program will:

1. Prevent inventory from going negative by rejecting orders that exceed
   available stock, displaying an appropriate message.
2. Display a warning message whenever inventory falls at or below the low stock
   threshold.

**Sample I/O:**

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

Enter order quantity: 20
Insufficient inventory. Only 5 items left.
Low stock. Time to restock.

Enter order quantity: 5
Order filled. Remaining inventory: 0
Low stock. Time to restock.

Inventory empty.
```

To verify your implementation, you can run tests using the
`InventoryManagerTest` JUnit class.

### Task 2: `for` Loop - Sales Assistant

**Objective**: Implement the `SalesAssistant` class to simulate a sales
assistant to track daily sales and assess progress towards a sales target. Use a
`for` loop to collect daily sales input, calculate cumulative sales, average
daily sales, and predict whether the target will be met by the end of the
tracking period. After collecting the daily sales, provide final feedback based
on whether the target sales were met.

The implementation will be broken down into three phases:

#### **Phase 1: Reading Daily Sales and Calculating Cumulative Sales**

In this phase, the program will:

1. Prompt the user to input their sales target and the number of days they will
   be tracking their sales.
2. Use a `for` loop to iterate over each day, asking the user to input the sales
   amount for that day.
3. Calculate and display the **current total sales** (cumulative sales) after
   each day’s input. Use String.format to round monetary values to 2 digits
   after the decimal point.

Sample I/O:

```text
Enter your sales target: $800
Enter the number of days: 4

Enter sales for day 1: $100
Current Total: $100.00

Enter sales for day 2: $250
Current Total: $350.00

Enter sales for day 3: $300
Current Total: $650.00

Enter sales for day 4: $200
Current Total: $850.00
```

#### **Phase 2: Compute Average Daily Sales and Remaining Days**

In this phase, the program will:

1. For each day, calculate the **average daily sales** (cumulative sales divided
   by the number of days so far).
2. Display the number of **days remaining** (days left to track).

Sample I/O:

```text
Enter your sales target: $800
Enter the number of days: 4

Enter sales for day 1: $100
Current Total: $100.00 | Daily Avg: $100.00 | Days Left: 3

Enter sales for day 2: $250
Current Total: $350.00 | Daily Avg: $175.00 | Days Left: 2

Enter sales for day 3: $300
Current Total: $650.00 | Daily Avg: $216.67 | Days Left: 1

Enter sales for day 4: $200
Current Total: $850.00 | Daily Avg: $212.50 | Days Left: 0
```

#### **Phase 3: Predicted Sales and Feedback**

In this phase, the program will:

1. Calculate the **predicted total sales** by adding the current total sales to
   the product of the average daily sales and the remaining days.
2. Provide feedback on whether the target is achievable based on the predicted
   total sales:
   - If the predicted total sales are greater than or equal to the target, the
     user is informed that they are on track.
   - If the predicted total sales fall short, the user is warned that the target
     is at risk.
3. After all days are tracked, output the final result showing whether the
   target was met and offers suggestions for improvement if the target is not
   achieved.

**Sample I/O: Sales meet $800 target within 4 days:**

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

---

**Sample I/O: Sales do not meet $1000 target within 3 days:**

```text
Enter your sales target: $1000
Enter the number of days: 3

Enter sales for day 1: $150
Current Total: $150.00 | Daily Avg: $150.00 | Days Left: 2 | Predicted Total: $450.00
PREDICTION: TARGET AT RISK.

Enter sales for day 2: $200
Current Total: $350.00 | Daily Avg: $175.00 | Days Left: 1 | Predicted Total: $525.00
PREDICTION: TARGET AT RISK.

Enter sales for day 3: $300
Current Total: $650.00 | Daily Avg: $216.67 | Days Left: 0 | Predicted Total: $650.00
PREDICTION: TARGET AT RISK.

Target: $1000.00 | Total: $650.00 | Target not met. Focus on high-value sales or expanding your outreach.
```

You can test the solution using the JUnit `SalesAssistantTest` class to confirm
the correctness of calculations and predictions.

- Separate tests are available for both cases where the target is met and where
  it is not met.
- A test checks for the presence of a `for` loop for iterating over daily sales
  inputs.

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
