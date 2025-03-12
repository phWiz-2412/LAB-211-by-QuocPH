import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Enter information of 11 countries in East Asia");
            System.out.println("2. Display information of the last entered country");
            System.out.println("3. Search country by name");
            System.out.println("4. Display countries sorted by name");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> manager.addCountryInformation();
                case 2 -> manager.getRecentlyEnteredInformation();
                case 3 -> manager.searchInformationByName();
                case 4 -> manager.sortInformationByAscendingOrder();
                case 5 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please select again.");
            }
        }
    }
}
