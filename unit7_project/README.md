# Unit 7 Project - Physical Training Performance Analyzer

## **Objective**
In this lab, you will develop a **Physical Training (PT) Performance Analyzer** using **1D arrays** in Java. You will:
- Collect and store **PT performance data** for soldiers.
- Compute and display **maximum, minimum, and average** statistics for each exercise.
- Encode each soldier’s **pass/fail status** based on performance thresholds.
- Create modular, clean, and well-organized code using reusable methods to achieve a final outcome.

This lab will reinforce your understanding of **arrays, loops, methods, string formatting, and basic statistics.**


## Introduction

You will develop several methods within the **PTPerformanceAnalyzer** class
to work with 1D arrays.

The `main` method .....

## Restrictions

Do not use methods from the Java `Array` or `Arrays` classes except for the `Arrays.toString()` method.

## **Getting Started**
- Create a Java file named **`PTPerformanceAnalyzer.java`**.
- Use **Scanner** for user input.
- Do **not** use Java Streams or advanced data structures.
- Follow **incremental task-based development**.

---

## **Task 1: Collect PT Data**

Edit the `main` method:
1. Prompt the user for the **number of soldiers**.
2. Create three **parallel arrays** based on the number of soldiers given as input:
    - `names[]` (String) → Stores soldier names.
    - `pushUps[]` (int) → Stores push-up counts.
    - `sitUps[]` (int) → Stores sit-up counts.
3. Prompt the user to enter **one-line inputs** for each soldier in this format:
   "\[Name\] \[Push-ups\] \[Sit-ups\]"

### **Example Input**

```text
Enter the number of soldiers: 3

Enter soldier data (Name PushUps SitUps): 
John 55 65 
Smith 40 50 
Carter 70 80
```


## **Task 2: Compute and Display Statistics**
Write a method:
```java
public static void displayStatistics(int[] activity, String activityName)
```


## Submission Instructions

TBD

## Resources

- [Resource Link 1](example.com)
- [Resource Link 2](example.com)
