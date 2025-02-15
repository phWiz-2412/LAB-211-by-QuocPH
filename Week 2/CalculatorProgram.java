package CalculatorProgram;

import java.util.Scanner;

enum Operator {
    PLUS, MINUS, MULTIPLY, DIVIDE, POWER
}

enum BMIStatus {
    UNDER_STANDARD, STANDARD, OVERWEIGHT, FAT, VERY_FAT
}

public class CalculatorProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double memory = 0.0;

        while (true) {
            System.out.println("======= Calculator Program =======");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");
            int choice = getValidInteger(sc);

            switch (choice) {
                case 1 -> memory = normalCalculator(sc, memory);
                case 2 -> bmiCalculator(sc);
                case 3 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static double normalCalculator(Scanner sc, double memory) {
        while (true) {
            System.out.print("Enter number: ");
            double a = getValidDouble(sc);
            System.out.print("Enter operator (+, -, *, /, ^, =): ");
            String operator;

            while (true) {
                operator = sc.next();
                if (isValidOperator(operator) || operator.equals("=")) break;
                System.out.print("Invalid operator! Please enter again (+, -, *, /, ^, =): ");
            }

            if (operator.equals("=")) {
                System.out.println("Result: " + memory);
                return memory;
            }

            System.out.print("Enter another number: ");
            double b = getValidDouble(sc);
            memory = calculate(memory == 0 ? a : memory, checkOperator(operator), b);
            System.out.println("Memory: " + memory);
        }
    }

    public static void bmiCalculator(Scanner sc) {
        System.out.print("Enter weight (kg): ");
        double weight = getValidDouble(sc);
        System.out.print("Enter height (m): ");
        double height = getValidDouble(sc);

        BMIStatus status = calculateBMI(weight, height);
        System.out.printf("BMI Number: %.2f\n", weight / (height * height));
        System.out.println("BMI Status: " + status);
    }

    public static double calculate(double a, Operator operator, double b) {
        return switch (operator) {
            case PLUS -> a + b;
            case MINUS -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> {
                if (b == 0) throw new ArithmeticException("Cannot divide by zero!");
                yield a / b;
            }
            case POWER -> Math.pow(a, b);
        };
    }

    public static Operator checkOperator(String operator) {
        return switch (operator) {
            case "+" -> Operator.PLUS;
            case "-" -> Operator.MINUS;
            case "*" -> Operator.MULTIPLY;
            case "/" -> Operator.DIVIDE;
            case "^" -> Operator.POWER;
            default -> throw new IllegalArgumentException("Invalid operator!");
        };
    }

    public static BMIStatus calculateBMI(double weight, double height) {
        double bmi = weight / (height * height);
        if (bmi < 19) return BMIStatus.UNDER_STANDARD;
        else if (bmi < 25) return BMIStatus.STANDARD;
        else if (bmi < 30) return BMIStatus.OVERWEIGHT;
        else if (bmi < 40) return BMIStatus.FAT;
        else return BMIStatus.VERY_FAT;
    }

    public static boolean isValidOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("^");
    }

    public static double getValidDouble(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid number: ");
            }
        }
    }

    public static int getValidInteger(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid integer: ");
            }
        }
    }
}
