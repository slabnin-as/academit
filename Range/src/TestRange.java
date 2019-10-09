import java.util.Arrays;

public class TestRange {
    public static void main(String[] args) {
        Range range1 = new Range(5, 18);
        Range range2 = new Range(11, 15);

        System.out.println(Range.makeIntersection(range1, range2));
        System.out.println(Arrays.toString(Range.makeUnion(range1, range2)));
        System.out.println(Arrays.toString(Range.makeComplement(range1, range2)));
    }
}
