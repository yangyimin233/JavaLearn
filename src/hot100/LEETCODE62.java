package hot100;

public class LEETCODE62 {

//    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//    问总共有多少条不同的路径？

    public int uniquePaths(int m, int n) {

        // 现在动态规划我的建议是，你自己画画那个矩阵，很快就找到规律了
        // 比如 3*4 的 P[i][j] 表示 从 00 到 ij 的路径方法
        // 起点 00 记为 0
        // 0 1 1 1
        // 1 2 3 4
        // 1 3 6 10

        int res[][] = new int[m][n];
        res[0][0] = 0; // 实际上这个无所谓

        // 然后行初始化
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        // 列初始化
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }

        // 然后从 [1][1] 开始嘛，一行一行算
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <n; j++) {
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }

        return res[m-1][n-1];





    }




}
