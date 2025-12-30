package hot100;

import java.util.List;

public class LEETCODE518 {

//    给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
//    请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
//    假设每一种面额的硬币有无限个


    public int change(int amount, int[] coins) {

        // 这种我统一将其归类于 完全背包问题
        // coin可以随便用无限次

        // 这种都是先来一个dp数组
        int[] dp = new int[amount + 1];
        // dp[i] 表示 组成金额 i 的硬币组合数

        // 初始化也都是一样的
        dp[0] = 1; // 组成金额0 的组合数为1，什么都不选


        // 然后注意，每次遍历是外层遍历硬币，内层遍历金额
        for (int i = 0; i < coins.length; i++) {


            // 然后区别在于内层的遍历顺序，
            // 完全背包 从dp[小金额]开始到 dp[大金额]
            // 之后的dp[大金额] 可以利用到 前面的dp[小金额]
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }

            // 如果是 每个硬币只能用一次
            // 很神奇嗷，就是dp[大金额] 到 dp[小金额]，这样 dp[小金额] 不会被后面的dp[大金额] 利用到
            // 遍历就是这样写的
//            for (int j = amount; j >= coins[i]; j--) {



            // 然后是背包问题也在这一并说了吧
            // 考虑 一个背包容量为 W 的背包，和 N 个物品，每个物品有重量 wt[i] 和价值 val[i] 。
            // 先是完全背包
            // 我们考虑 dp[w] 表示容量为 w 的背包所能装下的最大价值
            // 然后一样地，外层遍历物品，内层遍历容量
            // for i in 0..N-1:
            // 然后内层
            // dp[j] 表示 ，当前容量为 j 的背包所能装下的最大价值
            // 比如 外层遍历到 第二个物品
            // dp[j]表示 仅考虑前 两个物品，容量为 j 的背包所能装下的最大价值

            // 然后是状态转移方程
            // dp[j] = max( dp[j] , dp[j - wt[i]] + val[i] )
            // 此外 0 1 和完全的区别就在于 内层
            // 一个是从 j = wt[i] 到 W
            // 一个是从 j = W 到 wt[i]
            // eg
//            int weight[] = {1, 3, 4};
//            int value[] = {15, 20, 30};
//            int W = 4;
//            int dp_bag[] = new int[W + 1];
//            for (int a = 0; a < weight.length; a++) {
//
//                // 完全背包
//                for (int b = weight[a]; b <= W; b++) {
//                    dp_bag[b] = Math.max(dp_bag[b], dp_bag[b - weight[a]] + value[a]);
//                }
//                // 0-1背包
//                for (int b = W; b >= weight[a]; b--) {
//                    dp_bag[b] = Math.max(dp_bag[b], dp_bag[b - weight[a]] + value[a]);
//                }
//
//            }
//            return  dp_bag[W];


            // 完全背包时，内层容量遍历是从小到大遍历


        }




        return dp[amount];
    }


}
