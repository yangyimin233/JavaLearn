package review;

public class LEETCODE27 {

    //    给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    //    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
    //    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

    public int removeElement(int[] nums, int val) {


        int fast = 0;
        int slow = 0;

        // 只要fast遍历完之前数组，就遍历完了
        // fast指针 遍历原数组，永远递增
        // slow指针 保存合法值，只有合法时候才递增
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;


    }



}
