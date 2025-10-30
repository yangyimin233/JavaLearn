package dq;

public class LEETCODE72 {

//    给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
//
//    你可以对一个单词进行如下三种操作：
//
//    插入一个字符
//            删除一个字符
//    替换一个字符


    // 呃呃呃呃

    public int minDistance(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        // 刚刚自己画了一下就明白了，这个是一个典型的动态规划问题
        // 定义dq[i][i] 表示word1的前i个字符转换成word2的前j个字符所需的最少操作数
        // 比如 word1 = abc word2 = ac
        // dq[2][2] 表示 ab 转换成 ac 所需的最少操作数
        // 我们最终的答案就是dq[len1][len2]

        // 然后初始化dp数组没得说，dq[0][j] = j , dq[i][0] = i ，前面表示空串str1 到 str2 插入j个字符，后面表示str1删除i个字符到空串str2
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1 ; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // 然后就是状态转移方程了
        // dp[i][j] 可以这样子想
        // 如果从dp[i-1][j] 推到到 dp[i][j]， dp[i-1][j] 表示的是 word1的前i-1个字符转换成word2的前j个字符所需的最少操作数，然后现在是要word1的前i个字符转换成word2的前j个字符，所以在这个基础上
        // 删去word1的第i个字符即可，所以操作数加1
        // 同理从dp[i][j-1] 推到到 dp[i][j]，  dp[i][j-1]表示的是word1的前i个已经跟这个word2的前j-1个一样了，这时候，只需要在word1后面插入word2的第j个字符即可，所以操作数加1
        // 然后是这个从dp[i-1][j-1] 推到 的dp [i][j]，这时候分两种情况，如果word1的第i个字符和word2的第j个字符相同，那么就不需要任何操作，直接等于dp[i-1][j-1]，如果不相同，那么就需要替换操作，所以操作数加1

        for (int i = 1; i <= len1 ; i++) {
            // 先从行开始嘛，一行一行从左往右转移
            for (int j = 0; j <= len2; j++) {

                // 实际上只需要从上面选出最小的就行
                int a,b,c;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 要注意这个 i 和 j 是从1开始的，而字符串的索引是从0开始的
                    a = dp[i - 1][j - 1];
                } else  {
                    // 不相同的话就需要替换操作
                    a = dp[i - 1][j - 1] + 1;
                }
                b = dp[i - 1][j] + 1; // 删除操作
                c = dp[i][j - 1] + 1; // 插入操作
                dp[i][j] = getMin(a,b,c);

            }



        }
        return dp[len1][len2];
    }

    public static int getMin(int a,int b , int c) {
        return Math.min(a, Math.min(b,c));
    }




}
