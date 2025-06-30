package simple100;

public class leetcode8 {

//    请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
//    函数 myAtoi(string s) 的算法如下：
//    空格：读入字符串并丢弃无用的前导空格（" "）
//    符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
//    转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
//    舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231 − 1 的整数应该被舍入为 231 − 1 。
//    返回整数作为最终结果。


    public static void main(String[] args) {
        String str = "   -42";
        System.out.println(str.trim());

        // 相当于靠擦字符串常用的函数charAt(int index)来获取字符串的字符

        String strtest = "AS测试FCDASCAV";
        System.out.println(strtest.charAt(3));




    }

    public int myAtoi(String s) {
        int result = 0;

        // 思路是，先去除前导空格，然后是检测符号，最后是数字位
        s = s.trim(); // 去除前导空格
        // 检查符号
        boolean flag = false; // 用于标记是否是负数
        int startIndex = 0; // 用于记录数字开始的位置
        if (s.length() == 0) {
            return 0; // 如果字符串为空，直接返回0
        }
        if (s.charAt(0) == '-') {
            flag = true; // 标记为负数
            startIndex = 1; // 数字从第二个字符开始
        } else if (s.charAt(0) == '+') {
            startIndex = 1; // 数字从第二个字符开始
        }
        // 处理数字部分
        for (int i = startIndex; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                break; // 如果不是数字，结束循环
            }
            int digit = c - '0'; // 将字符转换为数字
            // 检查是否会溢出
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE; // 溢出，返回对应的最大值或最小值
            }
            result = result * 10 + digit; // 更新结果
        }
        if (flag) {
            result = -result; // 如果是负数，转换结果为负
        }
        return result;
    }

}
