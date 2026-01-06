package hot100;

import java.awt.font.FontRenderContext;

public class LEETCODE70 {

//    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？


    public int climbStairs(int n) {

        // 比如n = 2，两阶，可以 1+1 = 2 或者 2 =2
        // n=3 可以 1+1+1 = 3 ，1+2 =3  ， 2+1 = 3
        // n = 4 怎么考虑？
        // 考虑为？ 你要爬到4阶，会不会踩上 3 阶？ 如果你的倒数第二步在 踩在了 3上，这时候 走一步就到 4
        // 如果你倒数第二部踩在 2上，这时候走2 就到4
        // 所以理论上来说 n = 4 总数应该是 n=3 + n=2 的情况
        // 1 1 2  ，2 2
        // 1 1 1 1 ，1 2 1，2 1 1

        int res[] = new int[n+1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // 初始化
        res[2] = 2;
        res[1] = 1;

        for (int i = 3; i <= n ; i++) {
            res[i] = res[i-1] + res[i-2];
        }

        return res[n];


    }





}
