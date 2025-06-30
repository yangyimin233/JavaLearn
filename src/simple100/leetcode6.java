package simple100;

import java.util.ArrayList;

public class leetcode6 {

//    将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
//    比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//
//    P   A   H   N
//    A P L S I I G
//    Y   I   R
//    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//
//    请你实现这个将字符串进行指定行数变换的函数

    public static void main(String[] args) {
//        leetcode6 solution = new leetcode6();
//        String s = "PAYPALISHIRING";
//        int numRows = 3;
//        System.out.println(solution.convert(s, numRows)); // 输出 "PAHNAPLSIIGYIR"

//         char[] str0 = {'A', 'B', 'C', 'D'};
//         char[] str1 = {' ', ' ', 'E', ' '};
//         char[] str2 = {' ', 'F', ' ', ' '};
//         char[] str3 = {'G', 'H', ' ', ' '};
//
//         // 二维数组感觉也挺合适的
//         char[][] strlist = {str0, str1, str2, str3};
//        System.out.println(henxiangprint(strlist)); // 输出 "AGBFHCED"

        int x = 11;
        int y = 4;
        // 计算x除以y的余数


        // 先计算一共有多少列
//        int col = 0;
//        // 计算s.length() 除以 2*numRows - 2 的余数 和 商
//        int yushu = x % (2 * y - 2);
//        int shang = x / (2 * y - 2);
//        // 如果余数为为0 到 numRows 之间，总列数为 shang + 1
//        if (yushu == 0) {
//            col = shang*(y - 1);
//        } else if (yushu <= y) {
//            // 如果余数小于等于numRows，那么总列数为 shang + 1
//            col = shang*(y -1) + 1;
//        } else {
//            // 如果余数大于numRows，
//            col = shang*(y -1) + (yushu - y + 1);
//        }

//        System.out.println(col);

        // System.out.println(x % y);
        // System.out.println((int) Math.ceil((double) x / y));
//        char [] test = new char[10];
//        System.out.println(test[4] == '\u0000'); // 输出 true，表示数组的第一个元素是默认值'\u0000'，即空字符
    }



    public String convert(String s, int numRows) {
        String result = "";

        // 每一列都是长度为numRows的字符串
        // 先计算一共有多少列
        int col = 0;
        // 计算s.length() 除以 2*numRows - 2 的余数 和 商
        int yushu = s.length() % (2 * numRows - 2);
        int shang = s.length() / (2 * numRows - 2);
        // 如果余数为为0 到 numRows 之间，总列数为 shang + 1
        if (yushu == 0) {
            col = shang*(numRows - 1);
        } else if (yushu <= numRows) {
            // 如果余数小于等于numRows，那么总列数为 shang + 1
            col = shang*(numRows -1) + 1;
        } else {
            // 如果余数大于numRows，
            col = shang*(numRows -1) + (yushu - numRows + 1);
        }



        char[][] zigzag = new char[numRows][col];
        // 然后就是往这个二维数组里面放值了
        // 我这个思路是肯定没问题的，估计再想想就能出了
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            // 类似于上面计算col的方式进行分组
            int yushu_2 = (i + 1) % (2 * numRows - 2);
            int shang_2 = (i + 1) / (2 * numRows - 2);
            // 如果余数为为0 到 numRows 之间，总列数为 shang + 1
            if (yushu_2 == 0) {
                // 说明 当前字符第shang_2*(numRows - 1) 列 ，且一定在第2行
                zigzag[1][shang_2 * (numRows - 1) - 1] = c;
            } else if (yushu_2 <= numRows) {
                int temp = (i+1) % numRows;

                // 说明 当前字符在第 yushu_2 行，且一定在第 shang_2 * (2 * numRows - 2) + temp列
                zigzag[yushu_2 - 1][shang_2 * (2 * numRows - 2)] = c;
            } else {
                // 否则说明当前字符在第numRows - yushu_2 + 2 行，且一定在第 shang_2 * (2 * numRows - 2) + yushu_2 - numRows + 1 列
                zigzag[numRows - yushu_2 + 1][shang_2 * (2 * numRows - 2) + yushu_2 - numRows] = c;
            }
        }
        return henxiangprint(zigzag);
    }

    static String henxiangprint(char[][] strlist) {
        String result = "";
        // 横向输出二维数组为字符串
        for (int i = 0; i < strlist[0].length; i++) {
            for (int j = 0; j < strlist.length ; j++ ) {
                if (strlist[j][i] != '\u0000') {
                    result += strlist[j][i];
                }
            }

        }
        return result;
    }


}
