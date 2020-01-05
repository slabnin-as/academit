package matrix;

import vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException("Размер не может быть меньше 0");
        }

        rows = new Vector[rowsCount];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(columnsCount);
        }
    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(double[][] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше 0");
        }

        //поиск максимально длинной строки в переданном массиве
        int maxRowLength = 0;

        for (double[] row : array) {
            if (row.length > maxRowLength) {
                maxRowLength = row.length;
            }
        }

        if (maxRowLength == 0) {
            throw new IllegalArgumentException("Передан пустой массив!");
        }

        rows = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(maxRowLength, array[i]);
        }
    }

    public Matrix(Vector[] rows) {
        if (rows.length <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше 0!");
        }

        //поиск максимального по длине вектора;
        int maxVectorSize = 0;

        for (Vector vector : rows) {
            if (vector.getSize() > maxVectorSize) {
                maxVectorSize = vector.getSize();
            }
        }

        this.rows = new Vector[rows.length];

        for (int i = 0; i < this.rows.length; i++) {
            this.rows[i] = new Vector(maxVectorSize);
            this.rows[i].sum(rows[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{");
        for (Vector v : rows) {
            builder.append(v).append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append("}");

        return builder.toString();
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("Индекс задан неверно");
        }

        return new Vector(rows[index]);
    }

    public void setRow(int index, Vector vector) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("Индекс задан неверно");
        }

        if (vector.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException("Размер вектора должен быть равен: " + getColumnsCount());
        }

        rows[index] = new Vector(vector);
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= getColumnsCount()) {
            throw new IndexOutOfBoundsException("Индекс задан неверно");
        }

        Vector vector = new Vector(rows.length);

        for (int i = 0; i < rows.length; i++) {
            vector.setComponent(i, rows[i].getComponent(index));
        }

        return vector;
    }

    public void transpose() {
        Vector[] rows = new Vector[getColumnsCount()];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = getColumn(i);
        }

        this.rows = rows;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector row : rows) {
            row.multiply(scalar);
        }
    }

    private double getMinor(int columnIndex) {
        double[][] matrixTemp = new double[getRowsCount() - 1][getColumnsCount() - 1];

        int matrixTempRows = 0;

        for (int i = 1; i < rows.length; i++) {
            int matrixTempColumns = 0;
            for (int j = 0; j < getColumnsCount(); j++) {
                if (j == columnIndex) {
                    continue;
                }
                matrixTemp[matrixTempRows][matrixTempColumns] = rows[i].getComponent(j);
                matrixTempColumns++;
            }
            matrixTempRows++;
        }

        return new Matrix(matrixTemp).getDeterminant();
    }

    public double getDeterminant() {
        if (getRowsCount() != getColumnsCount()) {
            throw new IllegalArgumentException("Матрица должны быть квадратная!");
        }

        if (getRowsCount() == 1) {
            return rows[0].getComponent(0);
        }

        if (getRowsCount() == 2) {
            return rows[0].getComponent(0) * rows[1].getComponent(1) - rows[1].getComponent(0) * rows[0].getComponent(1);
        }

        double determinant = 0;

        for (int i = 0; i < rows.length; i++) {
            determinant += rows[0].getComponent(i) * Math.pow(-1, i) * getMinor(i);
        }

        return determinant;
    }

    public Vector multiplyByVector(Vector vector) {
        if (vector.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException("Число столбцов матрицы и размер вектора должны быть равны!");
        }

        Vector resultVector = new Vector(getRowsCount());

        for (int i = 0; i < rows.length; i++) {
            resultVector.setComponent(i, Vector.multiplyScalar(vector, rows[i]));
        }

        return resultVector;
    }

    public void sum(Matrix matrix) {
        if (getRowsCount() != matrix.getRowsCount() || getColumnsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера!");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].sum(matrix.rows[i]);
        }
    }

    public void subtract(Matrix matrix) {
        if (getRowsCount() != matrix.getRowsCount() || getColumnsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера!");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].subtract(matrix.rows[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getRowsCount() || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера!");
        }

        Matrix resultMatrix = new Matrix(matrix1);
        resultMatrix.sum(matrix2);

        return resultMatrix;
    }

    public static Matrix getSubtract(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getRowsCount() || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера!");
        }

        Matrix resultMatrix = new Matrix(matrix1);
        resultMatrix.subtract(matrix2);

        return resultMatrix;
    }

    public static Matrix multiplyMatrices(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Число столбцов матрицы А должны быть равно числу строк матрицы В");
        }

        double[][] result = new double[matrix1.getRowsCount()][matrix2.getColumnsCount()];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = Vector.multiplyScalar(matrix1.rows[i], matrix2.getColumn(j));
            }
        }

        return new Matrix(result);
    }
}
