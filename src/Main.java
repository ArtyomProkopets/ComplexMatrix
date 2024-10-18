public class Main {
    public static void main(String[] args) {
        testComplexNumber();
        testMatrix();
        testMatrixDeterminant();
    }

    public static void testComplexNumber() {
        // Test the creation of complex numbers
        ComplexNumber num1 = new ComplexNumber(3, 4);
        ComplexNumber num2 = new ComplexNumber(1, 2);
        System.out.println("Complex Number 1: " + num1);
        System.out.println("Complex Number 2: " + num2);

        // Test addition
        ComplexNumber addResult = num1.add(num2);
        System.out.println("Addition Result: " + addResult);

        // Test subtraction
        ComplexNumber subResult = num1.sub(num2);
        System.out.println("Subtraction Result: " + subResult);

        // Test multiplication
        ComplexNumber multResult = num1.mult(num2);
        System.out.println("Multiplication Result: " + multResult);

        // Test getters and setters
        num1.setRe(5);
        num1.setIm(7);
        System.out.println("Updated Complex Number 1: " + num1);
        System.out.println("Real part of num1: " + num1.getRe());
        System.out.println("Imaginary part of num1: " + num1.getIm());

        System.out.println("ComplexNumber tests completed.\n");
    }

    public static void testMatrix() {
        // Test exception
        /*
        Matrix matrix = new Matrix(2, 2);
        try {
            matrix.setNum(new ComplexNumber(2, 1), 2, 2);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught an exception in setNum: " + e.getMessage());
        }
        */

        // Test matrix creation
        ComplexNumber[][] data1 = {
                {new ComplexNumber(1, 1), new ComplexNumber(2, 2)},
                {new ComplexNumber(3, 3), new ComplexNumber(4, 4)}
        };
        ComplexNumber[][] data2 = {
                {new ComplexNumber(5, 5), new ComplexNumber(6, 6)},
                {new ComplexNumber(7, 7), new ComplexNumber(8, 8)}
        };

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        System.out.println("Matrix 1:");
        System.out.println(matrix1);

        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        // Test matrix addition
        Matrix addMatrix = matrix1.add(matrix2);
        System.out.println("Matrix Addition Result:");
        System.out.println(addMatrix);

        // Test matrix subtraction
        Matrix subMatrix = matrix1.sub(matrix2);
        System.out.println("Matrix Subtraction Result:");
        System.out.println(subMatrix);

        // Test matrix multiplication
        Matrix multMatrix = matrix1.mult(matrix2);
        System.out.println("Matrix Multiplication Result:");
        System.out.println(multMatrix);

        // Test matrix transpose
        Matrix transposeMatrix = matrix1.transpose();
        System.out.println("Matrix Transpose Result:");
        System.out.println(transposeMatrix);

        // Test matrix setters and getters
        matrix1.setNum(new ComplexNumber(9, 9), 0, 0);
        System.out.println("Matrix 1 after setting (0, 0) to 9+9i:");
        System.out.println(matrix1);

        System.out.println("Get value at (0, 1): " + matrix1.getMatrix(0, 1));
        System.out.println("Matrix rows: " + matrix1.getRow());
        System.out.println("Matrix columns: " + matrix1.getCol());

        System.out.println("Matrix tests completed.\n");
    }

    public static void testMatrixDeterminant() {
        // Test exception
        /*
        Matrix nonSquareMatrix = new Matrix(2, 3);
        try {
            nonSquareMatrix.determinant();  // Ошибка, так как матрица не квадратная
        } catch (IllegalArgumentException e) {
            System.err.println("Caught an exception in determinant: " + e.getMessage());
        }
        */

        ComplexNumber[][] data3 = {
                {new ComplexNumber(1, 0), new ComplexNumber(2, 0), new ComplexNumber(3, 0)},
                {new ComplexNumber(4, 0), new ComplexNumber(5, 0), new ComplexNumber(6, 0)},
                {new ComplexNumber(7, 0), new ComplexNumber(8, 0), new ComplexNumber(9, 0)}
        };

        Matrix matrix3 = new Matrix(data3);
        System.out.println("Matrix 3:");
        System.out.println(matrix3);

        ComplexNumber det = matrix3.determinant();
        System.out.println("Determinant of Matrix 3: " + det);

        ComplexNumber[][] data4 = {
                {new ComplexNumber(2, 1), new ComplexNumber(3, 0)},
                {new ComplexNumber(1, -1), new ComplexNumber(4, 0)}
        };

        Matrix matrix4 = new Matrix(data4);
        System.out.println("Matrix 4:");
        System.out.println(matrix4);

        ComplexNumber det2 = matrix4.determinant();
        System.out.println("Determinant of Matrix 4: " + det2);

        System.out.println("Matrix determinant tests completed.\n");
    }
}
