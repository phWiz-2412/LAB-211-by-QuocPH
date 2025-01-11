package EquationProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquationProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("========== Equation Program ==========");
            System.out.println("1. Calculate Superlative Equation");
            System.out.println("2. Calculate Quadratic Equation");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calculateEquation(scanner);
                    break;
                case 2:
                    calculateQuadraticEquation(scanner);
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void calculateEquation(Scanner scanner) {
        System.out.println("----- Calculate Equation -----");
        float a = getValidFloat(scanner, "Enter A: ");
        float b = getValidFloat(scanner, "Enter B: ");

        if (a == 0) {
            System.out.println("No solution or infinitely many solutions.");
            return;
        }

        float solution = -b / a;
        System.out.printf("Solution: x = %.3f\n", solution);
        
        displayNumberProperties(List.of(a, b, solution));
    }

    public static void calculateQuadraticEquation(Scanner scanner) {
        System.out.println("----- Calculate Quadratic Equation -----");
        float a = getValidFloat(scanner, "Enter A: ");
        float b = getValidFloat(scanner, "Enter B: ");
        float c = getValidFloat(scanner, "Enter C: ");

        if (a == 0) {
            System.out.println("This is not a quadratic equation.");
            return;
        }

        float delta = b * b - 4 * a * c;
        if (delta < 0) {
            System.out.println("No real solutions.");
        } else if (delta == 0) {
            float x = -b / (2 * a);
            System.out.printf("Solution: x1 = x2 = %.3f\n", x);
            displayNumberProperties(List.of(a, b, c, x));
        } else {
            float x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
            float x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
            System.out.printf("Solution: x1 = %.3f and x2 = %.3f\n", x1, x2);
            displayNumberProperties(List.of(a, b, c, x1, x2));
        }
    }

    public static void displayNumberProperties(List<Float> numbers) {
        List<Float> oddNumbers = new ArrayList<>();
        List<Float> evenNumbers = new ArrayList<>();
        List<Float> perfectSquares = new ArrayList<>();

        for (float number : numbers) {
            if (isOdd(number)) {
                oddNumbers.add(number);
            } else {
                evenNumbers.add(number);
            }

            if (isPerfectSquare(number)) {
                perfectSquares.add(number);
            }
        }

        System.out.println("Odd Numbers: " + oddNumbers);
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Perfect Square Numbers: " + perfectSquares);
    }

    public static boolean isOdd(float number) {
        return number % 2 != 0;
    }

    public static boolean isPerfectSquare(float number) {
        if (number < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    public static float getValidFloat(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextFloat()) {
                return scanner.nextFloat();
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }
}
