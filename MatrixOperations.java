public class MatrixOperations {

    public static void main(String[] args) {
        try {
            long[][] A = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
            };

            long[][] B = {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
            };

            long[][] C = xorMatrices(A, B);

            System.out.println("Матриця C (A ^ B):");
            printMatrix(C);

            long result = processMatrix(C);

            System.out.println("Результат обчислень: " + result);

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    public static long[][] xorMatrices(long[][] A, long[][] B) throws Exception {
        if (A.length != B.length || A[0].length != B[0].length) {
            throw new Exception("Матриці мають різні розміри.");
        }

        long[][] C = new long[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j] ^ B[i][j];
            }
        }

        return C;
    }

    public static long processMatrix(long[][] C) {
        long sum = 0;

        for (int j = 0; j < C[0].length; j++) {
            if (j % 2 == 0) {
                long min = C[0][j];
                for (int i = 1; i < C.length; i++) {
                    if (C[i][j] < min) {
                        min = C[i][j];
                    }
                }
                sum += min;
            } else {
                long max = C[0][j];
                for (int i = 1; i < C.length; i++) {
                    if (C[i][j] > max) {
                        max = C[i][j];
                    }
                }
                sum += max;
            }
        }

        return sum;
    }

    public static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            for (long element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
