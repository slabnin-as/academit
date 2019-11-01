package shapes;

public class Square implements Shape {
    private double side;
    private static final String name = "Квадрат";

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return name + "." + System.lineSeparator() +
                "Площадь: " + getArea() + System.lineSeparator() +
                "Периметр: " + getPerimeter() + System.lineSeparator() +
                "Сторона: " + side + System.lineSeparator();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Square square = (Square) obj;
        return side == square.side;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = hash * prime + Double.hashCode(side);
        return hash;
    }
}