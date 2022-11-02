import java.util.Scanner;

public class exercise3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ptsInfo = new int[203][203];
        int ptsKind;int x;int y;
        for (int i = 0; i < n; i++) {
            ptsKind = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            if (ptsInfo[-y + 101][x + 101] < ptsKind) {
                ptsInfo[-y + 101][x + 101] = ptsKind;
            }
        }
        double S1 = 1;double S2 = Math.PI/4;double S3 = Math.sqrt(3)/4+Math.PI/6;
        double S = 0;

        //生成坐标点表，初始化

        int a;int b;int c;int d;
        for (int i = 0; i < 202; i++) {
            for (int j = 0; j < 202; j++) {
                a = ptsInfo[i][j];b = ptsInfo[i+1][j];c = ptsInfo[i+1][j+1];d = ptsInfo[i][j+1];
                if (a == 2 || b == 2 || c == 2 || d == 2 ){
                    S += S1;
                } else if (((a == 1) && (c == 1)) || ((b == 1) && (d == 1))) {
                    S += S1;
                } else if (((a == 1) && (b == 1)) || ((b == 1) && (c == 1)) ||
                          ((c == 1) && (d == 1)) || ((d == 1) && (a == 1))) {
                    S += S3;
                } else if (a == 1 || b == 1 || c == 1 || d == 1) {
                    S += S2;
                }
            }
        }

        //判断格子面积

        System.out.printf("%.5f",S);
    }
}
