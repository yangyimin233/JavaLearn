package hot100;

public class LEETCODE416 {

    public boolean canPartition(int[] nums) {
//        给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。



        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / 2;

        if (sum%2 !=0){
            return false;
        }

        // 现在就是看 nums[] 中能否找出一些数，使得它们的和为 target
        // 动态规划来做
        boolean[] dp = new boolean[target + 1];
        // dp[i] 表示 是否能从 nums[] 中选出一些数，使得它们的和为 i

        // 初始化
        dp[0] = true; // 和为0，什么数都不选，也是可以的

        // 这是ai写的，但是我觉得从nums在外面不好理解？来试试dp在外面

        // 所以现在你要想为什么把这个nums放外面
        for (int num : nums) {

            // 给你一个num ，你能让哪些dp[j] 变为 true 呢？

            // 注意这里是逆序遍历

            // 而且这里面 也是从 dp[target] 一直往dp[num] 遍历
            // 因为如果正着来 ，当前num可能被使用多次
            // 还是那个例子 [2,2,3,5] target=6
            // num 指向第二个2的时候
            // dp[4] true (2+2)
            // dp[6] true 因为 dp[4] true + 2 =6 ，但是dp[4] 实际上已经把2 用完 了

            // 但是如果你反着来呢？

            for (int j = target; j >= num; j--) {
//                dp[j] = dp[j] || dp[j - num];

                // 写成更好理解的形式
                if (dp[j - num]) {
                    dp[j] = true;
                }


            }
        }


//        for (int i = 1; i <= target; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                // 然后每个数来看看
//                // 如果 当前数 nums[j] 小于等于 i，并且 dp[i - nums[j]] 为 true
//                // 说明 可以组成 i
//                if (j <= nums[i] && dp[i - nums[j]]) {
//                    dp[i] = true;
//                    break; // 找到一个就行了
//                }
//            }
//        }
        // 但是这样写有一个问题，就是会重复使用 nums[] 中的数，比如[2,2,3,5] target=6
        //  dp[1] false
        // dp[2] true
        // dp[3] true
        // dp[4] true (2+2)
        // dp[5] true (5)
        // dp[6] true 因为 dp[4] true + 2 =6 ，但是dp[4] 实际上已经把2 用完 了






        return dp[target];



    }


}
