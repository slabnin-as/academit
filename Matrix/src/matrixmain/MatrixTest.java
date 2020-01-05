package matrixmain;

import matrix.Matrix;
import vector.Vector;

public class MatrixTest {
    public static void main(String[] args) {
        Vector[] rows = new Vector[2];
        rows[0] = new Vector(new double[]{-5.6, 7.7, 2.4, -9.2, 2.8});
        rows[1] = new Vector(new double[]{8.4, 2.9, 4.3, 5.2, -8.3});

        double[][] array = {{1, 3, 4}, {1, 2, 3, 7, 2}, {}};
        //double[][] array = {{}, {}, {}};

        Matrix matrix1 = new Matrix(3, 5);
        Matrix matrix2 = new Matrix(array);
        Matrix matrix3 = new Matrix(rows);
        Matrix matrix4 = new Matrix(matrix3);

        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);
        System.out.println(matrix4);
        System.out.println();

        //получение строки матрицы по индексу
        System.out.println(matrix4.getRow(1));
        //задание вектора по индексу
        System.out.println(rows[1].getSize());
        matrix1.setRow(1, rows[1]);
        System.out.println(matrix2);
        //получение вектора столбца по индексу
        System.out.println(matrix4.getColumn(2));
        //matrix transpose
        matrix4.transpose();
        System.out.println(matrix4);
        //scalar multiply
        matrix4.multiplyByScalar(-1);
        System.out.println(matrix4);
        //умножение матрицы на вектор
        System.out.println(matrix2);
        System.out.println(matrix2.multiplyByVector(new Vector(new double[]{34, 23, 56, 12, 76})));
        //сложение матриц
        matrix2.sum(matrix2);
        System.out.println(matrix2);
        //разница матриц
        matrix2.subtract(matrix2);
        System.out.println(matrix2);
        //перемножение матриц
        Matrix mt1 = new Matrix(new double[][]{{5, 4}, {2, 5}, {3, 1}});
        Matrix mt2 = new Matrix(new double[][]{{-2, 5}, {3, 4}});
        System.out.println(Matrix.multiplyMatrices(mt1, mt2));

        //определитель матрицы
        Matrix matrix5 = new Matrix(new double[][]{{1, 3, 4, 6}, {4, 6, 2, 8}, {7, 2, 5, 8}, {8, 3, 6, 1}});
        System.out.println(matrix5.getDeterminant());

        System.out.println(matrix5.getRowsCount() + "x" + matrix5.getColumnsCount());

        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(Matrix.getSum(matrix1, matrix2));
    }
}
