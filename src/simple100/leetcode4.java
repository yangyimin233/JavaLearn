package simple100;

import java.util.IllegalFormatCodePointException;

public class leetcode4 {
   // 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
   // 算法的时间复杂度应该为 O(log (m+n)) 。

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 9};
        int[] nums2 = {2, 2, 2, 6, 7};

        leetcode4 solution = new leetcode4();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));

    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;

        // 思路，先合并两个数组，然后再找到中位数
        // index1表示nums1的索引，index2表示nums2的索引
        int index1 = 0, index2 = 0;
        int[] merged = new int[nums1.length + nums2.length];
        // indexmerged表示合并后的数组的索引
        int indexMerged = 0;

        for (; indexMerged < merged.length; indexMerged++) {


            if (index1 >= nums1.length) {
                // 如果nums1已经遍历完了，直接将nums2的剩余元素添加到merged中
                merged[indexMerged] = nums2[index2];
                index2++;
                continue;
            }
            if (index2 >= nums2.length) {
                // 如果nums2已经遍历完了，直接将nums1的剩余元素添加到merged中
                merged[indexMerged] = nums1[index1];
                index1++;
                continue;
            }
            // 如果两个数组都没有遍历完，比较当前元素，将较小的元素添加到merged中
            // 注意这里的条件判断，index1 < nums1.length && index2 < nums2.length这个是保证还有没有遍历完的数组，只要有一个数组遍历完了，就不需要再比较了，只需要走上面的就行了
            if (nums1[index1] <= nums2[index2] && index1 < nums1.length && index2 < nums2.length) {
                merged[indexMerged] = nums1[index1];
                index1++;
            }  else if(index1 < nums1.length && index2 < nums2.length){
                merged[indexMerged] = nums2[index2];
                index2++;
            }

        }

        // 计算中位数
        if (merged.length % 2 == 0) {
            // 如果长度是偶数，中位数是中间两个数的平均值
            result = (merged[merged.length / 2 - 1] + merged[merged.length / 2]) / 2.0;
        } else {
            // 如果长度是奇数，中位数是中间的那个数
            result = merged[merged.length / 2];
        }

        return result;
    }

}
