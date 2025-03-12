abstract class Shape {
    abstract void display();
}
abstract class TwoDimensionalShape extends Shape {
    abstract double getArea();
}

class Circle extends TwoDimensionalShape {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    @Override
    double getArea() { return Math.PI * radius * radius; }
    @Override
    void display() { System.out.println("Circle Area: " + getArea()); }
}

class Square extends TwoDimensionalShape {
    private double side;
    public Square(double side) { this.side = side; }
    @Override
    double getArea() { return side * side; }
    @Override
    void display() { System.out.println("Square Area: " + getArea()); }
}

class Triangle extends TwoDimensionalShape {
    private double base, height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    double getArea() { return 0.5 * base * height; }
    @Override
    void display() { System.out.println("Triangle Area: " + getArea()); }
}

// Three-Dimensional Shapes
abstract class ThreeDimensionalShape extends Shape {
    abstract double getArea();
    abstract double getVolume();
}

class Sphere extends ThreeDimensionalShape {
    private double radius;
    public Sphere(double radius) { this.radius = radius; }
    @Override
    double getArea() { return 4 * Math.PI * radius * radius; }
    @Override
    double getVolume() { return (4.0 / 3) * Math.PI * Math.pow(radius, 3); }
    @Override
    void display() { System.out.println("Sphere - Area: " + getArea() + ", Volume: " + getVolume()); }
}

class Cube extends ThreeDimensionalShape {
    private double side;
    public Cube(double side) { this.side = side; }
    @Override
    double getArea() { return 6 * side * side; }
    @Override
    double getVolume() { return Math.pow(side, 3); }
    @Override
    void display() { System.out.println("Cube - Area: " + getArea() + ", Volume: " + getVolume()); }
}

class Tetrahedron extends ThreeDimensionalShape {
    private double side;
    public Tetrahedron(double side) { this.side = side; }
    @Override
    double getArea() { return Math.sqrt(3) * side * side; }
    @Override
    double getVolume() { return (1.0 / 12) * Math.sqrt(2) * Math.pow(side, 3); }
    @Override
    void display() { System.out.println("Tetrahedron - Area: " + getArea() + ", Volume: " + getVolume()); }
}
