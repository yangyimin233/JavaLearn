package hot100;

public class LEETCODE121 {


//    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。


    public int maxProfit(int[] prices) {

        // [7,1,5,3,6,4]
        // 返回5 表示 在 第二天买，第5天卖 赚5块

        // 本质上，是找 第 i 个位置 往后 的最大 数
        // 所以我们可以从后往前扫描
        // 维护一个max 标记 该位置往左的最大数

        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0 ; i--) {
            if (prices[i] > max) {
                // 当前位置比最大值大
                max = prices[i];
            } else {
                // 当天价格 比 后续最大 位置低，可能产生最大交易
                res = Math.max(res, max - prices[i]);
            }
        }
        return res;

    }



}
