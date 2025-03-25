import java.util.Scanner;

public class MissionLogAnalyzer {

    public static void main(String[] args) {
        // Sample mission log
        String missionLog = "Operation Alpha: Mission successful; Personnel: Samira Patel, Alex Chen, Kai Lopez."
                + "Operation Beta: Mission failed; Personnel: Amari Jackson, Noor Al-Farsi."
                + "Operation Gamma: Mission in progress; Personnel: Riley Kim, Casey Brooks, Taylor Lee."
                + "Operation Delta: Mission aborted; Personnel: Jordan Casey, Kai Lopez.";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mission Log Analysis Tool");
        System.out.println("Choose an option:");
        System.out.println("1. Search for personnel by name");
        System.out.println("2. Search for an operation");
        System.out.println("3. Extract personnel for a specific operation");
        System.out.println("4. Extract all operation names");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String result = ""; // String to hold the output

        switch (choice) {
            case 1:
                System.out.print("Enter the personnel name: ");
                String personnelName = scanner.nextLine();
                result = searchPersonnel(missionLog, personnelName);
                break;
            case 2:
                System.out.print("Enter the operation name: ");
                String operationName = scanner.nextLine();
                result = searchOperation(missionLog, operationName);
                break;
            case 3:
                System.out.print("Enter the operation name to extract personnel: ");
                String opNameForPersonnel = scanner.nextLine();
                result = extractPersonnelForOperation(missionLog, opNameForPersonnel);
                break;
            case 4:
                result = extractOperationNames(missionLog);
                break;

            default:
                result = "Invalid choice.";
        }

        // Print the result
        System.out.println(result);

        scanner.close();
    }

    // Method 1: Search for personnel by name
    public static String searchPersonnel(String missionLog, String name) {
        if (missionLog != null && name != null && missionLog.toLowerCase().contains(name.toLowerCase())) {
            return "Found: " + name;
        } else {
            return name + " not found.";
        }
    }

    // Method 2: Search for an operation name and return operation details
    public static String searchOperation(String missionLog, String operationName) {
        if (missionLog == null || operationName == null)
            return operationName + " not found.";
        String searchPattern = "Operation " + operationName;
        int index = missionLog.toLowerCase().indexOf(searchPattern.toLowerCase());

        if (index != -1) {
            int endIndex = missionLog.indexOf(".", index);  // Change from period to semicolon to match updated log format
            String operationDetails = missionLog.substring(index, endIndex + 1);
            return operationDetails;
        } else {
            return operationName + " not found.";
        }
    }

    // Method 3: Extract personnel for a specific operation, calling searchOperation
    public static String extractPersonnelForOperation(String missionLog, String operationName) {
        // Call the searchOperation method to find the operation details
        String operationDetails = searchOperation(missionLog, operationName);

        if (operationDetails.contains("not found")) {
            return operationDetails;  // Operation not found, return the message
        }

        // Now, extract the personnel from the operation details
        int personnelIndex = operationDetails.indexOf("Personnel:");
        if (personnelIndex != -1) {
            String personnelList = operationDetails.substring(personnelIndex + "Personnel:".length()).trim();
            // Remove any trailing punctuation (e.g., period, semicolon)
            if (personnelList.endsWith(".")) {
                personnelList = personnelList.substring(0, personnelList.length() - 1);
            }
            return "Personnel for " + operationName + ": " + personnelList;
        } else {
            return "Personnel not found for operation " + operationName;
        }
    }

    // Method 4: Extract all operation names
    public static String extractOperationNames(String missionLog) {
        if (missionLog == null)
            return "No missions found.";
        String result = "";
        int index = 0;

        while ((index = missionLog.indexOf("Operation", index)) != -1) {
            int endIndex = missionLog.indexOf(":", index);
            if (endIndex != -1) {
                String operationName = missionLog.substring(index + "Operation".length(), endIndex).trim();
                result += operationName + ".";
            }
            index = endIndex + 1; // Move past the colon
        }

        if (result.isEmpty()) {
            return "No missions found.";
        }

        return result;
    }


}
