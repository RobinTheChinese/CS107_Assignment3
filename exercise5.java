import java.util.Scanner;

public class exercise5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        boolean[][] matrixResult = new boolean[n][n];

        //初始化棋盘

        int recognizer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-4; j++) {
                for (int k = j; k < j+5; k++) {
                    if (matrix[i][k] == 1){recognizer ++;}
                }
                if (recognizer == 4){
                    for (int k = j; k < j+5; k++) {
                        if (matrix[i][k] == 0){
                            matrixResult[i][k] = true;
                            break;
                        }
                    }
                }
                recognizer = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-4; j++) {
                for (int k = j; k < j+5; k++) {
                    if (matrix[k][i] == 1){recognizer ++;}
                }
                if (recognizer == 4){
                    for (int k = j; k < j+5; k++) {
                        if (matrix[k][i] == 0){
                            matrixResult[k][i] = true;
                            break;
                        }
                    }
                }
                recognizer = 0;
            }
        }

        for (int i = 0; i < n-4; i++) {
            for (int j = 0; j < n-4; j++) {
                for (int k = i; k < i+5; k++) {
                    if (matrix[k][k + j - i] == 1){recognizer ++;}
                }
                if (recognizer == 4){
                    for (int k = i; k < i+5; k++) {
                        if (matrix[k][k + j - i] == 0){
                            matrixResult[k][k + j - i] = true;
                            break;
                        }
                    }
                }
                recognizer = 0;
            }
        }

        for (int i = 0; i < n-4; i++) {
            for (int j = n-1; j > 3; j--) {
                for (int k = i; k < i+5; k++) {
                    if (matrix[k][j + i - k] == 1){recognizer ++;}
                }
                if (recognizer == 4){
                    for (int k = i; k < i+5; k++) {
                        if (matrix[k][j + i - k] == 0){
                            matrixResult[k][j + i - k] = true;
                            break;
                        }
                    }
                }
                recognizer = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrixResult[i][j]) {
                    System.out.print(i + 1);
                    System.out.print(" ");
                    System.out.print(j + 1);
                    System.out.println();
                }
            }
        }
    }
}
