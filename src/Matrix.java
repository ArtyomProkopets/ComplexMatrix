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
    public void setNum(ComplexNumber num, int row, int col){
        this.matrix[row][col] = num;
    }

    public Matrix add(Matrix otherMatrix){
        Matrix res = new Matrix(row, col);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                res.matrix[i][j] = this.matrix[i][j].add(otherMatrix.matrix[i][j]);
            }
        }
        return res;
    }
    public Matrix sub(Matrix otherMatrix){
        Matrix res = new Matrix(row, col);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                res.matrix[i][j] = this.matrix[i][j].sub(otherMatrix.matrix[i][j]);
            }
        }
        return res;
    }
/*    public Matrix mult(){

    }*/

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
