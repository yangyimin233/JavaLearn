package hash;

import java.util.HashMap;

public class leetcode1 {

    // 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    // 现在我们需要采用哈希表的思想来解决这个问题


    public int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表，用于存储数组元素及其对应的索引
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        // 或者一开始就直接给他导入这个类 ， 就可以直接写这个HashMap<Integer, Integer>
        // 遍历数组，实际上是一边遍历一边存储元素和索引
        for (int i = 0; i < nums.length; i++) {
            // 计算当前元素需要的另一个元素
            int complement = target - nums[i];
            // 检查哈希表中是否存在这个元素
            if (map.containsKey(complement)) {
                // 如果存在，返回这两个元素的索引
                return new int[]{map.get(complement), i};
            }
            // 如果不存在，将当前元素及其索引存入哈希表
            map.put(nums[i], i); // 注意这里的put可能会覆盖之前的值，如果有重复的元素，后面的会覆盖前面的，但是没有问题，反正他只要返回一组就行了
        }
        return new int[0]; // 题目说的是一定有答案
    }



}
