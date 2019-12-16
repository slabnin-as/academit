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

        rows = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(maxRowLength, array[i]);
        }
    }

    public Matrix(Vector[] rows) {
        //поиск максимального по длине вектора;
        int maxVectorSize = 0;

        for (Vector vector : rows) {
            if (vector.getSize() > maxVectorSize) {
                maxVectorSize = vector.getSize();
            }
        }

        this.rows = new Vector[rows.length];

        for (int i = 0; i < this.rows.length; i++) {
            this.rows[i] = new Vector(rows[i]);

            if (this.rows[i].getSize() < maxVectorSize) {
                this.rows[i].sum(new Vector(maxVectorSize));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{");
        for (Vector v : rows) {
            builder.append(v).append(",");
        }
        builder.setLength(builder.length() - 1);
        builder.append("}");

        return builder.toString();
    }

    public int getRowCount() {
        return rows.length;
    }

    public int getColumnCount() {
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

        if (vector.getSize() != getColumnCount()) {
            throw new IllegalArgumentException("Размер вектора должен быть равен: " + getColumnCount());
        }

        rows[index] = new Vector(vector);
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= getColumnCount()) {
            throw new IndexOutOfBoundsException("Индекс задан неверно");
        }

        Vector vector = new Vector(rows.length);

        for (int i = 0; i < rows.length; i++) {
            vector.setComponent(i, rows[i].getComponent(index));
        }

        return vector;
    }

    public void transpose() {
        Vector[] rows = new Vector[getColumnCount()];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = getColumn(i);
        }

        this.rows = rows;
    }

    public void multiplyScalar(double scalar) {
        for (Vector row : rows) {
            row.multiply(scalar);
        }
    }

    private double getMinor(int columnIndex) {
        double[][] matrixTemp = new double[getRowCount() - 1][getColumnCount() - 1];

        int matrixTempRows = 0;

        for (int i = 1; i < rows.length; i++) {
            int matrixTempColumns = 0;
            for (int j = 0; j < getColumnCount(); j++) {
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
        if (getRowCount() != getColumnCount()) {
            throw new IllegalArgumentException("Матрица должны быть квадратная!");
        }

        if (getRowCount() == 1) {
            return rows[0].getComponent(0);
        }

        if (getRowCount() == 2) {
            return rows[0].getComponent(0) * rows[1].getComponent(1) - rows[1].getComponent(0) * rows[0].getComponent(1);
        }

        double determinant = 0;

        for (int i = 0; i < rows.length; i++) {
            determinant += rows[0].getComponent(i) * Math.pow(-1, i) * getMinor(i);
        }

        return determinant;
    }

    public Vector multiplyByVector(Vector vector) {
        if (vector.getSize() != getColumnCount()) {
            throw new IllegalArgumentException("Число столбцов матрицы и размер вектора должны быть равны!");
        }
        Vector resultVector = new Vector(getRowCount());

        for (int i = 0; i < rows.length; i++) {
            resultVector.setComponent(i, Vector.multiplyScalar(vector, rows[i]));
        }

        return resultVector;
    }

    public void sum(Matrix matrix) {
        if (getRowCount() != matrix.getRowCount() || getColumnCount() != matrix.getColumnCount()) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера!");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].sum(matrix.getRow(i));
        }
    }

    public void subtraction(Matrix matrix) {
        if (getRowCount() != matrix.getRowCount() || getColumnCount() != matrix.getColumnCount()) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера!");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].subtract(matrix.getRow(i));
        }
    }

    public static Matrix sum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowCount() != matrix2.getRowCount() || matrix1.getColumnCount() != matrix2.getColumnCount()) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера!");
        }

        Matrix resultMatrix = new Matrix(matrix1);
        resultMatrix.sum(matrix2);

        return resultMatrix;
    }

    public static Matrix subtraction(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowCount() != matrix2.getRowCount() || matrix1.getColumnCount() != matrix2.getColumnCount()) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера!");
        }

        Matrix resultMatrix = new Matrix(matrix1);
        resultMatrix.subtraction(matrix2);

        return resultMatrix;
    }

    public static Matrix multiplyMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnCount() != matrix2.getRowCount()) {
            throw new IllegalArgumentException("Число столбцов матрицы А должны быть равно числу строк матрицы В");
        }

        double[][] result = new double[matrix1.getRowCount()][matrix2.getColumnCount()];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = Vector.multiplyScalar(matrix1.getRow(i), matrix2.getColumn(j));
            }
        }

        return new Matrix(result);
    }
}
