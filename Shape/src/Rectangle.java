public class Rectangle implements Shape {
    private double width;
    private double height;
    private String name = "Прямоугольник";

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    public String toString() {
        return name + "." + " Площадь фигуры " + getArea() + "; " + "периметр фигуры " + getPerimeter();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
        return (this.width == rectangle.width || this.width == rectangle.height) && (this.height == rectangle.height || this.height == rectangle.width);
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 1;
        hash = hash * prime + Double.hashCode(width);
        hash = hash * prime + Double.hashCode(height);
        return hash;
    }
}