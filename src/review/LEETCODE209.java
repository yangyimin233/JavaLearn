package review;

public class LEETCODE209 {


    //    给定一个含有 n 个正整数的数组和一个正整数 target 。
//    找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

//    输入：target = 7, nums = [2,3,1,2,4,3]
//    输出：2
//    解释：子数组 [4,3] 是该条件下的长度最小的子数组。

    public int minSubArrayLen(int target, int[] nums) {

        int result = 0;

        int sum = 0;
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        boolean found = false;

        // 动态区间什么时候移动停止即结束？
        // right到达最右边

        while (right < nums.length) {

//            // sum += nums[right];
//            while (sum < target && right < nums.length) {
//                sum += nums[right];
//                right ++;
//            }
//            // 退出上面这个while循环，说明要么right超了，要么sum可以了
//            if (sum >= target) {
//                // 合法了，记录当前长度并标记找到了
//                int length = right - left + 1;
//                min = Math.min(length, min);
//                found = true;
//                // 然后看能不能缩短
//                sum -= nums[left];
//                left ++;
//            }

            // 上面这么写不太对，你想嘛，你要找最小的长度，你这样 while sum小了就一直右移，然后每次再左移一个，可能会漏掉
            // 比如 1 ，0 ，0 ，10 ，10 ，99，100 target 为120 ，你这一开始right就会冲到最倒数第二个位置
            // 然后再出来一次，left右移后就小了，再移动一次就right++就退出了


            // 所以正确来说，应该是 每次 sum大了while 里面left++

            sum += nums[right];
            while (sum >= target) {
                // 合法了
                min = Math.min(min, right - left +1);
                found = true;
                // 缩短left
                sum -= nums[left];
                left++;
            }
            // 退出这个循环说明sum小了，right++
            right++;


        }

        if (found) {
            result = min;
        }
        return  result;
    }


}
