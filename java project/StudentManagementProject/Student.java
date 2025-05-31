public class Student {
    private String name;
    private String rollNo;
    private String course;
    private int year;

    public Student(String name, String rollNo, String course, int year) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
        this.year = year;
    }

    public String getName() { return name; }
    public String getRollNo() { return rollNo; }
    public String getCourse() { return course; }
    public int getYear() { return year; }

    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
    public void setYear(int year) { this.year = year; }

    public void display() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Course: " + course + ", Year: " + year);
    }
}
