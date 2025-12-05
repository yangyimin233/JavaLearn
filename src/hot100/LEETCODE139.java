package hot100;

import java.util.List;

public class LEETCODE139 {

//    给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
//
//    注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

    public boolean wordBreak(String s, List<String> wordDict) {
        // 还是用动态规划来做

        int len = s.length();
        boolean[] re = new boolean[len];

        // 定义一个re数组
        // re[i] 表示前 i + 1 个字符 能否由 字典构成

        // 初始化
        // 这个还真不太好说，理论上来说是 选出字典里面最短的所有元素
        // 依次去比较 s 前几个
        // 先全部置为false
        for (int i = 0; i < len; i++) {
            re[i] = false;
        }

        // re[i] 是true还是false？
        // 对于字典里面每个元素，存在一个word使得 re[i - word.len] 为ture ，且 后面那一截就等于word，则 re[i] 为true

        for (int i = 0; i < len; i++) {

            for (int j = 0; j < wordDict.size(); j++) {

                String word = wordDict.get(j);
                int wordLen = word.length();
                // 首先当前长度 比wordLen长 才允许看截断判断
                // 当前长度实际上是 i + 1

                // substring(a,b)
                // eg str = "ABCDE"
                // substring(2,4) = "CD"   左闭右开

                if (i + 1 >= wordLen) {
                    if ( i + 1== wordLen) {
                        // 说明当前 长度 跟要比较的word一致
                        // 比如 i = 2
                        // str = "ABCD"  即 要比较 ABC 跟word
                        if (s.substring(0, i + 1).equals(word)) {
                            re[i] = true;
                        }
                    } else {
                        // 说明 不是开始第一个了
                        // 比如这里 已经到re[4] , WORD 长度为2
                        // 应该比较的 是 0 1 2 3 4   中 re[4-2] 是否true，且 substr( i + 1 - wordlen, i+1)
                        if (re[i - wordLen] && s.substring(i + 1 - wordLen, i + 1).equals(word)) {
                            re[i] = true;
                        }

                    }

                }

            }
        }

        return re[len - 1];
    }


    public static void main(String[] args) {
        String s = "abcde";

        System.out.println(s.substring(0,4));
    }





}
