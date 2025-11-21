package review;

public class LEETCODE541 {

//    给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
//    如果剩余字符少于 k 个，则将剩余字符全部反转。
//    如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

//    示例 1：
//
//    输入：s = "abcdefg", k = 2
//    输出："bacdfeg"
//    输入：s = "abcd", k = 2
//    输出："bacd"


    public static void main(String[] args) {

        String str = "HELL0";
        // substring 左闭右开的
        System.out.println(str.substring(0,2)); // HE

    }


    // 没问题嗷
    public String reverseStr(String s, int k) {
        String result = "";

        int len = s.length();
        // 每 2k一个循环
        for (int i = 0; i < len; i+=2*k) {

            // 取出前这里的前k位然后反转(当然也要判断长度是否够)
            // 注意substr是左闭合 右开放的

            // 然后要注意 最后一个2k可能是 长度不足k的
            String sb = s.substring(i, Math.min(i+k, len));
            // 反转sb
            result += new StringBuilder(sb).reverse().toString();

            // 然后把剩下的加入
            if (len > i+k){
                result += s.substring(i+k,Math.min(i+2*k,len));
            }
        }

        return result;
    }



}
