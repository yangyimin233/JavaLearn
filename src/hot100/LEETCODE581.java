package hot100;

import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

public class LEETCODE581 {

//    给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//    请你找出符合题意的 最短 子数组，并输出它的长度。

    public int findUnsortedSubarray(int[] nums) {

//        // 先来最笨的，我们先给他排序，然后左右指针扫一遍看看情况
//        int[] copy = Arrays.copyOf(nums, nums.length);
//        //  2 4 6 8 10 9 15
//        //  2 4 6 8 9 10 15
//        Arrays.sort(copy);
//        int left = 0;
//        int right = nums.length - 1;
//
//        while (left < right && nums[left] == copy[left]) {
//            left++;
//        }
//        while (right > left && nums[right] == copy[right]) {
//            right--;
//        }
//        // 思考，right 和 left指向同一个位置说明什么？
//        // 有没有可能 return 1？
//        // 不可能
//        if (left != right) {
//            return right - left + 1;
//        } else {
//            return 0;
//        }



        // 然后有没有 O（n）复杂度的？
        // 偷了点理解
        // 2 6 4 8 10 9 15
        // 跟这个对比
        // 2 4 6 8 9 10 15

        // 其中无序子数组 为 6 4 8 10 9
        // 右边界怎么找？
        // 维护一个max
        // 从左往右扫
        // 如果 nums[i] < max
        // 说明 当前i不该在这个位置
        // 然后更新 right = i
        // 以上面这个为例
        // 一开始 2 max= 2
        // 6 没问题，比max大， max = 6
        // 4 小于max ，说明 4往前 需要 重新排 right 指向4
        // 8 没问题 比max大，max = 8
        // 10 同理，max = 10
        // 然后 9 也有问题，right指向 9
        // 15 没问题
        // 所以这里最终保证了 从 right 往后的数组 自增，且第一个大于之前的最大值
        // 我们再举个例子
        // 4 9 7 6 10 12

        // 4 6 7 9 10 12
        // 你这样过了一遍后 right 指向 6


        // 同样的，左边界怎么找?
        // 维护一个min
        // 从右往左扫
        // 如果 nums[i] > min
        // 说明当前 i 不该在这个位置

        // 扫描找到左边界
        int right = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] >= max) {
                // 没问题合法的
                max = nums[i];
            } else {
                // 当前值比max小，说明 当前指向位置 向左需要重新排
                right = i;
            }

        }
        // 如果一趟下俩，right 还是指向0
        // 说明整个数组有序，可以直接返回 0
        if (right == 0){
            return 0;
        }

        // 然后处理左边界
        int left = nums.length - 1;
        int min = nums[left];

        for (int k = nums.length - 2; k >= 0 ; k--) {

            if (nums[k] <= min) {
                // 没问题合法的
                min = nums[k];
            } else {
                // 当前值比max小，说明 当前指向位置 向左需要重新排
                left = k;
            }

        }

        return right - left;





    }


}
