package main;

import logic.Vector;

import static logic.Vector.*;

public class Main {
    public static void main(String[] args) {
        double[] test1 = {-5.6, 7.7, 2.4, -9.2, 2.8, 4.7};
        double[] test2 = {6.6, 3.7, 8.4, -5.2, 2.1, 9.7};
        Vector vector1 = new Vector(test1);
        Vector vector2 = new Vector(10, test2);
        Vector vector3 = new Vector(6);
        Vector vector4 = new Vector(vector1);

        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);
        System.out.println(vector4);

        //размер вектора2
        System.out.println(vector2.getSize());
        //длина вектора
        System.out.println(vector2.getLength());

        //умножение вектора на скаляр
        vector1.multiply(3.58);
        System.out.println(vector1);

        //прибавление к вектору другого вектора
        vector1.sum(vector2);
        System.out.println(vector1);

        //разворот вектора
        vector2.reverse();
        System.out.println(vector2);

        //вычитание из другого вектора
        vector2.subtract(vector1);
        System.out.println(vector2);

        //получение компоненты по индексу
        System.out.println(vector2.getComponent(3));

        //установка компоненты по индексу
        vector2.setComponent(3, 65.78);
        System.out.println(vector2);

        //сложение двух векторов
        Vector vector5 = sum(vector1, vector2);
        System.out.println(vector5);

        //вычитание векторов
        Vector vector6 = subtract(vector1, vector2);
        System.out.println(vector6);

        //скалярное произведение векторов
        double scalar = multiplyScalar(vector1, vector2);
        System.out.println(scalar);

    }
}
