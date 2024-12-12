import java.util.*;

class Student {
    private String name;
    private int age;
    private String grade;
    private int id;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void displayStudentInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("-------------------------");
    }
}

public class Sample {
    private static List<Student> students = new ArrayList<>();
    private static int nextId = 1;

    // Method to add a student
    public static void addStudent(String name, int age, String grade) {
        Student student = new Student(nextId++, name, age, grade);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Method to update a student's information
    public static void updateStudent(int id, String name, int age, String grade) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to delete a student
    public static void deleteStudent(int id) {
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to find a student by ID
    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Method to list all students
    public static void listAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                student.displayStudentInfo();
            }
        }
    }

    // Method to search for students by name
    public static void searchStudentByName(String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                student.displayStudentInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with that name.");
        }
    }

    // Method to sort students by name
    public static void sortStudentsByName() {
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Students sorted by name.");
    }

    // Main method for the console application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Welcome to the Advanced Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. List All Students");
            System.out.println("5. Search Student by Name");
            System.out.println("6. Sort Students by Name");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Add student
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student's age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter student's grade: ");
                    String grade = scanner.nextLine();
                    addStudent(name, age, grade);
                    break;

                case 2:
                    // Update student
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter new student's name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new student's age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter new student's grade: ");
                    String newGrade = scanner.nextLine();
                    updateStudent(updateId, newName, newAge, newGrade);
                    break;

                case 3:
                    // Delete student
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    deleteStudent(deleteId);
                    break;

                case 4:
                    // List all students
                    listAllStudents();
                    break;

                case 5:
                    // Search student by name
                    System.out.print("Enter student's name to search: ");
                    String searchName = scanner.nextLine();
                    searchStudentByName(searchName);
                    break;

                case 6:
                    // Sort students by name
                    sortStudentsByName();
                    break;

                case 7:
                    // Exit program
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
