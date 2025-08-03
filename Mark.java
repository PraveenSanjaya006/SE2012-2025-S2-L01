// Filename: Mark.java
import java.util.Scanner;

public class Mark {
    // Constants for subject IDs
    static final int MATH = 0;
    static final int CHEMISTRY = 1;
    static final int PHYSICS = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students (n): ");
        int n = scanner.nextInt();

        // 2D array to store marks [studentID][subjectID]
        int[][] marks = new int[n + 1][3]; // student IDs from 1 to n

        // Main menu loop
        while (true) {
            System.out.print("\nMenu:\n"
                + "1. Add student marks: add [studentID]\n"
                + "2. Update student mark: update [studentID] [subjectID]\n"
                + "3. Get average for a student: average [studentID]\n"
                + "4. Get average for a subject: average_s [subjectID]\n"
                + "5. Get total mark of a student: total [studentID]\n"
                + "6. Exit\n"
                + "Enter command: ");

            String command = scanner.next();

            if (command.equalsIgnoreCase("add")) {
                int id = scanner.nextInt();
                if (id >= 1 && id <= n) {
                    System.out.print("Enter Mathematics mark: ");
                    marks[id][MATH] = scanner.nextInt();
                    System.out.print("Enter Chemistry mark: ");
                    marks[id][CHEMISTRY] = scanner.nextInt();
                    System.out.print("Enter Physics mark: ");
                    marks[id][PHYSICS] = scanner.nextInt();
                    System.out.println("Marks added for Student " + id);
                } else {
                    System.out.println("Invalid student ID.");
                }

            } else if (command.equalsIgnoreCase("update")) {
                int id = scanner.nextInt();
                int subId = scanner.nextInt();
                if (id >= 1 && id <= n && subId >= 1 && subId <= 3) {
                    System.out.print("Enter new mark for subject " + subId + ": ");
                    marks[id][subId - 1] = scanner.nextInt();
                    System.out.println("Mark updated.");
                } else {
                    System.out.println("Invalid student ID or subject ID.");
                }

            } else if (command.equalsIgnoreCase("average")) {
                int id = scanner.nextInt();
                if (id >= 1 && id <= n) {
                    double avg = (marks[id][MATH] + marks[id][CHEMISTRY] + marks[id][PHYSICS]) / 3.0;
                    System.out.printf("Average marks for Student %d: %.2f\n", id, avg);
                } else {
                    System.out.println("Invalid student ID.");
                }

            } else if (command.equalsIgnoreCase("average_s")) {
                int subId = scanner.nextInt();
                if (subId >= 1 && subId <= 3) {
                    int total = 0;
                    for (int i = 1; i <= n; i++) {
                        total += marks[i][subId - 1];
                    }
                    double avg = total / (double) n;
                    String subName = (subId == 1) ? "Mathematics" : (subId == 2) ? "Chemistry" : "Physics";
                    System.out.printf("Average for %s: %.2f\n", subName, avg);
                } else {
                    System.out.println("Invalid subject ID.");
                }

            } else if (command.equalsIgnoreCase("total")) {
                int id = scanner.nextInt();
                if (id >= 1 && id <= n) {
                    int total = marks[id][MATH] + marks[id][CHEMISTRY] + marks[id][PHYSICS];
                    System.out.println("Total marks for Student " + id + ": " + total);
                } else {
                    System.out.println("Invalid student ID.");
                }

            } else if (command.equalsIgnoreCase("exit") || command.equals("6")) {
                System.out.println("Exiting program.");
                break;

            } else {
                System.out.println("Invalid command. Try again.");
            }
        }

        scanner.close();
    }
}