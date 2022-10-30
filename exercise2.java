import java.util.Scanner;

public class exercise2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        int[][] gridMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gridMap[i][j] = sc.nextInt();
            }
        }

        //初始化图像、计数器

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (gridMap[i][j] != gridMap[i+1][j]){
                    num ++;
                }
            }
        }
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < n; i++) {
                if (gridMap[i][j] != gridMap[i][j+1]){
                    num ++;
                }
            }
        }

        //读取内部边界数

        for (int i = 0; i < n; i++) {
            if (gridMap[0][i] == 1){
                num ++;
            }
            if (gridMap[n-1][i] == 1){
                num ++;
            }
            if (gridMap[i][0] == 1){
                num ++;
            }
            if (gridMap[i][n-1] == 1){
                num ++;
            }
        }
        System.out.print(num);
    }
}
