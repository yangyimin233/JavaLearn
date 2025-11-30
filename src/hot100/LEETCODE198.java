package hot100;

import java.util.IllegalFormatCodePointException;

public class LEETCODE198 {

//    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
//    给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

//    输入：[1,2,3,1]
//    输出：4
//    解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//    偷窃到的最高金额 = 1 + 3 = 4 。

    public int rob(int[] nums) {


        // 直接看的别人的思路
        // 还是考虑动态规划来做

        int len = nums.length;
        // gain[i] 表示 仅考虑 前 i 间房屋，能获得的最大偷窃金额
        int gain[] = new int[len];

        // 初始化
        gain[0] = nums[0];
        if (len == 1){
            return gain[0];
        }

        // 思考gain[i] 与gain[i之前的关系]？
        // 如果当前房间不偷，则 gain[i] = gain[i-1]
        // 如果当前房间要偷
        // 注意，偷了当前房间，就不能偷前一个房间，所以应该是基于 前i-2个房间的最大值来
        // 则gain[i] = gain[i-2] + nums[i]

        // 所以这里初始化还得顺带初始 gain[1]
        gain[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < len ; i++) {
            gain[i] = Math.max(gain[i - 1], gain[i - 2] + nums[i]);
        }

        return gain[len - 1];
    }




}
