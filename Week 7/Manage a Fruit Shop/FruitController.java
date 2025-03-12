class FruitController {
    private final List<Fruit> fruits = new ArrayList<>();
    private final Hashtable<String, List<Fruit>> orders = new Hashtable<>();
    private final Scanner sc = new Scanner(System.in);

    public void createFruit() {
        System.out.print("Enter Fruit ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Fruit Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Origin: ");
        String origin = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        fruits.add(new Fruit(id, name, origin, price, quantity));
        System.out.print("Do you want to add another fruit? (Y/N): ");
        if (sc.nextLine().equalsIgnoreCase("Y")) createFruit();
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }
        for (Map.Entry<String, List<Fruit>> entry : orders.entrySet()) {
            System.out.println("Customer: " + entry.getKey());
            System.out.println("Product | Quantity | Price | Amount");
            double total = 0;
            for (Fruit fruit : entry.getValue()) {
                double amount = fruit.price * fruit.quantity;
                total += amount;
                System.out.printf("%s | %d | %.2f | %.2f\n", fruit.name, fruit.quantity, fruit.price, amount);
            }
            System.out.println("Total: " + total);
        }
    }

    public void shopping() {
        if (fruits.isEmpty()) {
            System.out.println("No fruits available.");
            return;
        }
        System.out.println("List of Fruits:");
        System.out.println("ID | Name | Origin | Price");
        for (Fruit fruit : fruits) {
            System.out.printf("%d | %s | %s | %.2f\n", fruit.id, fruit.name, fruit.origin, fruit.price);
        }
        List<Fruit> cart = new ArrayList<>();
        while (true) {
            System.out.print("Enter Fruit ID to buy: ");
            int id = sc.nextInt();
            sc.nextLine();
            Fruit selectedFruit = fruits.stream().filter(f -> f.id == id).findFirst().orElse(null);
            if (selectedFruit == null) {
                System.out.println("Invalid fruit ID.");
                continue;
            }
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            if (quantity > selectedFruit.quantity) {
                System.out.println("Not enough stock.");
                continue;
            }
            selectedFruit.quantity -= quantity;
            cart.add(new Fruit(selectedFruit.id, selectedFruit.name, selectedFruit.origin, selectedFruit.price, quantity));
            System.out.print("Do you want to buy another fruit? (Y/N): ");
            if (!sc.nextLine().equalsIgnoreCase("Y")) break;
        }
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        orders.put(name, cart);
    }
}
