package shuzhu;

import java.sql.SQLOutput;
import java.util.IllegalFormatCodePointException;

public class leetcode209 {

//    给定一个含有 n 个正整数的数组和一个正整数 target 。
//    找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

//    输入：target = 7, nums = [2,3,1,2,4,3]
//    输出：2
//    解释：子数组 [4,3] 是该条件下的长度最小的子数组。


    public static void main(String[] args) {

       // [12,28,83,4,25,26,25,2,25,25,25,12]
       int[] nums = new int[]{4,2,4,1,5,2};
       int target = 17;

        System.out.println(isGreater(nums, 10, 0, 2)); // 测试isGreater方法

       leetcode209 solution = new leetcode209();
       int result = solution.minSubArrayLen(target, nums);
       System.out.println(result); // 输出结果


    }


//    public int minSubArrayLen(int target, int[] nums) {
//        int count = 0; // 子数组的长度
//
//        // 我来的话，我先直接排序，从大到小先排个序，然后往后遍历直到>= target
////       我擦，这个要求返回的子数组得是连续得，不能随便凑
////        int[] sortedNums = new int[nums.length];
////        for (int i = 0; i < nums.length; i++) {
////            sortedNums[i] = nums[i];
////        }
////
////        // 冒泡排序
////        for (int j = 0; j < sortedNums.length; j++) {
////            for (int i = 0; i < sortedNums.length - j - 1; i++) {
////                if (sortedNums[i] <= sortedNums[i+1]) {
////                    int temp = sortedNums[i+1];
////                    sortedNums[i+1] = sortedNums[i];
////                    sortedNums[i] = temp;
////                }
////            }
////        }
////
////        // 遍历排序后的数组，找到满足条件的子数组
////        int sum = 0; // 当前子数组的和
////        for (int i = 0; i < sortedNums.length; i++) {
////            sum += sortedNums[i];
////            count++;
////            if (sum >= target) {
////                return count; // 找到满足条件的子数组，退出循环
////            }
////        }
////        // 如果没有找到满足条件的子数组，返回 0
////        return 0;
//
//
//
//        // 老老实实用滑动窗口吧
//        // 首先这个 O(n*n) 是很容易想到的
//        // 老老实实用滑动窗口吧
//        // 首先这个 O(n*n) 是很容易想到的
//        // 我这个逻辑上是没有问题的，但他特喵的有个测试数据很长，直接超时了
//        int minCount = nums.length; // 最小子数组长度
//        boolean found = false; // 是否找到满足条件的子数组
//        for (int i = 0; i < nums.length; i++) {
//            int left = i; // 左边界
//            int right = nums.length; // 右边界
//            // 在这个循环里面逐渐缩小右边界，直到满足条件
//            for (int j = right; j >= left ; j--) {
//                if (isGreater(nums, target, left, j)) {
//                    // 如果满足条件，计算子数组的长度
//                    count = j - left + 1;
//                    if (count <= minCount) {
//                        minCount = count;
//                        found = true;
//                    }
//                }
//            }
//        }
//        if (!found) {
//            // 如果没有找到满足条件的子数组，返回 0
//            return 0;
//        }else {
//            // 返回最小子数组长度
//            return minCount;
//        }
//    }



    public int minSubArrayLen(int target, int[] nums) {
//        int result = Integer.MAX_VALUE; // 最小子数组长度
//        // 用滑动窗口来做
//        int left = 0; // 左边界
//        int right = 0; // 右边界
//        Boolean found = false; // 是否找到满足条件的子数组
//        // 思路，遍历从left到right的子数组，判断是否满足条件，
//
//        // 如果不满足条件，就右边界向右移动，直到满足条件
//        // 如果满足条件，就左边界向右移动，直到不满足条件
//
//        // 注意，这个right是一定要遍历到数组的末尾的，因为我们需要找到所有可能的子数组
//        for (; right < nums.length;) {
//            if (isGreater(nums, target, left, right)) {
//                found = true; // 找到满足条件的子数组
//                result = Math.min(result, right - left+ 1); // 更新最小子数组长度
//                left++;
//            } else {
//                // 如果当前窗口的和小于target，右边界向右移动
//                right++;
//            }
//        }
//        if (!found) {
//            // 如果没有找到满足条件的子数组，返回 0
//            return 0;
//        }
//        return result;

        // 我真佛了，这个还是超时了，估计判断isGreater的复杂度太高了，导致整体复杂度过高
        // 我们这里处理一个sum数组来记录一下就不用每次都从新算了

        int result = Integer.MAX_VALUE; // 最小子数组长度 // 注意这种情况，result的初始化一定不要给他赋值成0了，想想为什么
        // 用滑动窗口来做
        int left = 0; // 左边界
        int right = 0; // 右边界
        int sum = 0; // 当前窗口的和
        Boolean found = false; // 是否找到满足条件的子数组
        // 思路，遍历从left到right的子数组，判断是否满足条件，

        // 如果不满足条件，就右边界向右移动，直到满足条件
        // 如果满足条件，就左边界向右移动，直到不满足条件

        // 注意，这个right是一定要遍历到数组的末尾的，因为我们需要找到所有可能的子数组
        for (; right <= nums.length;) {
            sum += nums[right]; // 更新当前窗口的和
            while (sum >= target) { // 如果当前窗口的和大于等于target
                found = true; // 找到满足条件的子数组
                result = Math.min(result, right - left + 1); // 更新最小子数组长度
                sum -= nums[left]; // 左边界向右移动，更新当前窗口的和
                left++;
            }
            right++; // 右边界向右移动
        }
        if (!found) {
            // 如果没有找到满足条件的子数组，返回 0
            return 0;
        }
        return result;


        // 怎么改一下这段代码呢？这里 right是从0到 nums.length - 1 的
        // 但是里面if (sum < target) 的时候，right++ 了，这样就会导致下一次进这个sum判定时，实际上对应的字串是从 left 到 right - 1 的
        // 比如最后一进入循环时，right已经是len-1 了，即已经指向了数组的最后一个元素
        // 核心是，每次循环right指向的到底是什么？
        // 一开始，我们move是true，right指向的是0，right指向的是第一个元素
        // 然后sum即为第一个元素的值
        // 如果sum < target，那么right++，此时right指向的是第二个元素，并且move为true
        // 再到下一个循环里时，sum会先将第二个元素的值加到sum上
        // 比如此时sum大于target，left元素出去，同时left++，但move时false
        // 以此类推，right指向的元素是当前窗口的右边界元素，而不是下一个元素

        // 然后你看外循环的判断条件，right会指向len-1，也就是最后一个元素，直到下次right++，而下次right++只会发生于sum＜情况，遍历结束了，如果sum＞，left会一致++直到sum小于
//        // 这个比较丑，还是推荐采用循环里面是while的情况
//        boolean move = true; // 是否需要移动右边界
//        for (; right < nums.length;) {
//            if (move) {
//                sum += nums[right]; // 更新当前窗口的和
//            }
//            if (sum >= target) { // 如果当前窗口的和大于等于target
//                found = true; // 找到满足条件的子数组
//                result = Math.min(result, right - left); // 更新最小子数组长度
//                sum -= nums[left]; // 左边界向右移动，更新当前窗口的和
//                left++;
//                move = false; // 需要移动左边界，不需要移动右边界
//            } else  {
//                move = true; // 如果当前窗口的和小于target，右边界向右移动
//                right++; // 右边界向右移动
//            }
//        }
//        if (!found) {
//            // 如果没有找到满足条件的子数组，返回 0
//            return 0;
//        }
//        return result;



        // 滑动窗口还有个leetcode3，类似的，推荐都是采用两个while嵌套的方式，最外面的是大循环，里面的while表示 合法了，可以继续贪
        // 就比如这里 sum 大了，可以继续缩小，就是left++，
        // leetcode3 就是没有重复，可以继续增加，就是right++

    }



    static boolean isGreater(int[] nums, int target , int start, int end) {
        // 判断传入数组是否大于等于target
        int sum = 0;
        for (int i = start; i <= end && i< nums.length; i++) {
            sum += nums[i];
        }
        return sum >= target;
    }


}
