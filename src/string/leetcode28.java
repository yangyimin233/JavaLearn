package string;

public class leetcode28 {


//    实现 strStr() 函数。
//
//    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
//
//    示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
//
//    示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
//
//    说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。


//    给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
//
//    示例 1：
//
//    输入：haystack = "sadbutsad", needle = "sad"
//    输出：0
//    解释："sad" 在下标 0 和 6 处匹配。
//    第一个匹配项的下标是 0 ，所以返回 0 。
//    示例 2：
//
//    输入：haystack = "leetcode", needle = "leeto"
//    输出：-1
//    解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。


    public static void main(String[] args) {
        leetcode28 solution = new leetcode28();
        String haystack = "hello";
        String needle = "abab";
//        int result = solution.strStr(haystack, needle);

        int[] next = getNext(needle);

        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i] + " ");
        }
    }


    public int strStr(String haystack, String needle) {

        // 实际上就是实现一个kmp算法嘛，先不说这个kmp，我们先来个两层for暴力循环一下


//        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
//            // 每次从i开始，去匹配needle的每个字符
//            int temp = i; // 记录当前i的位置
//            int j = 0; // needle的索引
//            for (; j < needle.length(); j++) {
//                if (haystack.charAt(i) != needle.charAt(j)) {
//                    // 如果当前字符不匹配，直接跳出内层循环，i++，继续下一个字符
//                    break;
//                } else {
//                    // 如果当前字符匹配，继续比较下一个字符
//                    i++;
//                }
//            }
//
//            // 如果内层循环结束时，j等于needle的长度，说明找到了匹配项
//            if (j == needle.length()) {
//                // 说明找到了匹配项，返回当前i减去needle的长度
//                return temp; // 返回匹配项的起始位置
//            } else {
//                // 如果没有找到匹配项，i回到temp的位置，继续下一个字符
//                i = temp;
//            }
//        }
//        return -1; // 如果没有找到匹配项，返回-1

//        // 你这个暴力循环都写得不好看
//        // 那个代码随想录的写的还挺好看的

        // 现在我们来实现暴力循环
        // 我这样写就比较好看了
//        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
//            int a = i;
//            int j = 0; // 用于遍历needle的索引
//            // 每次遍历needle都是从0开始
//            while ( j<needle.length() && haystack.charAt(a) == needle.charAt(j)) {
//                a++;
//                j++;
//            }
//            if (j == needle.length()) {
//                return i; // 找到匹配项，返回起始位置
//            }
//
//        }
//        return -1;

        // 现在我们来实现KMP算法
        // 首先计算next数组
        int[] next = getNext(needle);
        int i = 0; // haystack的索引
        int j = 0; // needle的索引

        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                // 如果j为-1，或者当前字符匹配
                // 其中j == -1表示needle的第一个字符不匹配，i指向haystack的当前字符
                i++;
                j++;
            } else {
                j = next[j]; // 回溯到前一个字符的next值
            }
        }

        if (j == needle.length()) {
            return i - j; // 找到匹配项，返回起始位置
        } else {
            return -1; // 没有找到匹配项
        }



    }

    private static int[] getNext(String needle) {
        // 计算next数组
        int[] next = new int[needle.length()];
        next[0] = -1; // 第一个字符的next值为-1
        int j = 0; // j指向当前字符
        int k = -1; // k指向前一个字符的next值

        while (j < needle.length() - 1) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                j++;
                k++;
                next[j] = k; // 更新next数组
            } else {
                k = next[k]; // 回溯到前一个字符的next值
            }
        }
        return next;

    }


}
