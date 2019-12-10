package vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("размер вектора должен быть больше 0");
        }

        components = new double[n];
    }

    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("массив не должен быть пустой");
        }

        this.components = components.clone();
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("размер вектора должен быть больше 0");
        }

        this.components = Arrays.copyOf(components, n);
    }

    public Vector(Vector vector) {
        this.components = vector.components.clone();
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{");
        for (double e : components) {
            builder.append(e).append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append("}");

        return builder.toString();
    }

    public Vector sum(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < components.length; i++) {
            components[i] += vector.components[i];
        }

        return this;
    }

    public static Vector sum(Vector vector1, Vector vector2) {
        return new Vector(vector1).sum(vector2);
    }

    public Vector subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < components.length; i++) {
            components[i] -= vector.components[i];
        }

        return this;
    }

    public static Vector subtract(Vector vector1, Vector vector2) {
        return new Vector(vector1).subtract(vector2);
    }

    public void multiply(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public static double multiplyScalar(Vector vector1, Vector vector2) {
        int minLength = Math.min(vector1.components.length, vector2.components.length);
        double composition = 0;

        for (int i = 0; i < minLength; i++) {
            composition += vector1.components[i] * vector2.components[i];
        }

        return composition;
    }

    public void reverse() {
        multiply(-1);
    }

    public double getLength() {
        double sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    public void setComponent(int index, double element) {
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

        if (components.length != vector.getSize()) {
            return false;
        }
        for (int i = 0; i < components.length; i++) {
            if (components[i] != vector.components[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int prime = 37;
        int hash = 1;
        hash = hash * prime + Arrays.hashCode(components);

        return hash;
    }
}