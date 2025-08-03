package review;

public class LEETCODE7 {


    public static void main(String[] args) {


        int x = 32;
        System.out.println(reverse(x));


    }



    //    //整数反转
    public static int reverse(int x) {

        // 比如给你一个123，你要给他反转成321
        boolean flag = false; // 标记正负
        int result = 0;

        if (x < 0) {
            flag = true; // 负数
            x = -x;
        }

        while (x != 0) {
            // 获取当前最后一位
            int temp = x % 10;
            result *= 10;
            result += temp;
            // x往前缩一位
            x = x / 10;
        }

        if(flag){
            return -result;
        }
        return result;






    }




}
