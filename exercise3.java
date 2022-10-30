import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math;

public class exercise3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ptsInfo = new int[201][201];
        int ptsKind;int x;int y;
        for (int i = 0; i < n; i++) {
            ptsKind = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            ptsInfo[y + 100][x + 100] = ptsKind;
        }
        double S1 = 1;double S2 = Math.PI/4;double S3 = Math.sqrt(3)/4+Math.PI/6;
        double S = 0;

        //生成坐标点表，初始化

        int a;int b;int c;int d;
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                a = ptsInfo[i][j];b = ptsInfo[i+1][j];c = ptsInfo[i+1][j+1];d = ptsInfo[i][j+1];
                if (a == 2 || b == 2 || c == 2 || d == 2 ){
                    S += S1;
                } else if ((a == 1) && (c == 1)) {
                    S += S1;
                } else if ((b == 1) && (d == 1)) {
                    S += S1;
                } else if ((a == 1) && (b == 1)) {
                    S += S3;
                } else if ((b == 1) && (c == 1)) {
                    S += S3;
                } else if ((c == 1) && (d == 1)) {
                    S += S3;
                } else if ((d == 1) && (a == 1)) {
                    S += S3;
                } else if (a == 1 || b == 1 || c == 1 || d == 1) {
                    S += S2;
                }
            }
        }

        //判断内部格子面积

        int a1;int a2;int a3;int a4;int b1;int b2;int b3;int b4;
        for (int i = 0; i < 200; i++) {
            a1 = ptsInfo[0][i];b1 = ptsInfo[0][i+1];a2 = ptsInfo[i][0];b2 = ptsInfo[i+1][0];
            a3 = ptsInfo[200][i];b3 = ptsInfo[200][i+1];a4 = ptsInfo[i][200];b4 = ptsInfo[i+1][200];
            if (a1 == 2 || b1 == 2){
                S += S1;
            } else if (a1 != b1) {
                S += S2;
            } else if (a1 == 1) {
                S += S3;
            }

            if (a2 == 2 || b2 == 2){
                S += S1;
            } else if (a2 != b2) {
                S += S2;
            } else if (a2 == 1) {
                S += S3;
            }

            if (a3 == 2 || b3 == 2){
                S += S1;
            } else if (a3 != b3) {
                S += S2;
            } else if (a3 == 1) {
                S += S3;
            }

            if (a4 == 2 || b4 == 2){
                S += S1;
            } else if (a4 != b4) {
                S += S2;
            } else if (a4 == 1) {
                S += S3;
            }
        }

        //计算边上格子面积

        if (ptsInfo[0][0] == 1){
            S += S2;
        } else if (ptsInfo[0][0] == 2) {
            S += S1;
        }

        if (ptsInfo[0][200] == 1){
            S += S2;
        } else if (ptsInfo[0][200] == 2) {
            S += S1;
        }

        if (ptsInfo[200][0] == 1){
            S += S2;
        } else if (ptsInfo[200][0] == 2) {
            S += S1;
        }

        if (ptsInfo[200][200] == 1){
            S += S2;
        } else if (ptsInfo[200][200] == 2) {
            S += S1;
        }

        //计算角上格子面积

        System.out.printf("%.5f",S);
    }
}
