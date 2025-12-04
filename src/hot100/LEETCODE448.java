package hot100;

import java.util.List;

public class LEETCODE448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 题目要求在 O(n) 时间复杂度和不使用额外空间的条件下完成
        // 这里不使用额外空间的意思是 除了返回结果的list之外 不允许使用额外的数组等数据结构
        // 那么我们可以利用数组本身来做标记
        // 具体思路是 遍历数组 对每个数nums[i] 我们将对应的索引位置nums[nums[i]-1]的值变为负数 来表示这个数出现过
        // 最后再遍历一遍数组 找出所有正数的位置 这些位置+1就是缺失的数字

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // 获取对应的索引位置
            if (nums[index] > 0) { // 如果该位置的值是正数，说明还没有被标记过
                nums[index] = -nums[index]; // 将其变为负数进行标记
            }
        }
        // 举个例子 ，比如nums 是 [4,3,2,7,8,2,3,1]
        // 第一个是 4 所以，我就把 nums[3] 变为负数
        // 第二个是 3 所以，我就把 nums[2] 变为负数
        // 依次类推，最后变成 [-4,-3,-2,-7,8,2,-3,-1]
        // 最后你再来看一遍数组，发现 nums[4] 和 nums[5] 还是正数，所以 5 和 6 就是缺失的数字
        // 相当于 是用index 来标记 数字是否出现过

        List<Integer> result = new java.util.ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { // 如果该位置的值仍然是正数，说明对应的数字(i+1)没有出现过
                result.add(i + 1);
            }
        }

        return result;
    }


}
