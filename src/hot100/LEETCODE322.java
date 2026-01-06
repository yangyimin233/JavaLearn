package hot100;

public class LEETCODE322 {

//    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//    你可以认为每种硬币的数量是无限的。


    public int coinChange(int[] coins, int amount) {

        int len = amount + 1;
        int minnums[] = new int[len];

        // 初始化
        minnums[0] = 0;

        // 然后是转移条件
        // minnums[i] 表示  数额i 所需的最小钱币数

        // 对每个 币值coin 遍历
        // minnums[i] = min(minnums[i], minnums[i - coin] + 1)

        // 这里先初始化为-1
        for (int i = 1; i < len; i++) {
            minnums[i] = -1;
        }

        for(int i =1; i<len; i++ ){

            // 在这里面遍历每个币值
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    if (minnums[i-coins[j]]!=-1){
                        // 说明i-coins[j]有 组合
                        if (minnums[i] == -1){
                            // 说明当前还没有组合，直接赋值
                            minnums[i] = minnums[i-coins[j]];
                        }else {
                            minnums[i] = Math.min(minnums[i], minnums[i-coins[j]] + 1);
                        }

                    }
                }
            }



        }

        return minnums[len-1];



    }

}
