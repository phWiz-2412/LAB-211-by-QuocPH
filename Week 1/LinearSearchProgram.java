import java.util.Random;
import java.util.Scanner;

public class LinearSearchProgram {
    public static void main(String[] args) {
        LinearSearchProgram program = new LinearSearchProgram();
        program.run();
    }

    public void run() {
        InputHandler inputHandler = new InputHandler();
        ArrayHandler arrayHandler = new ArrayHandler();

        int arraySize = inputHandler.getPositiveNumber("Enter number of array: ");

        int[] array = arrayHandler.generateRandomArray(arraySize);
        arrayHandler.displayArray(array);

        int searchValue = inputHandler.getPositiveNumber("Enter search value: ");

        int foundIndex = arrayHandler.linearSearch(array, searchValue);
        if (foundIndex != -1) {
            System.out.println("Found " + searchValue + " at index: " + foundIndex);
        } else {
            System.out.println(searchValue + " not found in the array.");
        }
    }
}

class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int getPositiveNumber(String message) {
        int number;
        do {
            System.out.print(message);
            number = scanner.nextInt();
            if (number <= 0) {
                System.out.println("Please enter a positive number!");
            }
        } while (number <= 0);
        return number;
    }
}

class ArrayHandler {
    private final Random random = new Random();

    public int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    public void displayArray(int[] array) {
        System.out.print("The array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
