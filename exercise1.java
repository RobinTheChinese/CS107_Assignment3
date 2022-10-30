import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n/2;
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        //初始化二维数组A、B、result

        int[][] A1 = new int[n/2][n/2];int[][] A2 = new int[n/2][n/2];
        int[][] A3 = new int[n/2][n/2];int[][] A4 = new int[n/2][n/2];
        for (int i = 0; i < m; i++) {
            System.arraycopy(A[i], 0, A1[i], 0, m);
        }
        for (int i = 0; i < m; i++) {
            System.arraycopy(A[i], m, A2[i], 0, m);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                A3[j][i] = A[i+m][j];
            }
        }
        for (int i = 0; i < m; i++) {
            System.arraycopy(A[i + m], m, A4[i], 0, m);
        }
        int[][] B1 = new int[n/2][n/2];int[][] B2 = new int[n/2][n/2];
        int[][] B3 = new int[n/2][n/2];int[][] B4 = new int[n/2][n/2];
        for (int i = 0; i < m; i++) {
            System.arraycopy(B[i], 0, B1[i], 0, m);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                B2[j][i] = B[i][j+m];
            }
        }
        for (int i = 0; i < m; i++) {
            System.arraycopy(B[i + m], 0, B3[i], 0, m);
        }
        for (int i = 0; i < m; i++) {
            System.arraycopy(B[i + m], m, B4[i], 0, m);
        }

        //生成中间量列表A1~A4，B1~B4

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = A1[i][j] + B1[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    result[i][j + m] += A2[i][k] * B2[k][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    result[i + m][j] += B3[i][k] * A3[k][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                result[i + m][j + m] = A4[i][j] - B4[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ",result[i][j]);
            }
            System.out.println();
        }
    }
}
