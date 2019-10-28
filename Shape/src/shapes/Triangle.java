package shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private double a;
    private double b;
    private double c;
    private double halfPerimeter;
    private static final String name = "Треугольник";

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        a = getSide(x1, y1, x2, y2);
        b = getSide(x2, y2, x3, y3);
        c = getSide(x3, y3, x1, y1);
        halfPerimeter = (a + b + c) / 2;
    }

    private double getSide(double pointX1, double pointY1, double pointX2, double pointY2) {
        return Math.sqrt(Math.pow((pointX2 - pointX1), 2) + Math.pow((pointY2 - pointY1), 2));
    }

    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    public double getArea() {
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return name + "." + " Площадь фигуры " + getArea() + "; " + "периметр фигуры " + getPerimeter();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) obj;
        return a == triangle.a && b == triangle.b && c == triangle.c;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = hash * prime + Double.hashCode(a);
        hash = hash * prime + Double.hashCode(b);
        hash = hash * prime + Double.hashCode(c);
        return hash;
    }
}