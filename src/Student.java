import java.util.List;

public class Student extends User{
    String username;
    String password;
    String first_name;
    String last_name;

    List<Course> courses = readCoursesFromCSV("/home/whoami/orders/ken/studentms/src/MyUniversityCourses.csv");

    public Student(String username, String password, String first_name, String last_name) {
        super();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    // STUDENT
    public String view_all_courses() {
        for (Course course:
                courses) {
            return course.toString();
        }
        return null;
    }

    public void view_vacant_courses() {
        for (Course course:
                courses) {
            if (Integer.valueOf(course.getCurrent_capacity()) < Integer.valueOf(course.getMax_capacity())){
                System.out.println(course.getName());
            }
        }
    }

    public void register_course() {
        String id=scanner.next();
        for (Course course:
                courses) {
            if (course.getId()==id){
                Student student=new Student(username,password,first_name,last_name);
                course.getStudents().add(student);
            }
        }
    }

    public void withdraw_course() {
        String id=scanner.next();
        for (Course course:
                courses) {
            if (course.getId()==id){
                course.setStudents(null);
            }
        }
    }

public void view_student_courses(Student student) {
    for (Course course:
            courses) {
        if (course.getStudents().equals(student)){
            System.out.println(course.getName());
        }
    }
}


}
