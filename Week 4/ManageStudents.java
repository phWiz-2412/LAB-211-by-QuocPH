
import java.util.*;

class Student {
    private String id;
    private String name;
    private int semester;
    private String courseName;

    public Student(String id, String name, int semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getSemester() { return semester; }
    public String getCourseName() { return courseName; }
    
    public void setName(String name) { this.name = name; }
    public void setSemester(int semester) { this.semester = semester; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    
    @Override
    public String toString() {
        return name + " | " + courseName + " | " + semester;
    }
}

public class StudentManagement {
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1: createStudent(); break;
                case 2: findAndSortStudents(); break;
                case 3: updateOrDeleteStudent(); break;
                case 4: generateReport(); break;
                case 5: return;
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }
    
    private static void createStudent() {
        while (true) {
            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter semester: ");
            int semester = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter course name (Java/.Net/C++): ");
            String courseName = scanner.nextLine();
            students.add(new Student(id, name, semester, courseName));
            
            if (students.size() >= 3) {
                System.out.print("Continue adding students? (Y/N): ");
                if (scanner.nextLine().equalsIgnoreCase("N")) break;
            }
        }
    }
    
    private static void findAndSortStudents() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        List<Student> filtered = new ArrayList<>();
        
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(name.toLowerCase())) {
                filtered.add(s);
            }
        }
        
        filtered.sort(Comparator.comparing(Student::getName));
        for (Student s : filtered) {
            System.out.println(s);
        }
    }
    
    private static void updateOrDeleteStudent() {
        System.out.print("Enter student ID to find: ");
        String id = scanner.nextLine();
        Student found = null;
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                found = s;
                break;
            }
        }
        if (found == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.print("Update (U) or Delete (D)? ");
        String choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("U")) {
            System.out.print("Enter new name: ");
            found.setName(scanner.nextLine());
            System.out.print("Enter new semester: ");
            found.setSemester(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Enter new course name: ");
            found.setCourseName(scanner.nextLine());
        } else if (choice.equalsIgnoreCase("D")) {
            students.remove(found);
            System.out.println("Student removed successfully.");
        }
    }
    
    private static void generateReport() {
        Map<String, Integer> report = new HashMap<>();
        for (Student s : students) {
            String key = s.getName() + " | " + s.getCourseName();
            report.put(key, report.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }
}
