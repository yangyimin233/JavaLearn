package hot100;

public class LEETCODE152 {

//    给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//    测试用例的答案是一个 32-位 整数。
//    请注意，一个只包含一个元素的数组的乘积是这个元素的值。

    public int maxProduct(int[] nums) {

        int len = nums.length;
        int res = Integer.MIN_VALUE;

        // 用滑动窗口来做？

        // 不太好做。其实是用的动态规划，不过这里因为±的存在，同时维护了max和min
        int max[] = new int[len];
        int min[] = new int[len];

        // max[i] 表示以 nums[i] 结尾的子数组的最大乘积
        // min 同理

        // 初始化
        max[0] = nums[0];
        min[0] = nums[0];

        // 然后是转移方程
        for (int i = 1; i < len; i++) {

            // 如果当前数字是正数
            // 则以nums[i] 结尾的最大子数组，有两种情况
            // 1. nums[i]单独开始
            // 2. 接上之前的

            if (nums[i]>0){
                // 大于0 大得更大
                // 小的 更小
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else if (nums[i]<0){
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            } else {
                // 如果当前数字是0
                // 则以nums[i] 结尾的最大子数组只能是0
                max[i] = 0;
                min[i] = 0;
            }

        }
        // 最后返回的是max[]里面最大的那个
        for (int i = 0; i < len; i++) {
            res = Math.max(res,max[i]);
        }
        return res;
    }




}
