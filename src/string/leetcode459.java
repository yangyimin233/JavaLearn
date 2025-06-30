package string;

public class leetcode459 {

//    给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
//    示例 1:
//
//    输入: s = "abab"
//    输出: true
//    解释: 可由子串 "ab" 重复两次构成。
//    示例 2:
//
//    输入: s = "aba"
//    输出: false
//    示例 3:
//
//    输入: s = "abcabcabcabc"
//    输出: true
//    解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)


    public boolean repeatedSubstringPattern(String s) {

        // 直接用代码随想录的思路1来做吧
        // 如果str是由子串重复多次构成的，那么str+str去掉首尾字符后，仍然包含str

        String ss = s + s; // 将字符串s重复一次
        // 去掉首尾字符
        String sub = ss.substring(1, ss.length() - 1); // 去掉首尾字符
        if (sub.contains(s)){
            return true;
        }
        return false;



    }



}
