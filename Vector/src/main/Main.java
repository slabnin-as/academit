package main;

import logic.Vector;

import static logic.Vector.*;

public class Main {
    public static void main(String[] args) {
        double[] test1 = {1.6, 3.2, 4.5, 6.4, 7.9, 8.2};
        double[] test2 = {6.6, 3.7, 8.4, -5.2, 2.1, 9.7};
        Vector vector1 = new Vector(test1);
        Vector vector2 = new Vector(10, test2);
        Vector vector3 = new Vector(7);

        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);

        //размер вектора2
        System.out.println(vector2.getSize());
        //длина вектора
        System.out.println(vector2.getVectorLength());

        //умножение вектора на скаляр
        vector1.scalarVector(3.58);
        System.out.println(vector1);

        //прибавление к вектору другого вектора
        vector1.sumVector(vector2);
        System.out.println(vector1);

        //разворот вектора
        vector2.reverseVector();
        System.out.println(vector2);

        //вычитание из другого вектора
        vector2.subVector(vector1);
        System.out.println(vector2);

        //получение компоненты по индексу
        System.out.println(vector2.getComponent(3));

        //установка компоненты по индексу
        vector2.appendComponent(65.78, 3);
        System.out.println(vector2);

        //сложение двух векторов
        Vector vector4 = sumVector(vector1, vector2);
        System.out.println(vector4);

        //вычитание векторов
        Vector vector5 = subVector(vector1, vector2);
        System.out.println(vector5);

        //скалярное произведение векторов
        double scalar = scalarVector(vector1, vector2);
        System.out.println(scalar);

    }
}
