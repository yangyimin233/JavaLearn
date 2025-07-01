package zhanandduilie;

import javax.print.DocFlavor;

public class leetcode239 {

//    给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//    返回 滑动窗口中的最大值 。

    public static void main(String[] args) {
        int[] nums = {2,3,5,78,2,1,-1,10,3};
        int k = 3;
        int[] re = maxSlidingWindow(nums, k);
        for (int i = 0; i < re.length; i++) {
            System.out.println(re[i]);
        }

    }

// 1 <= k <= nums.length


    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 先来最笨的方法嘛
        // 确定result长度
        int[] result = new int[nums.length - k + 1];
        // 注意从i是要求从几到几
        for (int i = 0; i <= nums.length - k ; i++) {
            result[i] = findmax(nums, i, i+k-1);
        }
        return  result;


        // 不出所料，直接超时了
        // 还是得老老实实用这个队列来处理
        // 他得核心思想是，将这个窗口模拟成一个队列
        // 滑动这个窗口，队列会出一个元素，同时队列也会进一个元素
        // 然后他想把这个出元素就直接设置成re进入re数组
        // 问题是这个队列得poll和add方法该怎么设计？


    }

    // 来一个求数组区间的最大值的函数
    public static int findmax(int[]nums,int start ,int end){
        // 数组从start到end区间内的最大值，两边都包含
        int result = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            result = Math.max(result, nums[i]);
        }
        return  result;
    }





}
