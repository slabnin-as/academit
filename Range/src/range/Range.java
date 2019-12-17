package range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
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
    public String toString() {
        return "Range[" + from + ", " + to + "]";
    }

    public Range getIntersection(Range range) {
        if (from >= range.to || to <= range.from) {
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (from > range.to || to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        } else {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }
    }

    public Range[] getDifference(Range range) {
        Range[] ranges;

        if (range.from <= from && range.to >= to) {
            ranges = new Range[]{};
        } else if (range.from > from && range.to < to) {
            ranges = new Range[]{new Range(from, range.from), new Range(range.to, to)};
        } else if (range.to > from && range.to < to) {
            ranges = new Range[]{new Range(range.to, to)};
        } else if (range.from > from && range.from < to) {
            ranges = new Range[]{new Range(from, range.from)};
        } else {
            ranges = new Range[]{new Range(from, to)};
        }

        return ranges;
    }
}
