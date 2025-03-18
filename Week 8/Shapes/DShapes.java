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