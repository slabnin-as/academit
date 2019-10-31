package shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private static final String name = "Треугольник";

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    private static double getSide(double pointX1, double pointY1, double pointX2, double pointY2) {
        return Math.sqrt(Math.pow((pointX2 - pointX1), 2) + Math.pow((pointY2 - pointY1), 2));
    }

    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    public double getArea() {
        double a = getSide(x1, y1, x2, y2);
        double b = getSide(x2, y2, x3, y3);
        double c = getSide(x3, y3, x1, y1);
        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    public double getPerimeter() {
        double a = getSide(x1, y1, x2, y2);
        double b = getSide(x2, y2, x3, y3);
        double c = getSide(x3, y3, x1, y1);
        return a + b + c;
    }

    @Override
    public String toString() {
        return name + "." + System.lineSeparator() +
                "Площадь: " + getArea() + System.lineSeparator() +
                "Периметр " + getPerimeter() + System.lineSeparator() +
                "Ширина: " + getWidth() + System.lineSeparator() +
                "Высота: " + getHeight() + System.lineSeparator() +
                "(x1, y1):{" + x1 + ", " + y1 + "}" + System.lineSeparator() +
                "(x2, y2):{" + x2 + ", " + y2 + "}" + System.lineSeparator() +
                "(x3, y3):{" + x3 + ", " + y3 + "}" + System.lineSeparator();
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
        return x1 == triangle.x1 && y1 == triangle.y1 && x2 == triangle.x2 && y2 == triangle.y2
                && x3 == triangle.x3 && y3 == triangle.y3;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = hash * prime + Double.hashCode(x1);
        hash = hash * prime + Double.hashCode(y1);
        hash = hash * prime + Double.hashCode(x2);
        hash = hash * prime + Double.hashCode(y2);
        hash = hash * prime + Double.hashCode(x3);
        hash = hash * prime + Double.hashCode(y3);
        return hash;
    }
}