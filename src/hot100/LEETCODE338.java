package hot100;

import java.util.IllegalFormatCodePointException;

public class LEETCODE338 {



//    给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
//
//
//
//    示例 1：
//
//    输入：n = 2
//    输出：[0,1,1]
//    解释：
//            0 --> 0
//            1 --> 1
//            2 --> 10

    public int[] countBits(int n) {
        // 笨办法很容易想到
        // 每个都计算二进制位数
        // 一共的复杂度 是nlgn
        // 思考，能不能在一趟遍历里面就解决问题
        // 实际上，你写几个就能发现规律了
        // 若i是奇数， re[i] = re[i-1] +1
        // 若i是偶数，re[i] = re[i/2]
        // 所以这本质上就是一个动态规划的问题


        // 初始化 并且处理特殊情况
        if (n==0){
            int[] re = new int[1];
            re[0] = 0;
            return re;
        }
        if (n==1){
            int[] re = new int[2];
            re[0] = 0;
            re[1] = 1;
            return re;
        }

        int[] re = new int[n + 1];
        // 初始化
        re[0] = 0;
        re[1] = 1;

        for (int i = 2; i < re.length; i++) {

            if (i%2==0){
                re[i] = re[i/2];
            }  else {
                re[i] = re[i-1] + 1;
            }

        }
        return re;

    }


}
