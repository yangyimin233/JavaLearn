package hot100;

import java.util.jar.JarEntry;

public class LEETCODE647 {


    // 求字符串中回文字串的个数
    // 这里先写简单的 暴力枚举法，时间复杂度高，但不要额外空间
    public int countSubstrings(String s) {

        // 核心思路很简单
        // 就是 从 第一个字符 开始一直枚举
        // 中心拓展
        // 如果 是奇数长度，中心i
        // 一开始left 和 right 都是i 然后向两边拓展并且判断 左右是否相等
        // 如果是 偶数长度，中心i
        // left = i ，rigth = i+i
        // 然后再循环

//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            // 奇数拓展
//            res += extend(s,i,i);
//            // 偶数拓展
//            res += extend(s,i,i+1);
//
//        }
//        return res;

        // 然后我们来做 dp 的，不过这个dp 实际上 优势不明显
        // 定义dp[i][j] 表示 i 到 j 字符串是否为回文字串

        // 我们默认i<=j
        int cnt = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        // 然后是初始化
        // 首先 所有的dp[i][j] 当i = j 时 dp[i][j] = true,cnt++
        // 然后是dp[i][j] 当j=i+1 且ij指向字符一样时， 为true ，cnt++
        // 剩下的情况 是 dp[i][j] = dp[i+1][j-1] && i j指向一样 ，cnt++

        // 然后，你需要注意，dp[i][j] 来自于 dp[i+1][j-1] 也就是左下方，
        // 所以我们的dp填充顺序 应该时对角线 往右上平移

        for (int x = 0; x < s.length(); x++) {

            // 这个x表示偏移量，一开始是0 也就是 i = j 的对角线
            // 然后第二次循环x = 1 也就是 j = i+1 ，然后i 从0开始 (0,1) (1,2) (2,3)
            // x = 2 也就是 j = i+2, (0,2) (1,3)

            // 内层j还是指针

            for (int j = 0; j + x < s.length(); j++) {

                // 指向dp [j][j+x]
                if(x == 0){
                    dp[j][j+x] = true;
                    cnt++;
                } else if(x==1 && s.charAt(j) == s.charAt(j+x)){
                    dp[j][j+x] = true;
                    cnt++;
                } else if(dp[j+1][j+x-1] && s.charAt(j) == s.charAt(j+x)){
                    dp[j][j+x] = true;
                    cnt++;
                }


            }

        }
        // dp做这个真不舒服，还是直接 枚举方便



        return cnt;


    }

    private int extend(String s, int left, int right) {

        // 判断 s 从left 到right往外半径拓展 有多少个回文子串
        int nums = 0;
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

            nums++;
            left--;
            right++;

        }
        return nums;
    }


}
