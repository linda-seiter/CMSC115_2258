# CMSC 115 Unit 4 Programming Projects

## Learning Objectives

## Introduction

### Task 1: `do-while` : Inventory Management

**Objective**:  
The `InventoryManager` class simulates an inventory management system. It
prompts the user to enter the initial inventory quantity and a low stock
threshold. It uses a `do-while` to loop at least once and read in and process
order quantities, updating the inventory if there is sufficient stock and
providing feedback after each order. However, if an order quantity exceeds the
available inventory, it will not be fulfilled. The program also notifies the
user when inventory falls to or below the low stock threshold. The loop
terminates and stops processing orders once inventory is fully depleted.

| **Condition**                                 | **Output**                                   |
| --------------------------------------------- | -------------------------------------------- |
| Order successfully processed                  | "Order filled. Remaining inventory: X"       |
| Order quantity exceeds available stock        | "Insufficient inventory. Only X items left." |
| Inventory at or below the low stock threshold | "Low stock."                                 |
| Inventory is fully depleted                   | "Inventory empty."                           |

It's a good idea to build the code in steps, starting with Phase 1 and then
moving to Phase 2. This helps make the development process easier and more
organized. The Junit `InventoryManagerSolution` class tests the completed Phase
2 functionality.

- Phase 1: Basic Order Processing (no insufficient or low stock error checking)
- Phase 2: Enforcing Inventory Limits and Monitoring Low Stock

#### Phase 1: Processing Orders and Adjusting Inventory

Edit `InventoryManager` to implement the following functionality:

1. Prompt the user to enter the initial inventory and low stock threshold
   (threshold used later in Phase 2).
2. Use a `do-while` loop to continually prompt for and process orders.
3. The loop should end when the inventory reaches zero or below.

> **Note**: This phase does not check for sufficient inventory nor provide low
> stock warnings. It simply subtracts the order quantity from the inventory,
> thus it is possible to result in a negative inventory.

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

#### Phase 2: Enforcing Inventory Limits and Monitoring Low Stock

Revise `InventoryManager` to implement the following functionality:

1. Avoid filling an order if the order quantity exceeds the inventory and
   display a message indicating insufficient inventory to fill the order.
2. Display a low stock warning message whenever inventory is at or below the
   minimum threshold.

**Sample I/O:**

```text
Enter initial inventory and low stock threshold: 100 20

Enter order quantity: 30
Order filled. Remaining inventory: 70

Enter order quantity: 25
Order filled. Remaining inventory: 45

Enter order quantity: 30
Order filled. Remaining inventory: 15
Low stock.

Enter order quantity: 10
Order filled. Remaining inventory: 5
Low stock.

Enter order quantity: 20
Insufficient inventory. Only 5 items left.
Low stock.

Enter order quantity: 5
Order filled. Remaining inventory: 0
Low stock.

Inventory empty.
```

To verify your implementation, run tests using the `SalesAssistantTest` JUnit
class.

- Several tests check various scenarios for low stock and insufficient
  inventory.
- One test checks for the presence of a `do-while` loop.

### Task 2: `for` Loop - Sales Assistant

**Objective**: The `SalesAssistant` class simulates a sales assistant to track
daily sales and assess progress towards a sales target. The target and number of
days are input by the user. A `for` loop is used to collect daily sales from
user input and calculate cumulative sales, average daily sales, days remaining,
and a prediction of whether the target will be met by the end of the tracking
period. After collecting the daily sales, final feedback is given based on
whether the target sales were met.

It is recommended to implement the code in three phases:

- Phase 1: Loop to read daily sales and calculate cumulative sales
- Phase 2: Compute average daily sales and remaining days
- Phase 3: Predicted sales and provide feedback

#### Phase 1: Reading Daily Sales and Calculating Cumulative Sales

Edit `SalesAssistant` to provide the following functionality:

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

#### Phase 2: Compute Average Daily Sales and Remaining Days

Revise the loop:

1. Calculate the **average daily sales** (cumulative sales divided by the number
   of days so far).
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

#### Phase 3: Predicted Sales and Feedback

Revise the loop:

1. Calculate the **predicted total sales** by adding the current total sales to
   the product of the average daily sales and the remaining days.
2. Provide feedback on whether the target is achievable based on the predicted
   total sales:
   - If the predicted total sales are greater than or equal to the target, the
     user is informed that they are on track.
   - If the predicted total sales fall short, the user is warned that the target
     is at risk.
3. After all days are tracked, output the final result showing whether the
   target was met and offer suggestions for improvement if the target is not
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

You can test the solution using the JUnit `SalesAssistantTest` class.

- Various tests check scenarios where the target is met and where it is not met.
- One test checks for the presence of a `for` loop.

### Task 3: `while` loop - Customer Service Chatbot

**Objective**: The `CustomerServiceChatBot` class simulates interactions with
users through a text-based interface. The chatbot uses a `while` loop to
continuously ask for user input, and based on specific keywords in the user's
messages, it provides relevant responses such as addressing issues, shipping
details, or return policies. The loop continues until the user types "bye" or
"exit", allowing them to end the conversation at any time. The chatbot should
recognize keywords regardless of whether they are typed in uppercase, lowercase,
or a mix of both.

| **Trigger Keywords**            | **Response**                                                       |
| ------------------------------- | ------------------------------------------------------------------ |
| "problem", "issue"              | "Customer Support: I'm sorry to hear that."                        |
| "shipping"                      | "Customer Support: Our standard shipping takes 5-7 business days." |
| "return"                        | "Customer Support: Returns are accepted within 30 days."           |
| Other input not "bye" or "exit" | "Customer Support: Can you tell me more?"                          |

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

You: Bye
Customer Support: Thanks for reaching out. Goodbye!
```

Once again, it is good to solve this using an incremental approach:

- Phase 1: Chat loop that gives single generic response and stops on keyword
  `"bye"`
- Phase 2: Improve loop termination Check — `"bye"` or `"exit"`
  (case-insensitive match)
- Phase 3: Add keyword-based chatbot responses

#### Phase 1: Basic Chat Loop — Stop on `"bye"`

- Print a welcome message.
- Prompt the user with `"You: "` and read input.
- Use a while loop that terminates on the sentinel "bye":
  - Output a generic response "Customer Support: Can you tell me more?"
  - Prompt the user and read input again

**Sample I/O:**

```
Customer Support: Welcome! Type 'bye' to end the chat.
You: Hello
Customer Support: Can you tell me more?
You: I need help
Customer Support: Can you tell me more?
You: bye
Customer Support: Thanks for reaching out. Goodbye!
```

Sample I/O where loop body is skipped:

```text
Customer Support: Welcome! Type 'bye' to end the chat.
You: bye
Customer Support: Thanks for reaching out. Goodbye
```

#### Phase 2: Improve Exit Check — `"bye"` or `"exit"` (case-insensitive)

End the loop if the input is `"bye"` or `"exit"`, regardless of letter case.

HINT: Lowercase the user input.

**Sample I/O:**

```
Customer Support: Welcome! Type 'bye' or 'exit' to end the chat.
You: I need some help
Customer Support: Can you tell me more?
You: EXIT
Customer Support: Thanks for reaching out. Goodbye!
```

---

#### Phase 3: Add Keyword-Based Responses

Check for specific keywords, regardless of case:

- `"problem"` or `"issue"` → **"I'm sorry to hear that."**
- `"shipping"` → **"Our standard shipping takes 5–7 business days."**
- `"return"` → **"Returns are accepted within 30 days."**
- Anything else → **"Can you tell me more?"**

**Sample I/O:**

```
Customer Support: Welcome! Type 'bye' or 'exit' to end the chat.
You: I have a problem
Customer Support: I'm sorry to hear that.
You: How long does ShIPPing take?
Customer Support: Our standard shipping takes 5–7 business days.
You: Can I ReturN it?
Customer Support: Returns are accepted within 30 days.
You: I just wanted to check something
Customer Support: Can you tell me more?
You: BYE
Customer Support: Thanks for reaching out. Goodbye!
```

You can test the final solution using the JUnit `CustomerServiceChatbotTest`
class.

- Various tests check for the trigger keywords.
- One test checks for the presence of a `while` loop.

## Submitting your project

TBD

<style>
 th, td {
  border: 1px solid black;
  padding: 4px;
  border-collapse: collapse;

  }
</style>
