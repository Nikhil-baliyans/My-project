import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\nStudent List:");
        for (Student s : students) {
            s.display();
        }
    }

    public Student searchStudent(String rollNo) {
        for (Student s : students) {
            if (s.getRollNo().equalsIgnoreCase(rollNo)) {
                return s;
            }
        }
        return null;
    }

    public void updateStudent(String rollNo, String newName, String newCourse, int newYear) {
        Student s = searchStudent(rollNo);
        if (s != null) {
            s.setName(newName);
            s.setCourse(newCourse);
            s.setYear(newYear);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(String rollNo) {
        Student s = searchStudent(rollNo);
        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}
