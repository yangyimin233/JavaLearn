package shuzhu;

public class leetcode977 {

    // 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        // 最笨的思路，先平方后再排序，但很明显不要这样搞

        // 先遍历找到最大负数和最小正数的索引 ， 是这样的
        int nagindex = 0;
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] < 0) {
                nagindex = i;
            } else {
                break;
            }
        }
        int posindex = nagindex + 1;

        if (nagindex == nums.length) {
            // 说明全是负数
            for (int i = 0; i < nums.length; i++) {
                result[i] = nums[nagindex - i] * nums[nagindex - i];
            }
        }
        // 然后开始双指针，比较nagindex和posindex的平方值，谁小就放到result的前面
        for (int i = 0; i < result.length; i++) {
            if (nagindex < 0) {
                // 说明已经没有负数了
                result[i] = nums[posindex] * nums[posindex];
                posindex++;
            } else if (posindex >= nums.length) {
                // 说明已经没有正数了
                result[i] = nums[nagindex] * nums[nagindex];
                nagindex--;
            } else if (Math.abs(nums[nagindex]) < Math.abs(nums[posindex])) {
                // 负数的平方小于正数的平方
                result[i] = nums[nagindex] * nums[nagindex];
                nagindex--;
            } else {
                // 正数的平方小于等于负数的平方
                result[i] = nums[posindex] * nums[posindex];
                posindex++;
            }
        }



        return result;
    }



}
