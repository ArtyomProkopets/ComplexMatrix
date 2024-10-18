public class Matrix {
    private int row;
    private int col;
    private ComplexNumber[][] matrix;

    public Matrix(int row, int col){
        matrix = new ComplexNumber[row][col];
        this.row = row;
        this.col = col;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = new ComplexNumber(0, 0);
            }
        }
    }

    public Matrix(ComplexNumber[][] matrix){
        this.row = matrix.length;
        this.col = matrix[0].length;
        this.matrix = matrix;
    }

    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public ComplexNumber getMatrix(int row, int col){
        return this.matrix[row][col];
    }

    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int col){
        this.col = col;
    }
    public void setNum(ComplexNumber num, int rows, int columns) {
        if (rows >= 0 && rows < row && columns >= 0 && columns < col) {
            this.matrix[rows][columns] = num;
        } else {
            throw new IllegalArgumentException("Invalid element indexes");
        }
    }

    public Matrix add(Matrix otherMatrix){
        if (row != otherMatrix.row || col != otherMatrix.col) {
            throw new IllegalArgumentException("Matrix addition is not possible");
        }
        Matrix res = new Matrix(row, col);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                res.matrix[i][j] = this.matrix[i][j].add(otherMatrix.matrix[i][j]);
            }
        }
        return res;
    }
    public Matrix sub(Matrix otherMatrix){
        if (row != otherMatrix.row || col != otherMatrix.col) {
            throw new IllegalArgumentException("Matrix subtraction is not possible");
        }
        Matrix res = new Matrix(row, col);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                res.matrix[i][j] = this.matrix[i][j].sub(otherMatrix.matrix[i][j]);
            }
        }
        return res;
    }
    public Matrix mult(Matrix otherMatrix){
        if (this.col != otherMatrix.row) {
            throw new IllegalArgumentException("Matrix multiplication is not possible");
        }
        Matrix result = new Matrix(this.row, otherMatrix.col);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < otherMatrix.col; j++) {
                for (int k = 0; k < this.col; k++) {
                    result.matrix[i][j] = result.matrix[i][j].add(this.matrix[i][k].mult(otherMatrix.matrix[k][j]));
                }
            }
        }
        return result;
    }
    public Matrix transpose(){
        Matrix transposedMatrix = new Matrix(col, row);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transposedMatrix.matrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
    private Matrix getMinor(int rowToExclude, int colToExclude) {
        ComplexNumber[][] minor = new ComplexNumber[row - 1][col - 1];
        int rowOffset = 0, colOffset = 0;

        for (int i = 0; i < row; i++) {
            if (i == rowToExclude) {
                rowOffset = 1;
                continue;
            }
            colOffset = 0;
            for (int j = 0; j < col; j++) {
                if (j == colToExclude) {
                    colOffset = 1;
                    continue;
                }
                minor[i - rowOffset][j - colOffset] = this.matrix[i][j];
            }
        }
        return new Matrix(minor);
    }
    public ComplexNumber determinant() {
        if (row != col) {
            throw new IllegalArgumentException("Matrix must be square");
        }

        if (row == 1) {
            return matrix[0][0];
        }

        if (row == 2) {
            ComplexNumber a = matrix[0][0];
            ComplexNumber b = matrix[0][1];
            ComplexNumber c = matrix[1][0];
            ComplexNumber d = matrix[1][1];
            return a.mult(d).sub(b.mult(c));
        }

        ComplexNumber det = new ComplexNumber(0, 0);
        for (int j = 0; j < col; j++) {
            Matrix minor = getMinor(0, j);
            ComplexNumber cofactor = matrix[0][j].mult(new ComplexNumber(Math.pow(-1, j), 0));
            det = det.add(cofactor.mult(minor.determinant()));
        }

        return det;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(matrix[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
