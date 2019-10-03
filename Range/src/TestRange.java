import java.util.Arrays;

public class TestRange {
    public static void main(String[] args) {
        Range range1 = new Range(10, 20);
        Range range2 = new Range(6, 19);

        System.out.println(range1.equals(range2));
        System.out.println(Range.makeIntersection(range1, range2));
        System.out.println(Arrays.toString(Range.makeUnion(range1, range2)));
        System.out.println(Arrays.toString(Range.makeComplement(range1, range2)));
    }
}
