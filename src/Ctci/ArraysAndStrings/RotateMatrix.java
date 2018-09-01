package Ctci.ArraysAndStrings;

public class RotateMatrix {


    static public int[][] answer(int[][] matrix) {


        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return null;
        }
        int length = matrix.length;

        for (int layer = 0; layer < length / 2; layer++) {
            int first = layer;
            int last = length - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {


        int[][] test = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] answer = answer(test);

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println("");

        }

    }
}
