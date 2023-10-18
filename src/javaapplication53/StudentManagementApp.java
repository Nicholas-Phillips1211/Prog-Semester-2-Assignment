
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class StudentManagementApp {
    ArrayList<Student> students = new ArrayList<>(); // array to hold student information
    private int studentCount = 0;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementApp app = new StudentManagementApp();
        app.run();
    }

    public void run() {
        while (true) {
            displayMenu(); // the menu showcasing the different options to choose from
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    captureStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    displayStudentReport();
                    break;
                case 5:
                    exitStudentApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() { //display for options to choose from
        System.out.println("Student Management System");
        System.out.println("1. Capture a new student");
        System.out.println("2. Search for a student");
        System.out.println("3. Delete a student");
        System.out.println("4. View student report");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    void captureStudent() { //function to collect the inputed information from the user
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

       int age;
while (true) {
    System.out.print("Enter student age (>= 16): ");
    String ageInput = scanner.nextLine();
    try {
        age = Integer.parseInt(ageInput);
        if (age >= 16) {
            break; // Valid age entered, exit the loop
        } else {
            System.out.println("Age must be greater than or equal to 16.");
        }
    } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
    }
}


        System.out.print("Enter student email: "); // student email entered here
        String email = scanner.nextLine();

        System.out.print("Enter student course: "); // student course entred here
        String course = scanner.nextLine();

        String id = generateStudentId();
        Student student = new Student(name, age, id, email, course);
        students.add(student);

        System.out.println("Student details have been successfully saved.");
        System.out.println("Student ID: " + id); // Display the unique ID to the user
    }

    private String generateStudentId() { // function that creates a ID for the student, the ID is "S" followed by the number in which the student was entered in the system
        return "S" + (++studentCount);
    }

    void searchStudent() { // student is identified by the student's ID
        System.out.print("Enter student ID: ");
        String searchId = scanner.nextLine();

        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(searchId)) {
                System.out.println("Student found:");
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Email: " + student.getEmail());
                System.out.println("Course: " + student.getCourse());
                return;
            }
        }

        System.out.println("Student not found."); // returns if the ID cannot be matched to a existing student in the system
    }

   void deleteStudent() {
    System.out.print("Enter student ID to delete: ");
    String deleteId = scanner.nextLine();

    Iterator<Student> iterator = students.iterator();
    while (iterator.hasNext()) {
        Student student = iterator.next();
        if (student.getId().equalsIgnoreCase(deleteId)) {
            System.out.print("Are you sure you want to delete this student? (yes or no): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes")) {
                iterator.remove(); // Use iterator to safely remove the student
                System.out.println("Student has been deleted.");
            } else {
                System.out.println("Deletion canceled.");
            }
            return;
        }
    }

    System.out.println("Student not found.");
}

  

    private void displayStudentReport() { // function that displays the student information
        System.out.println("Student Report:");
        for (Student student : students) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Course: " + student.getCourse());
            System.out.println();
        }
    }

    private void exitStudentApplication() { // exit the application function
        System.out.println("Exiting the application.");
        System.exit(0);
    }
}
