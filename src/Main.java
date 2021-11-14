import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    static Scanner scanner=new Scanner(System.in);

    public static int menu(){
        System.out.println("1:Admin");
        System.out.println("2:Student");
        System.out.println("3:quit");

        System.out.print("Choose >> ");

        return scanner.nextInt();
    }

    static List<Course> readCoursesFromCSV(String fileName) {
        List<Course> courses = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                Course course = createCourse(attributes);

                // adding book into ArrayList
                courses.add(course);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return courses;
    }

    static Course createCourse(String[] metadata) {
        String name = metadata[0];
        String id = metadata[1];
        String max_capacity = metadata[2];
        String current_capacity = "0";
        String location = metadata[2];
        String instructor = metadata[3];
        String section = metadata[5];
        List<Student> students = null;

        // create and return book of this metadata
        return new Course(name, id, max_capacity, current_capacity, students, instructor, section, location);
    }

    public static void main(String[] args) throws Exception {
        List<Course> courses = readCoursesFromCSV("/home/whoami/orders/ken/studentms/src/MyUniversityCourses.csv");
        List<Student> students=new ArrayList<>();

        // let's print all the person read from CSV file
        for (Course course : courses) {
            System.out.println(course.getName());
        }

        // Menu
        boolean flag=true;
        while (flag){
            int choice=menu();
            switch(choice){
                case 1:
                    System.out.print("Username: ");
                    String admin_user= scanner.next();
                    System.out.print("Password: ");
                    String admin_pass= scanner.next();
                    System.out.println("Welcome: ");
                    if (admin_user=="Admin" && admin_pass=="Admin001"){
                        Admin admin=new Admin();
                        // Admin functions
                        String ADMIN_MENU="  1.Create a new course"
                                + " 2.Delete a course"
                                + "3.Edit a course"
                                + "4.Display information for a given course (by course ID)"
                                + "5.Register a student"
                                + "6.Exit";
                        boolean admin_flag=true;
                        while (admin_flag) {
                            System.out.println(ADMIN_MENU);
                            System.out.print("Choose >> ");

                            int admin_action = scanner.nextInt();

                            switch (admin_action) {
                                case 1:
                                    System.out.println("  1.Create a new course");
                                    admin.create_course();
                                case 2:
                                    System.out.println(" 2.Delete a course");
                                    admin.delete_course();
                                case 3:
                                    System.out.println("3.Edit a course");
                                    admin.edit_course();
                                case 4:
                                    System.out.println("4.Display information for a given course (by course ID)");
                                    admin.display_course();
                                case 5:
                                    System.out.println("5.Register a student");
                                    admin.register_student();
                                case 6:
                                    admin_flag = false;
                            }
                        }
                    }
                    else {
                        System.out.println("Wrong secrets");
                    }
                    System.out.println("Admin exit");
                case 2:
                    String student_user= scanner.next();
                    String student_pass= scanner.next();
                    Student student = null;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getUsername()==student_user && students.get(i).getPassword()==student_pass){
                            student=students.get(i);
                            break;
                        }
                    }

                    String STUDENT_MENU="  1.Create a new course"
                            + " 2.Delete a course"
                            + "3.Edit a course"
                            + "4.Display information for a given course (by course ID)"
                            + "5.Register a student"
                            + "6.Exit";
                    boolean stu_flag=true;
                    while (stu_flag){
                        System.out.println(STUDENT_MENU);
                        System.out.print("Choose >> ");
                        int student_action = scanner.nextInt();


                        switch (student_action){
                            case 1:
                                student.view_all_courses();
                            case 2:
                                student.view_vacant_courses();
                            case 3:
                                student.register_course();
                            case 4:
                                student.withdraw_course();
                            case 5:
                                student.view_student_courses(student);
                            case 6:
                                stu_flag=false;
                        }
                    }

                case 3:
                    flag=false;
            }

        }

    }
}
