package hot100;

import java.awt.font.FontRenderContext;
import java.sql.SQLOutput;

public class LEETCODE221 {

    // 最大正方形
    public int maximalSquare(char[][] matrix) {

        // 很明显，这个需要用动态规划来做
        // dp[i][j] 表示 第i行第j列 作为正方形的右下角时，所能构成的最大正方形的边长
        // 也就是dp[i][j] 要往 左上 方向去看

        // 然后就是推导状态转移方式
        int maxSide = 0;

        // 顺便记一下这种二维矩阵的行列获取方法
        int rows = matrix.length;
        int cols = matrix[0].length;

        int dp[][] = new int[rows][cols];


        // 初始化很简单，第一行和第一列，如果等于1，dp[][]为1 ，否则为0
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == '1'){
                dp[0][i] = 1;
                maxSide = 1;
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == '1'){
                dp[i][0] = 1;
                maxSide = 1;
            } else {
                dp[i][0] = 0;
            }
        }

        // 然后开始状态转移
        // 首先，dp[][]肯定大于等于 他所有左上的值
        // 问题是思考，什么时候这个dp[][]会大于左上值呢？
        // 如果matrix[i][j] == '0'，那么此时一定dp[i][j] = 0
        // 如果matrix[i][j] == '1'，那么dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }





        // 注意返回值
        return maxSide * maxSide;



    }

    public static void main(String[] args) {

        int test[] = new int[3];
        test[0] = 1;
        test[1] = 2;
        test[2] = 3;
        System.out.println(test[2]);

    }


}