package hot100;

import java.awt.font.FontRenderContext;

public class LEETCODE136 {

//    给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
//    你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。


    public int singleNumber(int[] nums) {

        // 感觉跟之前的那个摩尔投票有点类似，要求常数空间，一次遍历，然后数组构成 特点明显
        // 哈希肯定一下就解决了，问题是 需要o(n)空间

        // 看了别人的思路
        // 是位运算，气笑了
        int re = nums[0];
        for (int i = 1; i < nums.length; i++) {
            re^=nums[i];
        }
        return re;

    }


    public static void main(String[] args) {
        // 位运算 按位 亦或
        // A^B^C = C^B^A (交换结合)
        // A^A = 0
        // 0^C = C

        // 所以 4^2^2^1^4 = 4^4^2^2^1 = 0^0^1 = 1



        System.out.println(0^3);

    }


}
