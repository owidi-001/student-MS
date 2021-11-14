import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Course {
    private String name, location, instructor, id,section,current_capacity,max_capacity;
    private List<Student> students;


    public Course(String name, String id, String max_capacity, String current_capacity, List<Student> students,
                  String instructor, String section, String location) {
        this.name = name;
        this.id = id;
        this.location = location;
        this.instructor = instructor;
        this.max_capacity = max_capacity;
        this.current_capacity = current_capacity;
        this.section = section;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getMax_capacity() {
        return max_capacity;
    }
    public void setMax_capacity(String max_capacity) {
        this.max_capacity = max_capacity;
    }


    public String getCurrent_capacity() {
        return current_capacity;
    }
    public void setCurrent_capacity(String current_capacity) {
        this.current_capacity = current_capacity;
    }


    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getId().equals(course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", instructor='" + instructor + '\'' +
                ", id='" + id + '\'' +
                ", section='" + section + '\'' +
                ", current_capacity='" + current_capacity + '\'' +
                ", max_capacity='" + max_capacity + '\'' +
                ", students=" + students +
                '}';
    }
}