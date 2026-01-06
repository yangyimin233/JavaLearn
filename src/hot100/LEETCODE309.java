package hot100;

public class LEETCODE309 {


//    给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
//    设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。


    public int maxProfit(int[] prices) {

        // 这种感觉需要动态规划来做
        // 同时维护三个dp


        // hold[i] 表示今天手上有股票的状态下的最大收益
        // 什么情况下，今天能有股票？
        // 情况一： 今天买了
        // 昨天刚卖？，不行，因为有冷却期
        // 昨天休息？ 可以 hold[i] = rest[i-1] - p
        // 情况二： 昨天就hold了
        // hold[i] = hold[i-1]
        // 思考，这里 为什么 没有 hold = rest[i-1] 的选项？ 这个表示昨天在休息，今天还是在休息，所以手上没有股票，不能算hold状态

        // rest[i] 表示今天休息状态下的最大收益
        // rest状态表示 今天在休息，该状态含义为今天手上没有股票，并且今天也没有买入，也就是说明天可以执行买入
        // 然后是什么情况下 今天没股票？
        // 情况一 昨天卖了 rest[i] = sold[i-1]
        // 情况二 昨天就在休息 rest[i] = rest[i-1]

        // sold[i] 表示今天卖了的情况下的最大收益
        // 然后是今天卖了
        // 今天只能从 昨天hold状态卖
        // sold[i] = hold[i-1] + p


        // 初始化
        int len = prices.length;
        int[] hold = new int[len];
        int[] sold = new int[len];
        int[] rest = new int[len];

        if (len == 1) {
            // 只有一天，肯定没法赚钱
            return 0;
        }

        // 第一天持有股票，那只能是第一天就买了
        hold[0] = -prices[0];
        // 第一天不能卖，这时候初始值应该赋什么？ 我试了一下0也可以
        sold[0] = Integer.MIN_VALUE;
        // 第一天休息情况下，这个是能出现的，收益为0没问题
        rest[0] = 0;

        for (int i = 1; i < len; i++) {

            int p = prices[i];
            // 然后分别统计每种情况下的最大收益
            hold[i] = Math.max(hold[i - 1], rest[i-1] - p);
            sold[i] = hold[i-1] + p;
            rest[i] = Math.max(rest[i-1], sold[i-1]);

        }

        // 然后最终返回肯定是 sold 或者 rest 中的一个
        return  Math.max(rest[len-1], sold[len-1]);





    }






}
