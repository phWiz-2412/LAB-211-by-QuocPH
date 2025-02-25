import java.util.*;

class FlightInformation {
    String flightNumber;
    String seatNumber;
    String timePickUp;

    public FlightInformation(String flightNumber, String seatNumber, String timePickUp) {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
    }
}

class Reservation {
    String bookingID;
    String customerName;
    String phoneNumber;
    String roomNumber;
    String bookingDate;
    FlightInformation flightInfo;

    public Reservation(String bookingID, String customerName, String phoneNumber, String roomNumber, String bookingDate, FlightInformation flightInfo) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.bookingDate = bookingDate;
        this.flightInfo = flightInfo;
    }
}

public class ReservationSystem {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Reservation> reservations = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("*** Reservation Management ***");
            System.out.println("1. Create new reservation");
            System.out.println("2. Update reservation");
            System.out.println("3. Delete reservation");
            System.out.println("4. Print Flight Information");
            System.out.println("5. Print all");
            System.out.println("6. Exit");
            System.out.print("You choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: createReservation(); break;
                case 2: updateReservation(); break;
                case 3: deleteReservation(); break;
                case 4: printFlightInformation(); break;
                case 5: printAllReservations(); break;
                case 6: System.out.println("BYE AND SEE YOU NEXT TIME"); return;
                default: System.out.println("Invalid choice, try again!");
            }
        }
    }

    static void createReservation() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        if (reservations.containsKey(id)) {
            System.out.println("ID already exists!");
            return;
        }
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Room Number: ");
        String room = scanner.nextLine();
        System.out.print("Booking Date: ");
        String date = scanner.nextLine();
        
        System.out.print("Flight Number: ");
        String flight = scanner.nextLine();
        System.out.print("Seat: ");
        String seat = scanner.nextLine();
        System.out.print("Time PickUp: ");
        String time = scanner.nextLine();
        
        FlightInformation flightInfo = new FlightInformation(flight, seat, time);
        reservations.put(id, new Reservation(id, name, phone, room, date, flightInfo));
        System.out.println("Reservation created successfully!");
    }

    static void updateReservation() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        if (!reservations.containsKey(id)) {
            System.out.println("No information found!");
            return;
        }
        
        System.out.print("New Phone (press enter to skip): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) reservations.get(id).phoneNumber = phone;
        
        System.out.println("Reservation updated successfully!");
    }

    static void deleteReservation() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        if (!reservations.containsKey(id)) {
            System.out.println("No information found!");
            return;
        }
        reservations.remove(id);
        System.out.println("Reservation deleted successfully!");
    }

    static void printFlightInformation() {
        for (Reservation r : reservations.values()) {
            System.out.println(r.bookingID + " - " + r.flightInfo.flightNumber + " - " + r.flightInfo.seatNumber + " - " + r.flightInfo.timePickUp);
        }
    }

    static void printAllReservations() {
        for (Reservation r : reservations.values()) {
            System.out.println(r.bookingID + " - " + r.customerName + " - " + r.phoneNumber + " - " + r.roomNumber + " - " + r.bookingDate);
        }
    }
}
