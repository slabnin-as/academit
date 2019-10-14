import java.util.Arrays;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private String name = "Треугольник";

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    private double a = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    private double b = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
    private double c = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2));
    private double halfPerimeter = (a + b + c) / 2;

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
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Triangle triangle = (Triangle) obj;
        double[] sidesThisTriangle = {this.a, this.b, this.c};
        double[] sidesCompareTriangle = {triangle.a, triangle.b, triangle.c};
        Arrays.sort(sidesThisTriangle);
        Arrays.sort(sidesCompareTriangle);

        return Arrays.equals(sidesThisTriangle, sidesCompareTriangle);
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 1;
        hash = hash * prime + Double.hashCode(a);
        hash = hash * prime + Double.hashCode(b);
        hash = hash * prime + Double.hashCode(c);
        return hash;
    }
}