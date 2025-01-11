package BaseConverter;

import java.util.Scanner;

public class BaseConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose input base system (1: Binary, 2: Decimal, 3: Hexadecimal): ");
            int inputBase = scanner.nextInt();

            System.out.println("Choose output base system (1: Binary, 2: Decimal, 3: Hexadecimal): ");
            int outputBase = scanner.nextInt();

            System.out.print("Enter input value: ");
            String inputValue = scanner.next();

            int decimalValue = 0;
            switch (inputBase) {
                case 1:
                    decimalValue = Integer.parseInt(inputValue, 2);
                    break;
                case 2:
                    decimalValue = Integer.parseInt(inputValue);
                    break;
                case 3:
                    decimalValue = Integer.parseInt(inputValue, 16);
                    break;
                default:
                    System.out.println("Invalid input base. Please try again.");
                    continue;
            }

            String outputValue = "";
            switch (outputBase) {
                case 1:
                    outputValue = Integer.toBinaryString(decimalValue);
                    break;
                case 2:
                    outputValue = Integer.toString(decimalValue);
                    break;
                case 3:
                    outputValue = Integer.toHexString(decimalValue).toUpperCase();
                    break;
                default:
                    System.out.println("Invalid output base. Please try again.");
                    continue;
            }

            System.out.println("Output value: " + outputValue);

            System.out.print("Do you want to continue? (Y/N): ");
            char choice = scanner.next().charAt(0);
            if (choice == 'N' || choice == 'n') {
                break;
            }
        }

        scanner.close();
    }
}
