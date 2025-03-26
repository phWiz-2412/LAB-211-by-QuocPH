import java.util.*;

public class CandidateManagement {
    private static List<Candidate> candidates = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: createExperienceCandidate(); break;
                case 2: createFresherCandidate(); break;
                case 3: createInternCandidate(); break;
                case 4: searchCandidate(); break;
                case 5: return;
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }
    
    private static void createExperienceCandidate() {
        System.out.print("Enter Candidate ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Birth Date: ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Years of Experience: ");
        int expYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Professional Skill: ");
        String skill = scanner.nextLine();
        candidates.add(new Experience(id, firstName, lastName, birthDate, address, phone, email, expYear, skill));
        System.out.println("Experience Candidate Added Successfully!");
    }
    
    private static void createFresherCandidate() {
        System.out.print("Enter Candidate ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Birth Date: ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Graduation Date: ");
        String gradDate = scanner.nextLine();
        System.out.print("Enter Graduation Rank: ");
        String gradRank = scanner.nextLine();
        System.out.print("Enter University Name: ");
        String university = scanner.nextLine();
        candidates.add(new Fresher(id, firstName, lastName, birthDate, address, phone, email, gradDate, gradRank, university));
        System.out.println("Fresher Candidate Added Successfully!");
    }
    
    private static void searchCandidate() {
        System.out.print("Enter Candidate Name: ");
        String name = scanner.nextLine().toLowerCase();
        System.out.print("Enter Candidate Type (0-2): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        
        for (Candidate c : candidates) {
            if (c.getFullName().toLowerCase().contains(name) && c.getCandidateType() == type) {
                System.out.println(c);
            }
        }
    }
}
