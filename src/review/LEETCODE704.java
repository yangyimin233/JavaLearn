package review;

public class LEETCODE704 {


    // 二分查找
    public int search(int[] nums, int target) {

        int left =  0;
        int right = nums.length - 1;


        // 然后是循环退出的条件，注意这里 是要取等的
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                // mid值大于target
                // 缩短右边界
                right = mid - 1;
                // 思考这里减一会不会漏？
                // 不会，因为nums[mid-1] 一定<= nums[mid]
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }


        }

        return -1;




    }



}
