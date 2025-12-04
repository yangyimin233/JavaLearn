package hot100;

public class LEETCODE238 {

//    给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//
//    题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//
//    请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
//    输入: nums = [1,2,3,4]
//    输出: [24,12,8,6]

    public int[] productExceptSelf(int[] nums) {
        // 这个题实际上不是很舒服
        int len = nums.length;
        int[] re = new int[len];

        // 思路 遍历两次，第一次计算 nums[i]
        re[len-1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            re[i] = nums[i+1] * re[i+1];
        }
        // 第二次
        int temp = 1;
        for (int i = 1; i<len ; i++) {
            temp *= nums[i-1];
            re[i] = re[i] * temp;
        }


        return re;





    }



}
