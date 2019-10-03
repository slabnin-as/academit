public class Range {
    private double from;
    private double to;

    Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    @Override
    public boolean equals(Object obj) {
        Range range = (Range) obj;
        if (obj == null) {
            return false;
        }
        return this.to == range.to && this.from == range.from;
    }

    @Override
    public String toString() {
        return "Range[" + from + ", " + to + "]";
    }

    static Range makeIntersection(Range range1, Range range2) {
        if (range1.from > range2.to || range1.to < range2.from) {
            return null;
        }

        return new Range(Math.max(range1.from, range2.from), Math.min(range1.to, range2.to));
    }

    static Range[] makeUnion(Range range1, Range range2) {
        Range[] unionRange;
        if (range1.from > range2.to || range1.to < range2.from) {
            unionRange = new Range[2];
            unionRange[0] = range1;
            unionRange[1] = range2;
        } else {
            unionRange = new Range[1];
            unionRange[0] = new Range(Math.min(range1.from, range2.from), Math.max(range1.to, range2.to));
        }

        return unionRange;
    }

    static Range[] makeComplement(Range range1, Range range2) {
        Range[] unionRange;
        if (range1.from > range2.to || range1.to < range2.from) {
            unionRange = new Range[1];
            unionRange[0] = range1;
        } else if (range1.equals(makeIntersection(range1, range2))) {
            return null;
        } else {
            unionRange = new Range[2];
            unionRange[0] = new Range(range1.from, range2.from - 1);
            unionRange[1] = new Range(range2.to + 1, range1.to);
        }

        return unionRange;
    }
}
