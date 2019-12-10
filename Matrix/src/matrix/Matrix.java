package matrix;

import vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Размер не может быть меньше 0");
        }

        this.rows = new Vector[rows];

        for (int i = 0; i < this.rows.length; i++) {
            this.rows[i] = new Vector(columns);
        }
    }

    public Matrix(Matrix matrix) {
        this.rows = matrix.rows.clone();
    }

    public Matrix(double[][] array) {
        //поиск максимально длинной строки в переданном массиве
        int maxRow = 0;

        for (double[] row : array) {
            if (row.length > maxRow) {
                maxRow = row.length;
            }
        }

        rows = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(maxRow, array[i]);
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

        this.rows = rows;

        for (int i = 0; i < this.rows.length; i++) {
            if (this.rows[i].getSize() < maxVectorSize) {
                this.rows[i] = this.rows[i].sum(new Vector(maxVectorSize));
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

    public int getRowSize() {
        return rows.length;
    }

    public int getColumnSize() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        return rows[index];
    }

    public void setRow(int index, Vector vector) {
        if(vector.getSize() != getColumnSize()){
            throw new IllegalArgumentException("Размер вектора должен быть равен: " + getColumnSize());
        }

        rows[index] = new Vector(vector);
    }

    public Vector getColumn(int index) {
        Vector vector = new Vector(rows.length);

        for (int i = 0; i < rows.length; i++) {
            vector.setComponent(i, rows[i].getComponent(index));
        }

        return vector;
    }

    public void transpose() {
        Vector[] rows = new Vector[getColumnSize()];

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
        double[][] matrixTemp = new double[getRowSize() - 1][getColumnSize() - 1];

        int matrixTempRows = 0;

        for (int i = 1; i < rows.length; i++) {
            int matrixTempColumns = 0;
            for (int j = 0; j < getColumnSize(); j++) {
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
        if (getRowSize() != getColumnSize()) {
            throw new IllegalArgumentException("Матрица должны быть квадратная!");
        }

        if (getRowSize() == 1) {
            return rows[0].getComponent(0);
        }

        if (getRowSize() == 2) {
            return rows[0].getComponent(0) * rows[1].getComponent(1) - rows[1].getComponent(0) * rows[0].getComponent(1);
        }

        double determinant = 0;

        for (int i = 0; i < rows.length; i++) {
            determinant += rows[0].getComponent(i) * Math.pow(-1, i) * getMinor(i);
        }

        return determinant;

    }

    public Vector multiplyByVector(Vector vector) {
        if (vector.getSize() != getColumnSize()) {
            throw new IllegalArgumentException("Число столбцов матрицы и размер вектора должны быть равны!");
        }
        Vector resultVector = new Vector(getRowSize());

        for (int i = 0; i < rows.length; i++) {
            resultVector.setComponent(i, Vector.multiplyScalar(vector, rows[i]));
        }

        return resultVector;
    }

    public void sum(Matrix matrix) {
        if (getRowSize() != matrix.getRowSize() && getColumnSize() != matrix.getColumnSize()) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера!");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].sum(matrix.getRow(i));
        }
    }

    public void sub(Matrix matrix) {
        if (getRowSize() != matrix.getRowSize() && getColumnSize() != matrix.getColumnSize()) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера!");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].subtract(matrix.getRow(i));
        }
    }

    public static Matrix sum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowSize() != matrix2.getRowSize() || matrix1.getColumnSize() != matrix2.getColumnSize()) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера!");
        }

        Matrix resultMatrix = new Matrix(matrix1);
        resultMatrix.sum(matrix2);

        return resultMatrix;
    }

    public static Matrix sub(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowSize() != matrix2.getRowSize() || matrix1.getColumnSize() != matrix2.getColumnSize()) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера!");
        }

        Matrix resultMatrix = new Matrix(matrix1);
        resultMatrix.sub(matrix2);

        return resultMatrix;
    }

    public static Matrix multiplyMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnSize() != matrix2.getRowSize()) {
            throw new IllegalArgumentException("Число столбцов матрицы А должны быть равно числу строк матрицы В");
        }

        double[][] result = new double[matrix1.getRowSize()][matrix2.getColumnSize()];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = Vector.multiplyScalar(matrix1.getRow(i), matrix2.getColumn(j));
            }
        }

        return new Matrix(result);
    }
}
