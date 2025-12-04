package hot100;

import java.util.Arrays;
import java.util.List;

public class LEETCODE438 {

    public List<Integer> findAnagrams(String s, String p) {

        // 找出所有字母异位词的起始索引。字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
        // 什么叫字母异位词？ 就是两个字符串中字母出现的频率相同，但是顺序可以不同
        // 比如 "abc" 和 "bca" 就是字母异位词

        // 首先，肯定是用滑动窗口来做
        int left = 0;
        int right = left + p.length() - 1 ;
        // 比如 p 长度是3，那么 right 2 ，窗口为 left 到 right 包含3个字符


        // 结果集
        List<Integer> res = new java.util.ArrayList<>();
        int[] pCount = new int[26]; // 统计 p 中每个字母出现的频率
        int[] sCount = new int[26]; // 统计当前窗口内每个字母出现的频率

        // 先统计 p 中每个字母出现的频率
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }

        if(right>=s.length()){
            return res;
        }

        // 初始化窗口内的字母频率
        for (int i = left; i <= right ; i++) {
            sCount[s.charAt(i) - 'a']++;
        }


        // 什么时候停止移动窗口？
        // right 指向最后一个字符的后一个位置时候(即 right == s.length() )
        // 否则，窗口向前滑动
        while (right < s.length()) {
            // 判断当前窗口内的字符串是否是 p 的字母异位词
            // 判断字母异位词的方法是，统计两个字符串中字母出现的频率是否相同
            // 也就是统计 每个字母出现的次数
            // 题干说了，字符串只包含小写英文字母，所以可以用一个长度为26的数组来统计


            // 我擦，注意这个数组比较，不能直接 用 nums.equals (这个也是比较的引用)，得用 Arrays.equals 来比较两个数组是否相等
            if (Arrays.equals(sCount, pCount)) {
                // 如果相同，说明是字母异位词，记录下起始索引
                res.add(left);
            }

            // 滑动窗口
            right++;
            left++;
            // 并且维护 sCount 数组
            if (right < s.length()) {
                // 增加新进入窗口的字符频率
                sCount[s.charAt(right) - 'a']++;
                // 减少离开窗口的字符频率
                sCount[s.charAt(left - 1) - 'a']--;
            }

        }

        return res;


    }



}
