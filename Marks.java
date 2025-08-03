// Filename: Marks.java
import java.util.Scanner;
//public class Main
public class Marks {
    static final int MATH = 0;
    static final int CHEMISTRY = 1;
    static final int PHYSICS = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students (n): ");
        int n = scanner.nextInt();

        int[][] marks = new int[n + 1][3]; // student IDs from 1 to n

        while (true) {
            System.out.print("\nMenu:\n"
                + "add [studentID] - Add student marks\n"
                + "update [studentID] [subjectID] - Update student mark\n"
                + "average [studentID] - Average marks for a student\n"
                + "average_s [subjectID] - Average marks for a subject\n"
                + "total [studentID] - Total marks for a student\n"
                + "grades - Display grade table for all students\n"
                + "exit - Exit program\n"
                + "Enter command: ");

            String command = scanner.next();

            if (command.equalsIgnoreCase("add")) {
                int id = scanner.nextInt();
                if (isValidStudent(id, n)) {
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
                if (isValidStudent(id, n) && isValidSubject(subId)) {
                    System.out.print("Enter new mark for subject " + subId + ": ");
                    marks[id][subId - 1] = scanner.nextInt();
                    System.out.println("Mark updated.");
                } else {
                    System.out.println("Invalid student ID or subject ID.");
                }

            } else if (command.equalsIgnoreCase("average")) {
                int id = scanner.nextInt();
                if (isValidStudent(id, n)) {
                    double avg = (marks[id][MATH] + marks[id][CHEMISTRY] + marks[id][PHYSICS]) / 3.0;
                    System.out.printf("Average marks for Student %d: %.2f\n", id, avg);
                } else {
                    System.out.println("Invalid student ID.");
                }

            } else if (command.equalsIgnoreCase("average_s")) {
                int subId = scanner.nextInt();
                if (isValidSubject(subId)) {
                    int total = 0;
                    for (int i = 1; i <= n; i++) {
                        total += marks[i][subId - 1];
                    }
                    double avg = total / (double) n;
                    String subName = getSubjectName(subId);
                    System.out.printf("Average for %s: %.2f\n", subName, avg);
                } else {
                    System.out.println("Invalid subject ID.");
                }

            } else if (command.equalsIgnoreCase("total")) {
                int id = scanner.nextInt();
                if (isValidStudent(id, n)) {
                    int total = marks[id][MATH] + marks[id][CHEMISTRY] + marks[id][PHYSICS];
                    System.out.println("Total marks for Student " + id + ": " + total);
                } else {
                    System.out.println("Invalid student ID.");
                }

            } else if (command.equalsIgnoreCase("grades")) {
                // Show grade table
                System.out.println("\nGrades Summary:");
                System.out.printf("%-10s %-15s %-15s %-15s\n", "StudentID", "Mathematics", "Chemistry", "Physics");
                for (int i = 1; i <= n; i++) {
                    String mathGrade = getGrade(marks[i][MATH]);
                    String chemGrade = getGrade(marks[i][CHEMISTRY]);
                    String physGrade = getGrade(marks[i][PHYSICS]);
                    System.out.printf("%-10d %-15s %-15s %-15s\n", i, mathGrade, chemGrade, physGrade);
                }

            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;

            } else {
                System.out.println("Invalid command. Try again.");
            }
        }

        scanner.close();
    }

    // Utility methods
    public static boolean isValidStudent(int id, int n) {
        return id >= 1 && id <= n;
    }

    public static boolean isValidSubject(int id) {
        return id >= 1 && id <= 3;
    }

    public static String getSubjectName(int id) {
        switch (id) {
            case 1: return "Mathematics";
            case 2: return "Chemistry";
            case 3: return "Physics";
            default: return "Unknown";
        }
    }

    public static String getGrade(int score) {
        if (score >= 90) return "Grade A";
        else if (score >= 80) return "Grade B";
        else if (score >= 70) return "Grade C";
        else if (score >= 60) return "Grade D";
        else return "Fail";
    }
}