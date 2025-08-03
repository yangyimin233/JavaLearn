package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LEETCODE349 {


    // 求数组交集

    public int[] intersection(int[] nums1, int[] nums2) {


//        // 我现在思路是建立一个遍历nums1 ，同时放入一个hashset中，然后遍历nums2，如果存在于set中就加入一个结果集合中
//        ArrayList<Integer> list = new ArrayList<>();
//        HashSet<Integer> set = new HashSet<>();
//
//        for (int i = 0; i < nums1.length; i++) {
//            set.add(nums1[i]);
//        }
//        // 这个set里面是不重复的元素


        // 先来暴力方法
        // 遍历 一个 数组中的元素，同时 再遍历 第二个，看如果该元素 存在 于第一个数组，就加入到结果集中
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 先把nums排序，可以对nums去重

        for (int i = 0; i < nums1.length; i++) {
            if (i > 0 && nums1[i] == nums1[i - 1]) {
                // 说明元素与前一个重复，直接跳过
                continue;
            }

            for (int j = 0; j < nums2.length; j++) {

                // 这里还可以剪纸一下
                if (nums2[j] > nums1[i]) {
                    break;
                }


                if (j > 0 && nums2[j] == nums2[j - 1]) {
                    // 元素与前一个重复，跳过
                    continue;
                }
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                }
            }


        }

        int len =  list.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = list.get(i);
        }
        return res;





    }



}
