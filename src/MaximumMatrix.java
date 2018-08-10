import java.util.Scanner;

public class MaximumMatrix {

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean scan_matrix(boolean a[][], int start_i, int start_j, int n) {
        for (int i = start_i; i < start_i + n; i++)
            for (int j = start_j; j < start_j + n; j++) {
                if (!a[i][j])
                    return false;
            }
        return true;
    }

    public static int count_valid_matrix(boolean a[][], int n, int N) {
        int result = 0;
        for (int start_i = 0; start_i <= N - n; start_i++) {
            for (int start_j = 0; start_j <= N - n; start_j++) {
                if (scan_matrix(a, start_i, start_j, n))
                    result += 1;
            }
        }
        return result;
    }

    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        boolean a[][] = new boolean[N][N];
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = s.nextInt();
                a[i][j] = isPrime(num);
                if (a[i][j])
                    result += 1;
            }
        }
        int n = 2;
        while (n < N) {
            result += count_valid_matrix(a, n, N);
            n++;
        }
        System.out.println(result);
    }
}

