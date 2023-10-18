/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicholasphillips
 */
public class StudentManagementAppTest {
   
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
@Test
public void testMain() {
    System.out.println("testMain");

    // Prepare input data for the main method
    String input = "5\n"; // Simulate user choosing option 5 (Exit)
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Capture the output of the main method
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

        // Call the main method of StudentManagementApp with an empty string array as arguments
        StudentManagementApp.main(new String[0]);
    

    // Restore the standard input and output streams
    System.setIn(System.in);
    System.setOut(System.out);

    String output = outContent.toString();

    // Add your assertions here based on the expected output
    assertTrue(output.contains("Exiting the application."));
}


    @Test
    public void testRun() {
        System.out.println("testRun");

        // Prepare input data for the run method (e.g., choose menu option 5 to exit)
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture the output of the run method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create an instance of StudentManagementApp and call the run method
        StudentManagementApp instance = new StudentManagementApp();
        instance.run();

        // Restore the standard input and output streams
        System.setIn(System.in);
        System.setOut(System.out);

        // Add your assertions here based on the expected output
        assertTrue(outContent.toString().contains("Exiting the application."));
    }

    @Test
    public void testCaptureStudent() {
        System.out.println("testCaptureStudent");

        // Prepare input data for the captureStudent method (e.g., provide name, age, email, and course)
        String input = "John Doe\n18\njohndoe@example.com\nMath\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture the output of the captureStudent method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create an instance of StudentManagementApp and call the captureStudent method
        StudentManagementApp instance = new StudentManagementApp();
        instance.captureStudent();

        // Restore the standard input and output streams
        System.setIn(System.in);
        System.setOut(System.out);

        // Add your assertions here based on the expected output or side effects
        // For example, you can assert that the student count has increased by 1.
        assertEquals(1, instance.students.size());
    }

    @Test
    public void testSearchStudent() {
        System.out.println("testSearchStudent");

        // Prepare input data for the searchStudent method (e.g., provide a student ID)
        String input = "S1\n"; // Assuming S1 is a valid student ID
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture the output of the searchStudent method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create an instance of StudentManagementApp and add a sample student
        StudentManagementApp instance = new StudentManagementApp();
        Student sampleStudent = new Student("John Doe", 18, "S1", "johndoe@example.com", "Math");
        instance.students.add(sampleStudent);

        // Call the searchStudent method
        instance.searchStudent();

        // Restore the standard input and output streams
        System.setIn(System.in);
        System.setOut(System.out);

        // Add your assertions here based on the expected output
        assertTrue(outContent.toString().contains("Student found:"));
    }

    @Test
    public void testDeleteStudent() {
        System.out.println("testDeleteStudent");

        // Prepare input data for the deleteStudent method (e.g., provide a student ID and confirm deletion)
        String input = "S1\nyes\n"; // Assuming S1 is a valid student ID
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture the output of the deleteStudent method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create an instance of StudentManagementApp and add a sample student
        StudentManagementApp instance = new StudentManagementApp();
        Student sampleStudent = new Student("John Doe", 18, "S1", "johndoe@example.com", "Math");
        instance.students.add(sampleStudent);

        // Call the deleteStudent method
        instance.deleteStudent();

        // Restore the standard input and output streams
        System.setIn(System.in);
        System.setOut(System.out);

        // Add your assertions here based on the expected output or side effects
        // For example, you can assert that the student count has decreased by 1.
        assertEquals(0, instance.students.size());
    }
}
   