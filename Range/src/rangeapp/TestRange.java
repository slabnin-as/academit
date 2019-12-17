package rangeapp;

import range.Range;

import java.util.Arrays;

public class TestRange {
    public static void main(String[] args) {
        Range range1 = new Range(8, 15);
        Range range2 = new Range(6, 12);

        System.out.println(range1.getIntersection(range2));
        System.out.println(Arrays.toString(range1.getUnion(range2)));
        System.out.println(Arrays.toString(range1.getDifference(range2)));
        System.out.println(range1 + " length: " + range1.getLength());
        System.out.println("Range2 from: " + range2.getFrom() + " To: " + range2.getTo());
        System.out.println("Число 6 принадлежит диапазону range2: " + range2.isInside(6));

        range1.setTo(14);
        range2.setFrom(15);
    }
}
