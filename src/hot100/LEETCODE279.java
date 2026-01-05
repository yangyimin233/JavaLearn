package hot100;

public class LEETCODE279 {

    // 完全平方数
//    给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//    完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

//    输入：n = 12
//    输出：3
//    解释：12 = 4 + 4 + 4

    public int numSquares(int n) {

        // 思路直接dp[i] 表示 凑出i所需的最少 的完全平方数 个数
        // 然后是初始化，这个好想
        // dp[0] = 0
        // dp[i] = i

        // 然后从i = 1 开始，dp[i] = min(dp[i]，dp[i-j*j]+1)
        // 比如这样
        // dp[0] = dp[1] = dp[2] = dp[3] = i+1
        // dp[4] = min(4，dp[0]+1) = 1

        // 注意长度
        int[] dp = new int[n + 1];

        // 初始化
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int sq = j * j;
                // 从1开始枚举比i小的完全平方数
                dp[i] = Math.min(dp[i], dp[i - sq] + 1);
            }
        }


        return dp[n];


    }


}
