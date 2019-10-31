package main;

import logic.Vector;

public class Main {
    public static void main(String[] args) {
        double[] test1 = {1.6, 3.2, 4.5, 6.4, 7.9, 8.2};
        double[] test2 = {6.6, 3.7, 8.4, -5.2, 2.1, 9.7};
        Vector vector1 = new Vector(4, test1);
        Vector vector2 = new Vector(10, test2);
        Vector vector3 = Vector.subVector(vector1, vector2);

        System.out.println(vector1 + " Длина вектора: " + vector1.getVectorLength());

        System.out.println(vector3);
        vector1.subVector(vector2);
        System.out.println(vector1);
    }
}
