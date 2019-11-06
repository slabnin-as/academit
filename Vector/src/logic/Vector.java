package logic;

import java.util.Arrays;

public class Vector {
    private int size;
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("размер неверный");
        }
        size = n;
        components = new double[n];
    }

    public Vector(double[] components) {
        size = components.length;
        this.components = components.clone();
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("размер неверный");
        }
        size = n;
        this.components = Arrays.copyOf(components, n);
    }

    public int getSize() {
        return size;
    }

    private double[] getVector() {
        return components;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (double e : components) {
            builder.append(e).append(", ");
        }
        builder.setCharAt(builder.lastIndexOf(","), '}');

        return builder.toString();
    }

    public void sumVector(Vector vector) {
        int i = 0;
        while (i < size && i < vector.getSize()) {
            components[i] = components[i] + vector.getVector()[i];
            i++;
        }
    }

    public static Vector sumVector(Vector vector1, Vector vector2) {
        Vector vector;
        if (vector1.getSize() > vector2.getSize()) {
            vector = new Vector(vector1.getSize(), vector1.getVector());
            vector.sumVector(vector2);
        } else {
            vector = new Vector(vector2.getSize(), vector2.getVector());
            vector.sumVector(vector1);
        }
        return vector;
    }

    public void subVector(Vector vector) {
        int i = 0;
        while (i < size && i < vector.getSize()) {
            components[i] = components[i] - vector.getVector()[i];
            i++;
        }
    }

    public static Vector subVector(Vector vector1, Vector vector2) {
        Vector vector;
        if (vector1.getSize() > vector2.getSize()) {
            vector = new Vector(vector1.getSize(), vector1.getVector());
            vector.subVector(vector2);
        } else {
            vector = new Vector(vector2.getSize(), vector2.getVector());
            vector.subVector(vector1);
        }
        return vector;
    }

    public void scalarVector(double scalar) {
        for (int i = 0; i < size; i++) {
            components[i] = components[i] * scalar;
        }
    }

    public static double scalarVector(Vector vector1, Vector vector2) {
        int i = 0;
        double composition = 0;
        while (i < vector1.getSize() && i < vector2.getSize()) {
            composition += vector1.getVector()[i] * vector2.getVector()[i];
            i++;
        }

        return composition;
    }

    public void reverseVector() {
        for (int i = 0; i < size; i++) {
            components[i] = components[i] * -1;
        }
    }

    public double getVectorLength() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += components[i] * components[i];
        }

        return Math.sqrt(sum);
    }

    public void appendComponent(double element, int index) {
        components[index] = element;
    }

    public double getComponent(int index) {
        return components[index];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Vector vector = (Vector) obj;
        if (size != vector.getSize()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (components[i] != vector.getVector()[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int prime = 37;
        int hash = 1;
        hash = hash * prime + Integer.hashCode(size);
        hash = hash * prime + Arrays.hashCode(components);

        return hash;
    }
}