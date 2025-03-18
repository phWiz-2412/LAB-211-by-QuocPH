import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FruitController controller = new FruitController();
        while (true) {
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1 -> controller.createFruit();
                case 2 -> controller.viewOrders();
                case 3 -> controller.shopping();
                case 4 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
