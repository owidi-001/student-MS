import java.io.IOException;
import java.util.List;

public class Admin extends User{

    // Course_Name	Course_Id	Maximum_Students	Current_Students	List_Of_Names	Course_Instructor	Course_Section_Number	Course_Location
    // ADMIN
    public Course create_course() {
        System.out.print("Course name: ");
        String name=scanner.next();
        System.out.print("Course id: ");
        String id=scanner.next();
        System.out.print("Maximum number of students: ");
        String max_num_students=scanner.next();
        String current_capacity="0";
        //Arrays[] students=null;
        System.out.print("Course instructor: ");
        String instructor=scanner.next();
        System.out.print("Course section number: ");
        String section_num=scanner.next();
        System.out.print("Course location: ");
        String location=scanner.next();

        String[] attributes = {name,id,max_num_students, current_capacity,null,instructor,section_num,location};

        Course course = createCourse(attributes);
        return course;
    }

    public void delete_course() {
        List<Course> courses = readCoursesFromCSV("/MyUniversityCourses.csv");
        System.out.print("Course id: ");
        String id=scanner.next();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId()==id){
                courses.remove(i);
            }
        }
    }

    public void edit_course() throws IOException {
        List<Course> courses = readCoursesFromCSV("/MyUniversityCourses.csv");
        System.out.print("Course id: ");
        String id=scanner.next();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId()==id){
                Course course= courses.get(i);
                System.out.println("Edit choices:");

                System.out.print("Maximum number of students: ");
                String max_num_students=scanner.next();

                System.out.print("Current number of students: ");
                String current_capacity=scanner.next();

                //Arrays[] students=null;
                System.out.print("Course instructor: ");
                String instructor=scanner.next();

                System.out.print("Course section number: ");
                String section_num=scanner.next();

                System.out.print("Course location: ");
                String location=scanner.next();

                course.setMax_capacity(max_num_students);
                course.setCurrent_capacity(current_capacity);
                course.setInstructor(instructor);
                course.setSection(section_num);
                course.setLocation(location);

            }
        }
    }

    public String display_course() {
        List<Course> courses = readCoursesFromCSV("/MyUniversityCourses.csv");
        for (Course course:
                courses) {
            return course.toString();
        }
        return null;
    }

    static Student createStudent(String[] metadata) {
        String username = metadata[0];
        String password = metadata[1];
        String first_name = metadata[2];
        String last_name = metadata[3];

        // create and return book of this metadata
        return new Student(username, password, first_name, last_name) {
        };
    }

    public void register_student() {
        String username = scanner.next();
        String password = scanner.next();
        String first_name = scanner.next();
        String last_name = scanner.next();
        Student student=new Student(username, password, first_name, last_name);
        students.add(student);
    }

}
