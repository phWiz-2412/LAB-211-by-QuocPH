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