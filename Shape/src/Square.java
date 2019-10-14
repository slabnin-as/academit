public class Square implements Shape {
    private double side;
    private String name = "Квадрат";

    public Square(double side) {
        this.side = side;
    }

    public double getWidth() {
        return side;
    }

    public double getHeight() {
        return side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }

    public String toString() {
        return name + "." + " Площадь фигуры " + getArea() + "; " + "периметр фигуры " + getPerimeter();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Square square = (Square) obj;
        return this.side == square.side;
    }

    public int hashCode() {
        final int prime = 13;
        int hash = 1;
        hash = hash * prime + Double.hashCode(side);
        return hash;
    }
}