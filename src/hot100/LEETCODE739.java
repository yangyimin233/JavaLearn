package hot100;

import javax.print.DocFlavor;
import java.util.Stack;

public class LEETCODE739 {


    // 相对温度
//    输入: temperatures = [73,74,75,71,69,72,76,73]
//    输出: [1,1,4,2,1,1,0,0]



    public int[] dailyTemperatures(int[] temperatures) {

        int len = temperatures.length;
        int[] re =  new int[len];
//
//        // 笨办法每个都遍历，应该没有问题
//
//        // 如果双指针的话，slow是能确保o(n)走完，但是fast会多次比较，总体复杂度也不低，先写了再说嘛
//        for (int slow = 0; slow < len; slow++) {
//
//            // 快指针每次从 slow 后面一个位置开始
//            int fast = slow + 1;
//            while ((fast < len) && temperatures[fast] <= temperatures[slow]) {
//                fast++;
//            }
//            // 退出while的位置,
//            if (fast < len) {
//                // 说明在到达底部之前，已经找到了大于slow位置的第一个值
//                re[slow] = fast-slow;
//            } else {
//                re[slow] = 0;
//            }
//
//        }
//
//        return re;
//
//        // 呃呃超时了，实际上这就是老老实实遍历了一遍



        // 用单调栈来维护
        Stack<Integer> stack = new Stack<>();
        // 这个栈里面存的是天数，且特点为 递减，也就是当前 入栈天数对应的温度一定要小于 栈顶
        // 如果大于了栈顶，说明找到了最近的 高温天气，就弹出当前栈顶

        // 保证i次内循环完
        for (int i = 0; i < len; i++) {

            // 先要判断 什么时候才能入栈，不满足时候要让i一直++
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                // 此时找到了温度大于栈顶天数的
                // 然后标记栈顶天数的结果
                int peak = stack.pop();
                re[peak] = re[peak] = i - peak;
            }
            // 退出while 说明 栈空了，或者 当前天数 i 对应的温度 小于栈顶天数对应的温度
            // i入栈
            stack.push(i);

        }


        // 实际上这个填结果数组re 不是按顺序填的，这一点上才能有 o(n)的复杂度
        // 此外java数组一开始默认全是0
        return re;




    }



}
