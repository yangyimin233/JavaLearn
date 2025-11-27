package hot100;

import java.util.IllegalFormatCodePointException;

public class LEETCODE169 {

//    给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    public int majorityElement(int[] nums) {

        // 主要是他要求 o(n)时间复杂度 和 o(1)空间复杂度
        // 用map肯定可以o(n)解决，但是需要开额外的空间
        // 然后你排序 可以有 不开空间的 算法，但是时间复杂度不行

        // 看来题解，很巧妙，摩尔投票
        // 只维护 tempmax 和tempmaxnum
        // 如果当前num跟tempmax 一样，则其票数++ 否则 票数--
        // 最终剩下的一个最多的

        int len =  nums.length;
        int tempmax = nums[0];
        int tempmaxnum = 1;
        for (int i = 1; i < len; i++) {

            if (tempmaxnum == 0) {
                // 该元素直接为候选元素
                tempmax = nums[i];
                tempmaxnum = 1;
            } else {
                // 否则要进行投票
                if (tempmax == nums[i]) {
                    tempmaxnum++;
                }  else {
                    tempmaxnum--;
                }
            }


        }

        return tempmax;
    }


}
