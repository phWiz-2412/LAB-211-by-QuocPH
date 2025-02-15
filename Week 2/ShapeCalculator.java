package ShapeCalculator;

abstract class Shape {
    public abstract double getPerimeter();

    public abstract double getArea();

    public abstract void printResult();
}

class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.printf("Width: %.1f\n", width);
        System.out.printf("Length: %.1f\n", length);
        System.out.printf("Area: %.1f\n", getArea());
        System.out.printf("Perimeter: %.1f\n", getPerimeter());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void printResult() {
        System.out.println("-----Circle-----");
        System.out.printf("Radius: %.1f\n", radius);
        System.out.printf("Area: %.2f\n", getArea());
        System.out.printf("Perimeter: %.2f\n", getPerimeter());
    }
}

class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public void printResult() {
        System.out.println("-----Triangle-----");
        System.out.printf("Side A: %.1f\n", sideA);
        System.out.printf("Side B: %.1f\n", sideB);
        System.out.printf("Side C: %.1f\n", sideC);
        System.out.printf("Area: %.2f\n", getArea());
        System.out.printf("Perimeter: %.1f\n", getPerimeter());
    }
}

public class ShapeCalculator {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("===== Calculator Shape Program =====");

        System.out.print("Please input side width of Rectangle: ");
        double width = getValidDouble(sc);
        System.out.print("Please input length of Rectangle: ");
        double length = getValidDouble(sc);

        System.out.print("Please input radius of Circle: ");
        double radius = getValidDouble(sc);

        System.out.print("Please input side A of Triangle: ");
        double sideA = getValidDouble(sc);
        System.out.print("Please input side B of Triangle: ");
        double sideB = getValidDouble(sc);
        System.out.print("Please input side C of Triangle: ");
        double sideC = getValidDouble(sc);

        System.out.println();

        Rectangle rectangle = new Rectangle(width, length);
        rectangle.printResult();

        Circle circle = new Circle(radius);
        circle.printResult();

        Triangle triangle = new Triangle(sideA, sideB, sideC);
        triangle.printResult();
    }

    public static double getValidDouble(java.util.Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid number: ");
            }
        }
    }
}
