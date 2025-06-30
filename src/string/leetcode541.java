package string;

public class leetcode541 {

//    给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
//    如果剩余字符少于 k 个，则将剩余字符全部反转。
//    如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

//    示例 1：
//
//    输入：s = "abcdefg", k = 2
//    输出："bacdfeg"
//    输入：s = "abcd", k = 2
//    输出："bacd"


    public String reverseStr(String s, int k) {
        String result = "";
        int len = s.length();

        for (int i = 0; i < len ; i+= 2 * k) {
            // 取出当前的2k长度的子串
            String sub = s.substring(i, Math.min(i + 2 * k, len));
            // 如果子串长度小于k，直接反转
            if (sub.length() < k) {
                result += new StringBuilder(sub).reverse().toString();
            } else {
                // 如果子串长度大于等于k，反转前k个字符
                String firstPart = new StringBuilder(sub.substring(0, k)).reverse().toString();
                // 剩余部分不变
                String secondPart = sub.substring(k);
                result += firstPart + secondPart;
            }
        }

        return result;
    }



}
