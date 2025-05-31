import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;
        do {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll No: ");
                    String rollNo = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    Student s = new Student(name, rollNo, course, year);
                    manager.addStudent(s);
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter Roll No to search: ");
                    String searchRoll = sc.nextLine();
                    Student found = manager.searchStudent(searchRoll);
                    if (found != null) {
                        found.display();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Roll No to update: ");
                    String updateRoll = sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();
                    System.out.print("Enter New Year: ");
                    int newYear = sc.nextInt();
                    sc.nextLine();
                    manager.updateStudent(updateRoll, newName, newCourse, newYear);
                    break;
                case 5:
                    System.out.print("Enter Roll No to delete: ");
                    String deleteRoll = sc.nextLine();
                    manager.deleteStudent(deleteRoll);
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }
}
