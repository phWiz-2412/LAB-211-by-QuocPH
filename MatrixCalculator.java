package MatrixCalculator;

import java.util.Scanner;

class Matrix {
    private int rows;
    private int cols;
    private double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double[][] getData() {
        return data;
    }

    public void inputMatrix(Scanner sc) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter Matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
                data[i][j] = getValidDouble(sc);
            }
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.2f ", data[i][j]);
            }
            System.out.println();
        }
    }

    public Matrix additionMatrix(Matrix matrix2) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + matrix2.data[i][j];
            }
        }
        return result;
    }

    public Matrix subtractionMatrix(Matrix matrix2) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - matrix2.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiplicationMatrix(Matrix matrix2) {
        Matrix result = new Matrix(this.rows, matrix2.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix2.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * matrix2.data[k][j];
                }
            }
        }
        return result;
    }

    private double getValidDouble(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.next());
            } catch (NumberFormatException e) {
                System.out.print("Value of matrix is digit. Please try again: ");
            }
        }
    }
}

public class MatrixCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=======Calculator program=======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            int choice = getValidInt(sc, 1, 4);

            if (choice == 4) {
                System.out.println("Exiting program...");
                break;
            }

            System.out.print("Enter Row Matrix: ");
            int rows = getValidInt(sc, 1, Integer.MAX_VALUE);
            System.out.print("Enter Column Matrix: ");
            int cols = getValidInt(sc, 1, Integer.MAX_VALUE);

            Matrix matrix1 = new Matrix(rows, cols);
            Matrix matrix2 = new Matrix(rows, cols);

            System.out.println("Enter values for Matrix 1:");
            matrix1.inputMatrix(sc);
            System.out.println("Enter values for Matrix 2:");
            matrix2.inputMatrix(sc);

            try {
                Matrix result;
                switch (choice) {
                    case 1:
                        result = matrix1.additionMatrix(matrix2);
                        System.out.println("Result:");
                        result.displayMatrix();
                        break;
                    case 2:
                        result = matrix1.subtractionMatrix(matrix2);
                        System.out.println("Result:");
                        result.displayMatrix();
                        break;
                    case 3:
                        result = matrix1.multiplicationMatrix(matrix2);
                        System.out.println("Result:");
                        result.displayMatrix();
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }

    public static int getValidInt(Scanner sc, int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(sc.next());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.print("Invalid choice. Please enter a number between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid integer: ");
            }
        }
    }
}
