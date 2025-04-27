package garden_planner.model;

public class CircleBed extends GardenBed {
    private double radius;

    public CircleBed() {

    }

    public CircleBed(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public double getWidth() {
        return 2*radius;
    }

    @Override
    public double getHeight() {
        return 2*radius;
    }

    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle %.2f %.2f %.2f", left, top, radius);
    }

}
