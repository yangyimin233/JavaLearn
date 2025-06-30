package simple100;

public class leetcode5 {

    // 给你一个字符串 s，找到 s 中最长的 回文 子串。



    public String longestPalindrome(String s) {

        int maxlength = 0;
        int maxstart = 0;


        if (s == null || s.length() < 1) {
            return "";
        }
        // 思路 , 暴力法
        // 从第一个字符开始，遍历长度len的子串，判断是否是回文串


        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-i; j>=0; j--) {
                // 判断从i开始，长度为j的子串是否是回文串
                String sub = s.substring(i, i + j);
                if (isPalindrome(sub)){
                    if (sub.length() > maxlength) {
                        maxlength = sub.length();
                        maxstart = i;
                    }
                    break; // 找到最长的回文子串后，跳出内层循环
                }
            }
        }
        return s.substring(maxstart, maxstart + maxlength);
    }


    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
