package string;

import java.util.HashSet;

public class leetcode14 {

//    编写一个函数来查找字符串数组中的最长公共前缀。
//
//    如果不存在公共前缀，返回空字符串 ""。
//
//
//
//    示例 1：
//
//    输入：strs = ["flower","flow","flight"]
//    输出："fl"
//    示例 2：
//
//    输入：strs = ["dog","racecar","car"]
//    输出：""
//    解释：输入不存在公共前缀。


    public static void main(String[] args) {

        String s="abcdefg";

        System.out.println(s+'C');
    }

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        // 最笨的思路嘛，先找到strs里面最短的str

        int minlen = Integer.MAX_VALUE; // 注意这个要选最小值，一开始我们要先给他设置一个大一点的值
        for (int i = 0; i < strs.length; i++) {
            minlen = Math.min(strs[i].length(), minlen);
        }
        // 然后遍历每个str的第i位看是否相同，相同就拼接，否则直接return
        // 这里来个hashset比较方便


        for (int j = 0; j < minlen; j++) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < strs.length; i++) {
                set.add(strs[i].charAt(j));
            }
            if (set.size() == 1) {
                // 说明该次循环字符前缀都一样
                // 然后随便取一个拼接到结果串里面
                result += strs[0].charAt(j);
            } else {
                // 说明不一样，直接returnre
                return  result;
            }
        }

        return  result;






    }



}
