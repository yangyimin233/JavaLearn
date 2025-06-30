package string;

public class kama {
//    给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
//
//    例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
//
//    对于输入字符串 "a5b"，函数应该将其转换为 "anumberb"
//
//    输入：一个字符串 s,s 仅包含小写字母和数字字符。
//
//    输出：打印一个新的字符串，其中每个数字字符都被替换为了number
//
//    样例输入：a1b2c3
//
//    样例输出：anumberbnumbercnumber
//
//    数据范围：1 <= s.length < 10000。


    public static void main(String[] args) {

        String s1 = "ab3c78deaa";
        String re = "";
        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) - 'a'>=0 && s1.charAt(i) - 'z' <= 0) {
                // 如果是字母，直接添加到结果中
                re += s1.charAt(i);
            } else if (s1.charAt(i) - '0' >= 0 && s1.charAt(i) - '0' <= 9) {
                // 如果是数字，添加"number"到结果中
                re += "number";
            } else {
                // 如果是其他字符，可以根据需要处理，这里假设不处理
            }
        }
        System.out.println(re); // 输出结果

    }


}
