package shuzhu;

public class leetcode27 {


//    给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
//    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
//    示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
//    示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
//    你不需要考虑数组中超出新长度后面的元素。

    public int removeElement(int[] nums, int val) {
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == val) {
//                for (int j = i + 1; j < n; j++) {
//                    nums[j - 1] = nums[j];
//                }
//                i--;
//                n--;
//            }
//        }
//        return n;

        // 注意这个最外层的退出循环条件，如果有元素被删去了，导致len 减小，实际上是，后面一整片被前移1，覆盖了i所在的元素
        // 但是最后一个元素是没有动的  比如 2 ，3 ，5，6 ，此时i在2的位置上 ，val = 2 ，则 变成了 3，5，6，6，实际len-1

        // 此外，这个复杂度是 O(n^2)，因为每次删除元素都需要移动后面的元素，所以时间复杂度是 O(n^2)。
        // 这里这个双指针法也是要去学习的
        // 先暂时留着吧

        // 双指针法 ,
        int fastindex = 0; // 快指针，遍历原本数组用的指针
        int slowindex = 0; // 慢指针，要放入的新数组指针
        int len = nums.length; // 数组长度

        for ( ; fastindex < nums.length; fastindex++) {
            if (nums[fastindex] != val) {
                // 这个数是合法的，可以放入新数组
                nums[slowindex] = nums[fastindex];
                slowindex++;
            } else {
                // 这个数是非法的，不放入新数组
                // 这里不需要做任何操作，因为慢指针不动，快指针继续往后走
                len--; // 这里len是为了最后返回新数组的长度
            }
        }
        return len; // 返回新数组的长度


    }




}
