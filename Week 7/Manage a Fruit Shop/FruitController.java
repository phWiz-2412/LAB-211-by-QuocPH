import java.util.*;

public class FruitController {
    private final List<Fruit> fruits = new ArrayList<>();
    private final Map<String, List<Fruit>> orders = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public void createFruit() {
        while (true) {
            System.out.print("Enter Fruit ID: ");
            int id = sc.nextInt(); sc.nextLine();
            System.out.print("Enter Fruit Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Origin: ");
            String origin = sc.nextLine();
            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt(); sc.nextLine();
            
            fruits.add(new Fruit(id, name, origin, price, quantity));
            System.out.print("Do you want to add another fruit? (Y/N): ");
            if (!sc.nextLine().equalsIgnoreCase("Y")) break;
        }
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }
        orders.forEach((customer, orderList) -> {
            System.out.println("Customer: " + customer);
            System.out.println("Product | Quantity | Price | Amount");
            double total = 0;
            for (Fruit fruit : orderList) {
                double amount = fruit.getPrice() * fruit.getQuantity();
                total += amount;
                System.out.printf("%s | %d | %.2f | %.2f\n", fruit.getName(), fruit.getQuantity(), fruit.getPrice(), amount);
            }
            System.out.println("Total: " + total);
        });
    }

    public void shopping() {
        if (fruits.isEmpty()) {
            System.out.println("No fruits available.");
            return;
        }
        List<Fruit> cart = new ArrayList<>();
        while (true) {
            System.out.println("ID | Name | Origin | Price");
            for (Fruit fruit : fruits) {
                System.out.printf("%d | %s | %s | %.2f\n", fruit.getId(), fruit.getName(), fruit.getOrigin(), fruit.getPrice());
            }
            System.out.print("Enter Fruit ID to buy: ");
            int id = sc.nextInt(); sc.nextLine();
            Fruit selectedFruit = fruits.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
            if (selectedFruit == null) {
                System.out.println("Invalid fruit ID.");
                continue;
            }
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt(); sc.nextLine();
            if (quantity > selectedFruit.getQuantity()) {
                System.out.println("Not enough stock.");
                continue;
            }
            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
            cart.add(new Fruit(selectedFruit.getId(), selectedFruit.getName(), selectedFruit.getOrigin(), selectedFruit.getPrice(), quantity));
            System.out.print("Do you want to buy another fruit? (Y/N): ");
            if (!sc.nextLine().equalsIgnoreCase("Y")) break;
        }
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        orders.put(name, cart);
    }
}
