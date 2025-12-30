package hot100;

public class LEETCODE494 {


//    给你一个非负整数数组 nums 和一个整数 target 。
//
//    向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//    例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//    返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

    public int findTargetSumWays(int[] nums, int target) {

        // 先说思路
        // 考虑nums 前面添加- 为 n
        // 前面 添加+ 为p

        // 则有
        // n + p = sum
        // n - p = target

        // 2n = sum + target
        // 也就是说，你要从 nums 中选出 组合为 (sum + target)的组合

        int true_target = target;
        for (int i = 0; i<nums.length;i++){
            true_target = true_target + nums[i];
        }
        // 如果这个为奇数直接return 0
        if (true_target %2 != 0){
            return 0;
        }
        // 然后你后面这个背包容量是 true_target
        // 所以你还要判断这个 true_target是不是大于0
        if (true_target < 0){
            return 0;
        }

        true_target = true_target/2;


        // 每个coin 只能用一次，找出和为 true_target 的组合数
        int[] dp = new int[true_target+1];
        dp[0] = 1;

        for (int i = 0; i <nums.length; i++){

            for (int j = true_target;j>=nums[i];j--){
                dp[j] += dp[j-nums[i]];
            }

        }

        return dp[true_target];




    }


}
