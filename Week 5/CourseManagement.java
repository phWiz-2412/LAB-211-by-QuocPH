import java.text.SimpleDateFormat;
import java.util.*;

class Course {
    protected String courseID, courseName;
    protected int credits;
    
    public Course() {
        this.courseID = "";
        this.courseName = "";
        this.credits = 0;
    }
    
    public void input(Scanner sc, List<Course> courses) {
        while (true) {
            System.out.print("Course ID: ");
            courseID = sc.nextLine().trim();
            if (courseID.isEmpty() || courses.stream().anyMatch(c -> c.courseID.equals(courseID))) {
                System.out.println("Data input is invalid, ID must be unique");
            } else {
                break;
            }
        }
        
        do {
            System.out.print("Course name: ");
            courseName = sc.nextLine().trim();
        } while (courseName.isEmpty());
        
        while (true) {
            try {
                System.out.print("Credits: ");
                credits = Integer.parseInt(sc.nextLine().trim());
                if (credits > 0) break;
                System.out.println("Data input is invalid");
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid");
            }
        }
    }
    
    public void display() {
        System.out.println(courseID + "-" + courseName + "-" + credits);
    }
}

class OnlineCourse extends Course {
    private String platform, instructors, note;
    
    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }
    
    @Override
    public void input(Scanner sc, List<Course> courses) {
        super.input(sc, courses);
        do {
            System.out.print("Platform: ");
            platform = sc.nextLine().trim();
        } while (platform.isEmpty());
        
        do {
            System.out.print("Instructors: ");
            instructors = sc.nextLine().trim();
        } while (instructors.isEmpty());
        
        do {
            System.out.print("Note: ");
            note = sc.nextLine().trim();
        } while (note.isEmpty());
    }
    
    @Override
    public void display() {
        System.out.println(courseID + "-" + courseName + "-" + credits + "-" + platform + "-" + instructors + "-" + note);
    }
}

class OfflineCourse extends Course {
    private String campus;
    private Date begin, end;
    
    public OfflineCourse() {
        super();
        this.campus = "";
    }
    
    @Override
    public void input(Scanner sc, List<Course> courses) {
        super.input(sc, courses);
        do {
            System.out.print("Campus: ");
            campus = sc.nextLine().trim();
        } while (campus.isEmpty());
        
        while (true) {
            try {
                System.out.print("Begin (dd/MM/yyyy): ");
                begin = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine().trim());
                System.out.print("End (dd/MM/yyyy): ");
                end = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine().trim());
                if (begin.before(end)) break;
                System.out.println("Data input is invalid, end must be after begin");
            } catch (Exception e) {
                System.out.println("Invalid date format");
            }
        }
    }
    
    @Override
    public void display() {
        System.out.println(courseID + "-" + courseName + "-" + credits + "-" + campus + "-" + begin + "-" + end);
    }
}

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    private static void addCourse() {
        System.out.print("Online (O) or Offline (F): ");
        String type = sc.nextLine().trim().toUpperCase();
        Course course = type.equals("O") ? new OnlineCourse() : new OfflineCourse();
        course.input(sc, courses);
        courses.add(course);
        System.out.println("Course added successfully!");
    }
    
    private static void printCourses() {
        System.out.print("Do you want to print all (A), online course (O) or offline course (F): ");
        String type = sc.nextLine().trim().toUpperCase();
        for (Course c : courses) {
            if (type.equals("A") || (type.equals("O") && c instanceof OnlineCourse) || (type.equals("F") && c instanceof OfflineCourse)) {
                c.display();
            }
        }
    }
    
    private static void searchCourse() {
        System.out.print("Course ID: ");
        String id = sc.nextLine().trim();
        for (Course c : courses) {
            if (c.courseID.equals(id)) {
                c.display();
                return;
            }
        }
        System.out.println("No data found.");
    }
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("*** Course Management ***");
            System.out.println("1. Add online course/ offline course");
            System.out.println("2. Print all course");
            System.out.println("3. Search information base on course ID");
            System.out.println("4. Exit");
            System.out.print("You choose: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": addCourse(); break;
                case "2": printCourses(); break;
                case "3": searchCourse(); break;
                case "4": System.out.println("BYE AND SEE YOU NEXT TIME"); return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
