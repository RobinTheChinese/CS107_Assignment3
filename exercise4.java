import java.util.Scanner;

public class exercise4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        int leftStart = 0;int rightStart = n - 1;
        int topStart = 0;int bottomStart = m - 1;
        while (true){
            for (int i = topStart; i <= bottomStart; i++) {
                matrix[i][leftStart] = sc.nextInt();
            }
            leftStart ++;
            if (leftStart > rightStart || topStart > bottomStart){break;}
            for (int i = leftStart; i <= rightStart; i++) {
                matrix[bottomStart][i] = sc.nextInt();
            }
            bottomStart --;
            if (leftStart > rightStart || topStart > bottomStart){break;}
            for (int i = bottomStart; i >= topStart; i--) {
                matrix[i][rightStart] = sc.nextInt();
            }
            rightStart --;
            if (leftStart > rightStart || topStart > bottomStart){break;}
            for (int i = rightStart; i >= leftStart; i--) {
                matrix[topStart][i] = sc.nextInt();
            }
            topStart ++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.println();
        }
    }
}
