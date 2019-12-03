package main;

import model.Range;

import java.util.Arrays;

public class TestRange {
    public static void main(String[] args) {
        Range range1 = new Range(6, 12);
        Range range2 = new Range(7, 10);

        System.out.println(range1.getIntersection(range2));
        System.out.println(Arrays.toString(range1.getUnion(range2)));
        System.out.println(Arrays.toString(range1.getDifference(range2)));
        System.out.println(range1);
        System.out.println(range2);
    }
}
