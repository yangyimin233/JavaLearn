package hot100;

public class LEETCODE53 {

    // 乘积那个写了，现在来看看这个最大子数组和

    public int maxSubArray(int[] nums) {

        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int[] maxsum = new int[len];

        // maxsum[i] 表示以i结尾，的最大子数组和

        // 初始化
        maxsum[0] = nums[0];

        // 然后是状态转移
        for (int i = 1; i < len; i++) {

            // 这个就比较简单了
            // 考虑两种情况，要么是把前面的子数组加上当前的数，要么就是当前的数自己重新开始
            maxsum[i] = Math.max(maxsum[i - 1] + nums[i], nums[i]);

        }


        for (int i = 0; i < len; i++) {
            res = Math.max(res, maxsum[i]);
        }
        return res;


    }


}
