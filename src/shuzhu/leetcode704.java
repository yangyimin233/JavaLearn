package shuzhu;

public class leetcode704 {


//    给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
//
//    你必须编写一个具有 O(log n) 时间复杂度的算法。

    public static void main(String[] args) {
        leetcode704 solution = new leetcode704();
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        System.out.println(solution.search(nums, target)); //
    }



        public int search(int[] nums, int target) {

            // 直接遍历不用说，这个复杂度是 o(n)，不符合要求

            // 二分查找，复杂度是 o(log n)
            // 但是这个可能需要考虑数组长度是奇数还是偶数
            // 如果是奇数，那么中间的元素就是中间值
            // 如果是偶数，那么中间的元素是 nums.length / 2 - 1 和 nums.length / 2 的平均值

            // 难点就是 判断退出循环的时机，要防止死循环

//            int left = 0;
//            int right = nums.length - 1;
//            if (nums.length == 0) {
//                return -1; // 如果数组为空，直接返回 -1
//            }
//
//            if (nums[right] == target) {
//                return right; // 如果右边的元素就是目标值，直接返回索引
//            }
//            if (nums[left] == target) {
//                return left; // 如果左边的元素就是目标值，直接返回索引
//            }
//
//            while (left < right -1) {
//                int mid = left + (right - left) / 2; // 防止溢出
//                if (nums[right] == target) {
//                    return right; // 如果右边的元素就是目标值，直接返回索引
//                }
//                if (nums[left] == target) {
//                    return left; // 如果左边的元素就是目标值，直接返回索引
//                }
//                if (nums[mid] == target) {
//                    return mid; // 找到目标值，返回索引
//                } else if (nums[mid] < target) {
//                    left = mid; // 目标值在右半部分
//                } else {
//                    right = mid; // 目标值在左半部分
//                }
//            }
//            // 如果没有找到目标值，返回 -1
//            return -1;




            // 你这个写得太丑了，代码太长了，逻辑太复杂了

            int left = 0;
            int right = nums.length - 1;

            // 你不需要去管数组的长度是奇数还是偶数，直接用二分查找就行了
            // 如果是偶数，mid会取到中间的左边那个元素，判断的时候num[mid] > target 就说明target只能在右边，且不包含mid ，所以 right 赋值为 mid - 1
            // 如果num[mid] < target 就说明target只能在右边，且不包含mid，所以 left 赋值为 mid + 1
            // 然后 while循环的条件是 left <= right，这样就可以保证不会死循环
            // 因为假设只有left 就在 right 的左边 ，此时mid = left ，下一步mid 如果不等于 target，要么right -1 ，要么left + 1，此时左右相等 ，如果还没有找到target，下一次一定退出循环
            // 然后再来考虑mid +1 或者 -1 会不会超出边界
            // 如果一开始数组长度为0，那么 left = 0, right = -1，此时 left > right，直接退出循环，返回 -1
            // 如果一开始数组长度为1，那么 left = 0, right = 0，此时 left == right，直接判断 nums[0] 是否等于 target，如果等于就返回 0，否则返回 -1

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1; // 目标值在右半部分
                } else {
                    right = mid - 1; // 目标值在左半部分
                }
            }
            return -1;



        }


}
