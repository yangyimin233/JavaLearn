package string;

import java.util.ArrayList;
import java.util.List;

public class leetcode151 {

//    给你一个字符串 s ，请你反转字符串中 单词 的顺序。
//    单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
//    返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
//    注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。

//    示例 1：
//
//    输入：s = "the sky is blue"
//    输出："blue is sky the"
//    示例 2：
//
//    输入：s = "  hello world  "
//    输出："world hello"
//    解释：反转后的字符串中不能存在前导空格和尾随空格。



    public String reverseWords(String s) {
        String result = "";
        String trimmed = s.trim(); // 去除前后空格



        // 先这样吧，反正也过了，之后再看看好的方法
        int end = trimmed.length() - 1;
        // 从末尾开始遍历字符串，没遍历到一个空格，就将前面的单词拼接到result中
        for (int i = end; i >=0 ; i--) {
            if (trimmed.charAt(i) == ' ') {
                // 找到空格，说明前面是一个单词
                String word = trimmed.substring(i + 1, end + 1); // 截取从i+1到end的子字符串
                if (!word.isEmpty()) { // 确保不是空字符串
                    result += word + " "; // 拼接到结果中，并加上空格
                }
                end = i - 1; // 更新end为当前空格的前一个位置
            }
            if (i == 0){
                // 如果i等于0，说明已经遍历到字符串的开头了
                String word = trimmed.substring(0, end + 1); // 截取从0到end的子字符串
                if (!word.isEmpty()) { // 确保不是空字符串
                    result += word; // 拼接到结果中，不加空格
                }
            }
        }
        return result;


    }


}
