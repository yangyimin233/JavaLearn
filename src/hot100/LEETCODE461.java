package hot100;

import java.sql.SQLOutput;

public class LEETCODE461 {

    public int hammingDistance(int x, int y) {

        int re = 0;

        // 汉明距离 就是 二进制不同的位数
        int xor = x ^ y;
        // 然后统计xor中1的个数
        while (xor != 0){

            // 取出xor的最低位
            re += xor & 1;
            // 向右移一位
            xor = xor >>> 1;

        }


        return re;

    }


    public static void main(String[] args) {
        int x = 2;
        int y = 4;
        int z = 7; // 0111
        // >>>  表示向右移位 （二进制），所以等效除2？
        System.out.println(x>>>1);
        System.out.println(z>>>1);
    }

}
