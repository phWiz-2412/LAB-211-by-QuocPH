import java.util.*;

class Worker {
    private String id, name, workLocation;
    private int age;
    private double salary;

    public Worker(String id, String name, int age, double salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getWorkLocation() { return workLocation; }
    public void setSalary(double salary) { this.salary = salary; }
}

class SalaryHistory {
    private String workerId, name, status, date;
    private double salary;

    public SalaryHistory(String workerId, String name, double salary, String status, String date) {
        this.workerId = workerId;
        this.name = name;
        this.salary = salary;
        this.status = status;
        this.date = date;
    }

    public void display() {
        System.out.printf("%-10s%-10s%-10.2f%-10s%-15s%n", workerId, name, salary, status, date);
    }
}

class WorkerManagement {
    private List<Worker> workers = new ArrayList<>();
    private List<SalaryHistory> salaryHistories = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addWorker() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        if (getWorkerById(id) != null) {
            System.out.println("Worker ID already exists.");
            return;
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Work Location: ");
        String workLocation = sc.nextLine();

        if (age < 18 || age > 50 || salary <= 0) {
            System.out.println("Invalid input. Age must be 18-50, salary > 0.");
            return;
        }

        workers.add(new Worker(id, name, age, salary, workLocation));
        System.out.println("Worker added successfully.");
    }

    public void changeSalary(String type) {
        System.out.print("Enter Worker ID: ");
        String id = sc.nextLine();
        Worker worker = getWorkerById(id);
        if (worker == null) {
            System.out.println("Worker not found.");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // Consume newline

        if (amount <= 0) {
            System.out.println("Amount must be > 0.");
            return;
        }

        double newSalary = type.equals("UP") ? worker.getSalary() + amount : worker.getSalary() - amount;
        if (newSalary < 0) {
            System.out.println("Salary cannot be negative.");
            return;
        }

        worker.setSalary(newSalary);
        salaryHistories.add(new SalaryHistory(id, worker.getName(), newSalary, type, new Date().toString()));
        System.out.println("Salary updated successfully.");
    }

    public void displaySalaryHistory() {
        System.out.printf("%-10s%-10s%-10s%-10s%-15s%n", "ID", "Name", "Salary", "Status", "Date");
        for (SalaryHistory sh : salaryHistories) {
            sh.display();
        }
    }

    private Worker getWorkerById(String id) {
        for (Worker w : workers) {
            if (w.getId().equals(id)) return w;
        }
        return null;
    }
}

public class MainWorker {
    public static void main(String[] args) {
        WorkerManagement wm = new WorkerManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== Worker Management =====");
            System.out.println("1. Add worker");
            System.out.println("2. Increase salary");
            System.out.println("3. Decrease salary");
            System.out.println("4. Display Information salary");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            switch (choice) {
                case 1: wm.addWorker(); break;
                case 2: wm.changeSalary("UP"); break;
                case 3: wm.changeSalary("DOWN"); break;
                case 4: wm.displaySalaryHistory(); break;
                case 5: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice, try again.");
            }
        }
    }
}
