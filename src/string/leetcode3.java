package string;

import java.util.HashSet;
import java.util.IllegalFormatCodePointException;
import java.util.Set;

public class leetcode3 {

//    给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//
//
//
//    示例 1:
//
//    输入: s = "abcabcbb"
//    输出: 3
//    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//    示例 2:
//
//    输入: s = "bbbbb"
//    输出: 1
//    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//    示例 3:
//
//    输入: s = "pwwkew"
//    输出: 3
//    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//    请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

    public int lengthOfLongestSubstring(String s) {

        int result = 0;
        int left = 0;
        int right = 0;
        boolean found = false;
        Set<Character> charSet = new HashSet<>();
//        charSet.add(s.charAt(0));

        // 还是考虑 滑动窗口嘛
        // 一开始left和right都置为0
        // 循环退出条件是right 到达length
        // 思考这样，就退出，会不会漏掉一些情况？
        // 当right指向超出数组长度，说明此时left到right的已经是不重复的了，之后left右移得到的子串长度一定小于这个


        while (right < s.length()) {
            // 如果set里面不重复，则移动right并且更新长度
            // 但是这里会有一个问题就是right这样子就是当前窗口的右边一位了
            while(!charSet.contains(s.charAt(right))) {
                found = true;
                charSet.add(s.charAt(right));
                result = Math.max(result, right - left + 1);
                right++;
                // 这里right++后如果等于lenght，说明此次循环对应的right已经指向末尾了，可以直接return了
                if (right==s.length()){
//                    break;
                    return result;
                }
            }
            // 上面用while的话就是表示一直移动，直到出现重复的了，就让left右移，然后让left的出set
            charSet.remove(s.charAt(left));
            left++;
        }

        if (found){
            return  result;
        }
        return 0;

    }


}
