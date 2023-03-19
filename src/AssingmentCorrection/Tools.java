package AssingmentCorrection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Tools {
    static Scanner scanner = new Scanner(System.in);

    static Student[] students = new Student[100];

    static boolean flag = false;
    static int i = 0;

    //method to show operation list.
    public static void listOperations() {

        System.out.printf(
                "  1. Add new student %n" +
                        "  2. View All student list %n" +
                        "  3. view a student from the list %n" +
                        "  4. Delete a student from the list %n" +
                        "  5. Delete all student from the list %n" +
                        "  6. Exit the program %n");

        System.out.println(" ");
    }

    //1. method that create new student.
    public static void createNewStudent() {
        int addMore;

        do {
            System.out.println(" ");
            System.out.println("        ENTER STUDENT INFORMATION");
            int sId = i + 1;

            System.out.println(" STUDENT ID : " + sId);

            System.out.print(" FIRST NAME : ");
            String firstName = scanner.next();

            System.out.print(" SECOND NAME : ");
            String secondName = scanner.next();

            System.out.print(" DATE OF BIRTH in format(dd-MM-yyyy) : ");
            String sDateOfBirth = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate bDate = LocalDate.parse(sDateOfBirth, formatter);

            System.out.print(" ADDRESS : ");
            String sAddress = scanner.next();

            System.out.print(" GENDER: press 1. MALE, | press 2. FEMALE : ");
            int gender = scanner.nextInt();
            Gender sGender = Gender.MALE;

            if (gender == 2) {
                sGender = Gender.FEMALE;


            }
            System.out.print(" To continue press 1 or press any number to go back to option : ");
            addMore = scanner.nextInt();

            students[i] = new Student(firstName, secondName, bDate, sAddress, sId, sGender);
            i++;


        } while (addMore == 1);

    }

    //2. method to view all student in the list.
    public static void viewAllStudentList(Student[] students) {
        drawTable();
        for (Student student : students) {
            if (student != null) {
                flag = true;
                System.out.printf(" | %-25S| %-10S| %-15S| %-15S| %-15S|%n",
                                  student.getFirstName() + " " + student.getSecondName(),
                                  student.getId(),
                                  student.getDateOfBirth(),
                                  student.getAddress(),
                                  student.getGender());

            }
        }
        if (!flag) {
            isEmptyMessage();
        }
        System.out.println(" ");
    }

    //3. method to view a student by id.
    public static void viewAStudentById() {
        System.out.print(" Enter student id to view : ");
        int viewId = scanner.nextInt();
        drawTable();
        for (Student student : students) {

            if (student != null && viewId == student.getId()) {
                flag = true;
                System.out.printf(" | %-25S| %-10S| %-15S| %-15S| %-15S|%n",
                                  student.getFirstName() + " " + student.getSecondName(),
                                  student.getId(),
                                  student.getDateOfBirth(),
                                  student.getAddress(),
                                  student.getGender());
            }
        }
        if (!flag) {
            isEmptyMessage();
        }
    }

    //4. method to delete a student from the list by id.
    public static void deleteAStudentFromListById() {
        System.out.println(" Enter student id to remove : ");
        int index = scanner.nextInt();

        for (Student student : students) {
            if (student != null && student.getId() == index) {

                LinkedList<Student> theList = new LinkedList<>(Arrays.asList(students));
                theList.remove(student);
                students = theList.toArray(theList.toArray(new Student[theList.size()]));
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Student successfully deleted");
        } else {
            isEmptyMessage();
        }
    }

    //5. method to delete all student from the list.
    public static void deleteAllStudentLIst() {
        for (Student student : students) {
            if (student != null)
                flag = true;
            LinkedList<Student> theList = new LinkedList<Student>(Arrays.asList(students));
            theList.clear();
            students = theList.toArray(theList.toArray(new Student[0]));

        }
        if (flag) {
            System.out.println(" Student successfully deleted !");
        } else {
            isEmptyMessage();
        }
    }

    //method to draw a table of properties
    public static void drawTable() {
        System.out.printf("            ------------------------------------------------------------------%n" +
                                  "            ||||||| D-HUB SOFTWARE INSTITUTE STUDENT REGISTRATION FORM |||||||%n" +
                                  " -------------------------------------------------------------------------------------------%n" +
                                  " | %-25s| %-10s| %-15s| %-15s| %-15s|%n",
                          "  FULL NAME", "IDs", " DATE OF BIRTH", " ADDRESS", " GENDER");
        System.out.println(" -------------------------------------------------------------------------------------------");
    }


    public static void goodByeMessage() {
        int n = 5;
        //Outer Loop for number of Rows
        for (int i = 0; i < n; i++) {
            // Inner loop for printing '*' in each column.
            for (int j = 0; j < n; j++) {
                // For first row and last row we print '*' and for every other row we print the '*' at boundary region.
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("*  ");
                    System.out.print("*  ");
                    System.out.print("* ");
                    System.out.print("*  ");
                    System.out.print("*  ");
                }
                // Otherwise we print blank space.
                else

                    System.out.print(" bye for now  ");

            }
            System.out.println();
        }
    }

    public static void isEmptyMessage() {
        System.out.println(" Student(s) not on the list, please go to option to add student(s) thanks!!!");
        System.out.println(" ");
    }
}