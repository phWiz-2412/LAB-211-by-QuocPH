import java.util.Random;
import java.util.Scanner;

public class LinearSearchProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter number of array: ");
        int arraySize = scanner.nextInt();

        if (arraySize <= 0) {
            System.out.println("Number of array must be a positive number!");
            return;
        }

        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(10);
        }

        System.out.print("The array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Enter search value: ");
        int searchValue = scanner.nextInt();

        int foundIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Found " + searchValue + " at index: " + foundIndex);
        } else {
            System.out.println(searchValue + " not found in the array.");
        }
    }
}
