package AssingmentCorrection;

import java.util.Scanner;

import static AssingmentCorrection.Tools.*;

public class StudentArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operation;

        do {
            System.out.println("STUDENT REGISTRATION FORM PROGRAM WITH THE FOLLOWING OPTION");
            Tools.listOperations();
            System.out.print("Enter your prefer option : ");
            operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    //Create new student
                    Tools.createNewStudent();
                    System.out.println(" Student added successfully ");
                    System.out.println(" ");
                    break;

                case 2:
                    //view all student

                        Tools.viewAllStudentList(students);
                        System.out.println(" ");
                    break;

                case 3:
                    //view a student BY ID
                        Tools.viewAStudentById();
                        System.out.println(" ");
                    break;

                case 4:
                    //delete a student BY ID
                    Tools.deleteAStudentFromListById();
                    break;

                case 5:
                    // delete all student
                    Tools.deleteAllStudentLIst();
                    break;

                case 6:
                    //quit the program
                    Tools.goodByeMessage();
                    System.out.println(" ");
                    System.exit(1);
                    break;
            }

        } while (true);
    }
}