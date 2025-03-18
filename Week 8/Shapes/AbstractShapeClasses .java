abstract class Shape {
    abstract void display();
}

abstract class TwoDimensionalShape extends Shape {
    abstract double getArea();
}

abstract class ThreeDimensionalShape extends Shape {
    abstract double getArea();
    abstract double getVolume();
}