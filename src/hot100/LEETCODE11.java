package hot100;

public class LEETCODE11 {

//    给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
//    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//    返回容器可以储存的最大水量。

    public int maxArea(int[] height) {

//        int re = 0;
//        // i和j 作为边界 构成的容器，能存的水 量 ： (j-i)* min(i,j)
//        // 所以 o(n^2) 暴力肯定没问题的
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                re = Math.max(re,Math.min(height[i], height[j]) * (j - i));
//            }
//        }
//        return re;


        // 双指针？
        int re = 0;

        // 直接看的 别人思路
        // 双指针，一开始指向两边
        int left = 0, right = height.length - 1;
        // 循环计算当前双指针 构成 的区域 村水量
        // 问题是 移动怎么移动？
        // 指针只能向中间移动
        // 只有移动两边矮的位置 向内，才可能获得更大 的存水量
        // 你想，你把大的移动了，存水高度不变还是原来矮的，但是 长度变小了，所以肯定不会获得更大的存水量
        // 然后你想想，为什么说，指针相遇了，re一定是最大的

        // 最大的一定 是left，right 区间内某两端构成的

        while (left < right) {

            re = Math.max(re,Math.min(height[left], height[right]) * (right - left));

            // 然后是移动指针
            if (height[left] < height[right]) {
                // 左边矮一点
                left++;
            } else if (height[left] > height[right]) {
                // 右边矮一点
                right--;
            }  else {
                // 两边一样高
                left++;
                right--;
            }

        }
        return re;





    }

}
