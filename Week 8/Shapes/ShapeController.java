class ShapeController {
    private final Shape[] shapes;
    
    public ShapeController() {
        shapes = new Shape[]{
            new Circle(5), new Square(4), new Triangle(3, 6),
            new Sphere(3), new Cube(2), new Tetrahedron(4)
        };
    }
    
    public void displayShapes() {
        for (Shape shape : shapes) {
            shape.display();
        }
    }
}
