import java.util.*;

class Person {
    protected String id;
    protected String fullName;
    protected String phoneNumber;
    protected int yearOfBirth;
    protected String major;

    public Person() {
        this.id = "";
        this.fullName = "";
        this.phoneNumber = "";
        this.yearOfBirth = 0;
        this.major = "";
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter ID (6 digits): ");
            id = sc.nextLine();
            if (id.matches("\\d{6}")) break;
            System.out.println("Invalid ID format.");
        }
        
        while (true) {
            System.out.print("Enter full name: ");
            fullName = sc.nextLine();
            if (fullName.matches("[a-zA-Z ]+")) break;
            System.out.println("Invalid name format.");
        }
        
        while (true) {
            System.out.print("Enter phone number (12 digits): ");
            phoneNumber = sc.nextLine();
            if (phoneNumber.matches("\\d{12}")) break;
            System.out.println("Invalid phone number format.");
        }
        
        while (true) {
            System.out.print("Enter year of birth: ");
            yearOfBirth = sc.nextInt();
            if (yearOfBirth < Calendar.getInstance().get(Calendar.YEAR)) break;
            System.out.println("Invalid year of birth.");
        }
        sc.nextLine();
        
        while (true) {
            System.out.print("Enter major: ");
            major = sc.nextLine();
            if (major.length() <= 30) break;
            System.out.println("Major name too long.");
        }
    }

    public void print() {
        System.out.println(id + " - " + fullName + " - " + phoneNumber + " - " + yearOfBirth + " - " + major);
    }
}

class Teacher extends Person {
    private int yearInProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher() {
        super();
        this.yearInProfession = 0;
        this.contractType = "";
        this.salaryCoefficient = 0.0;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter years in profession: ");
            yearInProfession = sc.nextInt();
            if (yearInProfession >= 0 && yearInProfession <= (Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth)) break;
            System.out.println("Invalid years in profession.");
        }
        sc.nextLine();
        
        while (true) {
            System.out.print("Enter contract type (Long/Short): ");
            contractType = sc.nextLine();
            if (contractType.equalsIgnoreCase("Long") || contractType.equalsIgnoreCase("Short")) break;
            System.out.println("Invalid contract type.");
        }
        
        while (true) {
            System.out.print("Enter salary coefficient: ");
            salaryCoefficient = sc.nextDouble();
            if (salaryCoefficient >= 0) break;
            System.out.println("Invalid salary coefficient.");
        }
    }

    @Override
    public void print() {
        super.print();
        System.out.println(yearInProfession + " - " + contractType + " - " + salaryCoefficient);
    }
}

class Student extends Person {
    private int yearOfAdmission;
    private int entranceScore;

    public Student() {
        super();
        this.yearOfAdmission = 0;
        this.entranceScore = 0;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter year of admission: ");
            yearOfAdmission = sc.nextInt();
            if (yearOfAdmission >= yearOfBirth && yearOfAdmission <= Calendar.getInstance().get(Calendar.YEAR)) break;
            System.out.println("Invalid year of admission.");
        }
        
        while (true) {
            System.out.print("Enter entrance score (0-100): ");
            entranceScore = sc.nextInt();
            if (entranceScore >= 0 && entranceScore <= 100) break;
            System.out.println("Invalid score.");
        }
    }

    @Override
    public void print() {
        super.print();
        System.out.println(yearOfAdmission + " - " + entranceScore);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Teacher> teachers = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("*** Information Management ***");
            System.out.println("1. Teacher\n2. Student\n3. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            if (choice == 3) break;

            switch (choice) {
                case 1:
                    Teacher t = new Teacher();
                    t.input();
                    teachers.add(t);
                    break;
                case 2:
                    Student s = new Student();
                    s.input();
                    students.add(s);
                    break;
            }
        }
        
        System.out.println("Teachers List:");
        for (Teacher t : teachers) t.print();
        
        System.out.println("Students List:");
        for (Student s : students) s.print();
    }
}
