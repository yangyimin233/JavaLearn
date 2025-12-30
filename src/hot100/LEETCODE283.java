package hot100;

public class LEETCODE283 {

//    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//    请注意 ，必须在不复制数组的情况下原地对数组进行操作。

    public void moveZeroes(int[] nums) {

        // 0 1 0 3 12
        // 1 3 12 0 0

        // 我的想法就是快慢指针，
        // 慢指针写入当前合法值(不为零的)
        // 快指针一直往前走，直到走到最后

        int slow = 0;
        int fast = 0;

        for (;fast < nums.length; fast++){
            // 快指针在外面直接走就行
            if (nums[fast] != 0) {
                // 当前快指针指向非零元素
                nums[slow] = nums[fast];
                slow++;
            }
        }

        // 然后再把剩下的全部填充0就可以了
        for (int i = slow; i < nums.length; i++){
            nums[i] = 0;
        }



    }


}
