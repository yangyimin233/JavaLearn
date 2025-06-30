package hash;

import java.util.ArrayList;
import java.util.List;

public class leetcode18 {


//    给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//            0 <= a, b, c, d < n
//    a、b、c 和 d 互不相同
//    nums[a] + nums[b] + nums[c] + nums[d] == target
//    你可以按 任意顺序 返回答案 。



    public List<List<Integer>> fourSum(int[] nums, int target) {

        // 我还是先把三数之和的代码复制过来了
        List<List<Integer>> res = new ArrayList<List<Integer>>(); // 这个list好奇怪？ 为什么不是List<int[]>呢？
        // 先对数组进行排序，因为这里只要求返回值，而不需要index
        java.util.Arrays.sort(nums);
        // 思路 是，先固定两个个数，然后用双指针法来找另外两个个数

        for (int k = 0; k < nums.length; k++) {

            // 剪枝的操作可以先不管

            // 这里k也要去重，因为k是固定的数，如果k和前一个数相同，那么就会重复计算
            if (k > 0 && nums[k]== nums[k - 1] ) {
                // 如果当前的数和前一个数相同，说明已经处理过了，跳过这个数
                // 如果你不跳过这个i，如果上一次循环中的i已经找到了一个满足条件的三元组，那么这次循环中i又是这个数，left和right指针指向的数还是一样的，结果就会重复了
                // 注意这里的 i > 0 是为了防止数组越界
                continue;
            }


            for (int i = k + 1; i < nums.length; i++) {
                int left = i + 1; // 左指针，指向i的下一个元素
                int right = nums.length - 1; // 右指针，指向数组的最后一个元素

                // 这里剪枝的我们先不用管他
//                // 这里的退出条件是 left >= right 或者 nums[i] > 0
//                if (nums[i] > 0) {
//                    break; // 如果当前的数大于0，那么后面的数都大于0了，三数之和不可能等于0了，注意是break最外面的循环，因为之后不可能会有满足的三元组了
//                }

                //  把这个去重仍外面来，这样while循环不用每次都判断了，但是要注意，这里不用break，而得用 continue ，遇到continue就会跳过当前的i，进入下一轮循环
                if (i>k+1 &&nums[i]== nums[i - 1] ) {
                    // 如果当前的数和前一个数相同，说明已经处理过了，跳过这个数
                    // 如果你不跳过这个i，如果上一次循环中的i已经找到了一个满足条件的三元组，那么这次循环中i又是这个数，left和right指针指向的数还是一样的，结果就会重复了
                    // 注意这里的 i 是 大于k+1的，因为k是固定的数，i是从k+1开始的
                    continue;
                }
                while (left < right) {
                    // 那个测试例给我气笑了，感觉不是人类能想出来的
                    long sum = (long)nums[k] + (long)nums[i] + (long)nums[left] + (long)nums[right];
                    if (sum == target) {
                        // 合法，存入结果集
                        List <Integer> triplet = new ArrayList<>();
                        triplet.add(nums[k]);
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        res.add(triplet);
                        // 这里结果合法后放进去了left和right指针的值，接下来需要移动指针
                        // 移动left指针，跳过重复的元素
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++; // 跳过重复的元素
                        }
                        // 移动right指针，跳过重复的元素
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--; // 跳过重复的元素
                        }
                        left++; // 左指针右移
                        right--; // 右指针左移
                    } else if (sum > target) {
                        right--; // 如果和大于0，说明右指针指向的数太大了，需要左移
                    } else {
                        left++; // 如果和小于0，说明左指针指向的数太小了，需要右移
                    }
                }
            }

        }


        return res;
    }


    // 这个三数相加，四数相加，最难的地方是去重

    // 核心都是，先排序，然后固定一些列数，剩下两个取左left 和 右right
    // right和left的去重是在while里面完成的
    // 如果sum>target，就right--，如果sum<target，就left++，
    // 这时候是不需要去重复的，因为此时的left和right指向的数非法，也没有被存入结果集，所以不需要去重
    // 如果sum==target，就把结果存入res，
    // 然后如果left++ 和right--后，left和right指向的数和之前的数相同，就需要跳过这些重复的数

    // 然后是i和k的去重
    // i和k的去重是在for循环的开始处完成的
    // 如果当前的数和前一个数相同，说明已经处理过了，跳过这个数 nums[i] == nums[i - 1] 或者 nums[k] == nums[k - 1]
    // 此外为了避免k-1越界，k>0，i是里层循环的话，i > k + 1，反正都是为了排除第一个循环开始


}
