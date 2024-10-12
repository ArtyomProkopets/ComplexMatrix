public class Main {
    public static void main(String[] args) {
        testMatrix2x2();
    }

    public static void testMatrix2x2() {
        System.out.println("--- Тест для матрицы 2x2 ---");
        ComplexNumber[][] data1 = {
                {new ComplexNumber(1, 2), new ComplexNumber(2, 4)},
                {new ComplexNumber(3, 6), new ComplexNumber(1, 8)}
        };
        ComplexNumber[][] data2 = {
                {new ComplexNumber(2, 1), new ComplexNumber(4, 3)},
                {new ComplexNumber(6, 9), new ComplexNumber(8, 7)}
        };
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        System.out.println("Матрица 1:");
        System.out.println(matrix1);
        System.out.println("Матрица 2:");
        System.out.println(matrix2);
        // Сложение
        Matrix resultAdd = matrix1.add(matrix2);
        System.out.println("Результат сложения матриц:");
        System.out.println(resultAdd);
        // Вычитание
        Matrix resultSubtract = matrix1.sub(matrix2);
        System.out.println("Результат вычитания матриц:");
        System.out.println(resultSubtract);
    }
}
