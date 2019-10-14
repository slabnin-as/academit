import java.util.Comparator;

public class ShapePerimeterComparator implements Comparator<Shape>{
    @Override
    public int compare(Shape shape1, Shape shape2){
        if(shape1.getPerimeter() > shape2.getPerimeter()){
            return 1;
        } else if (shape1.getPerimeter() < shape2.getPerimeter()){
            return -1;
        } else {
            return 0;
        }
    }
}