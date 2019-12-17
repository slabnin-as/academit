package shapesmain;

import shapes.*;

import java.util.Arrays;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[7];
        shapes[0] = new Square(12.85);
        shapes[1] = new Square(6.87);
        shapes[2] = new Rectangle(4.5, 8.54);
        shapes[3] = new Rectangle(6.23, 12.54);
        shapes[4] = new Circle(4.34);
        shapes[5] = new Circle(11.65);
        shapes[6] = new Triangle(2.5, 4.7, 7.3, -2.6, -3.8, -1.5);

        sortShapesByAreaDescending(shapes);
        System.out.println(shapes[6]);

        sortShapesByPerimeterDescending(shapes);
        System.out.println(shapes[1]);
    }

    private static void sortShapesByAreaDescending(Shape[] shapes) {
        Arrays.sort(shapes, Collections.reverseOrder(new ShapeAreaComparator()));
    }

    private static void sortShapesByPerimeterDescending(Shape[] shapes) {
        Arrays.sort(shapes, Collections.reverseOrder(new ShapePerimeterComparator()));
    }
}