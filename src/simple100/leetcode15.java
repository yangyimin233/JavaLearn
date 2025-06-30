package simple100;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class leetcode15 {

//    给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
//    注意：答案中不可以包含重复的三元组。


//    输入：nums = [-1,0,1,2,-1,-4]
//    输出：[[-1,-1,2],[-1,0,1]]
//    解释：
//    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//    不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//    注意，输出的顺序和三元组的顺序并不重要。

    public static void main(String[] args) {
        leetcode15 solution = new leetcode15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result); // 输出结果
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); // 这个list好奇怪？ 为什么不是List<int[]>呢？
        // 先对数组进行排序，因为这里只要求返回值，而不需要index
        java.util.Arrays.sort(nums);
        // 思路 是，先固定一个数，然后用双指针法来找另外两个数
        // 比如一开始 nums = [-4, -1, -1, 0, 1, 2]，我们固定-4，然后在剩下的数组中找另外两个数
        // 然后left指针指向-1，right指针指向2，三个求和等于0的情况是-4 + -1 + 2 = -3，这个意思是小了，i不动，让left大一点，所以left++，变成了-1
        // 核心是 1. 能不能遍历得到所有的三元组 2. 能不能去重
        // 比如我们固定i时，找到了一个left和right的组合，满足条件，此时进入下一轮i++的循环前，剩下的left和right会不会还有满足的组合？ -4 -2 0 4 6
        // 完全有可能啊，比如上面这个例子，所以这个循环退出的条件是 left >= right 或者 nums[i] > 0

        
        // 我看了代码随想录那个，实际上跟我这个写得是一模一样的嗷
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1; // 左指针，指向i的下一个元素
            int right = nums.length - 1; // 右指针，指向数组的最后一个元素
            // 这里的退出条件是 left >= right 或者 nums[i] > 0
            if (nums[i] > 0) {
                break; // 如果当前的数大于0，那么后面的数都大于0了，三数之和不可能等于0了，注意是break最外面的循环，因为之后不可能会有满足的三元组了
            }
            //  把这个去重仍外面来，这样while循环不用每次都判断了，但是要注意，这里不用break，而得用 continue ，遇到continue就会跳过当前的i，进入下一轮循环
            if (i > 0 && nums[i]== nums[i - 1] ) {
                // 如果当前的数和前一个数相同，说明已经处理过了，跳过这个数
                // 如果你不跳过这个i，如果上一次循环中的i已经找到了一个满足条件的三元组，那么这次循环中i又是这个数，left和right指针指向的数还是一样的，结果就会重复了
                // 注意这里的 i > 0 是为了防止数组越界
                continue;
            }
            while (left < right) {
                    if (nums[i] + nums[left] + nums[right] == 0) {
                        // 合法，存入结果集
                        List <Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        res.add(triplet);
                        // 这里结果合法后放进去了left和right指针的值，接下来需要移动指针
                        left++; // 左指针右移
                        right--; // 右指针左移

                        // 移动left指针，跳过重复的元素
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++; // 跳过重复的元素
                        }
                        // 移动right指针，跳过重复的元素
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--; // 跳过重复的元素
                        }

                    } else if (nums[i] + nums[left] + nums[right] > 0) {
                        right--; // 如果和大于0，说明右指针指向的数太大了，需要左移
                    } else {
                        left++; // 如果和小于0，说明左指针指向的数太小了，需要右移
                    }
            }
        }
        return res;
    }

}
