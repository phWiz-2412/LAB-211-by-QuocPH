import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class Contact {
    int id;
    String firstName, lastName, group, address, phone;

    public Contact(int id, String firstName, String lastName, String group, String address, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-10s %-10s %-10s %-15s", 
                              id, firstName + " " + lastName, firstName, lastName, group, address, phone);
    }
}

public class ContactManager {
    private static List<Contact> contacts = new ArrayList<>();
    private static int idCounter = 1;
    private static Scanner scanner = new Scanner(System.in);
    private static final String PHONE_PATTERN = "^(\\d{10}|\\d{3}[-.\\s]\\d{3}[-.\\s]\\d{4}( x\\d{1,4})?)$";

    public static void main(String[] args) {
        while (true) {
            System.out.println("======= Contact program =======");
            System.out.println("1. Add a Contact");
            System.out.println("2. Display all Contacts");
            System.out.println("3. Delete a Contact");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Enter Group: ");
        String group = scanner.nextLine().trim();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine().trim();

        String phone;
        while (true) {
            System.out.print("Enter Phone: ");
            phone = scanner.nextLine().trim();
            if (Pattern.matches(PHONE_PATTERN, phone)) {
                break;
            } else {
                System.out.println("Invalid phone format! Try again.");
            }
        }

        contacts.add(new Contact(idCounter++, firstName, lastName, group, address, phone));
        System.out.println("Contact added successfully!\n");
    }

    private static void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available!\n");
            return;
        }
        System.out.println("ID    Name            First Name  Last Name   Group      Address      Phone");
        System.out.println("----------------------------------------------------------------------------");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
        System.out.println();
    }

    private static void deleteContact() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        for (Contact contact : contacts) {
            if (contact.id == id) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully!\n");
                return;
            }
        }
        System.out.println("No found contact with ID: " + id + "\n");
    }
}
