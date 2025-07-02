package zhanandduilie;

import javax.print.DocFlavor;
import java.util.Deque;
import java.util.LinkedList;

public class leetcode239 {

//    给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//    返回 滑动窗口中的最大值 。

    public static void main(String[] args) {
        int[] nums = {2,3,5,78,2,1,-1,10,3};
        int k = 3;
        int[] re = maxSlidingWindow(nums, k);
        for (int i = 0; i < re.length; i++) {
            System.out.println(re[i]);
        }

    }

// 1 <= k <= nums.length




    static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();
        //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
        //同时判断队列当前是否为空
        void poll(int val) {
            // 如下面所示，只需要当队顶是要出的val时，才出队
            // 如果队列顶端元素不是val，说明之前add时的元素大于这个就已经被删除了
            if (!deque.isEmpty() && deque.peek() == val) {
                deque.poll();
            }
        }
        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        //保证队列元素单调递减
        //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }
        //队列队顶元素始终为最大值
        int peek() {
            return deque.peek();
        }
    }





    public static int[] maxSlidingWindow(int[] nums, int k) {
//        // 先来最笨的方法嘛
//        // 确定result长度
//        int[] result = new int[nums.length - k + 1];
//        // 注意从i是要求从几到几
//        for (int i = 0; i <= nums.length - k ; i++) {
//            result[i] = findmax(nums, i, i+k-1);
//        }
//        return  result;


        // 不出所料，直接超时了
        // 还是得老老实实用这个队列来处理
        // 他得核心思想是，将这个窗口模拟成一个队列
        // 滑动这个窗口，队列会出一个元素，同时队列也会进一个元素
        // 然后他想把这个出元素就直接设置成re进入re数组
        // 问题是这个队列得poll和add方法该怎么设计？


        // 自定义队列，需要实现一个myqueue
        // 假设原本数组是 3，7，1，4，6，1，9 然后k = 3
        // 那么一开始的队列是
        // 7 3 1
        // 对应第一个窗口 此时 直接取front作为最大值，弹出
        // 如果是优先级队列，你这时候poll出来的就是7，但是原本窗口里面应该要出队的是3
        // 所以这里的出队必须按照实际窗口的元素来出队，同时再将下一个窗口要滑进去的入队
        // 所以这里是3 出队，然后4进队
        // 对应此时队列 是7 4 1

        // 然后就是这个队列的顺序维护问题？我们有没有必要每次队列都完全排序？
        // 实际上是没有必要的
        // 我们只需要维护最大的是嘛？

        // 我们直接来看他这个出队进队的方法嗷.

//        void poll(int val) {
//            if (!deque.isEmpty() && val == deque.peek()) {
//                deque.poll();
//            }
//        }

          // 出队方法是：当且仅当 非空 且元素等于 队列 顶端时 出队

//        void add(int val) {
//            while (!deque.isEmpty() && val > deque.getLast()) {
//                deque.removeLast();
//            }
//            deque.add(val);
//        }

        // 入队方法：
        // 如果空，直接入队，否则将val插入至其能排到的最靠前的位置，然后删去后面

        // 比如队列时 5，3，1 此时val = 4 ，执行入队操作后 队列为 5，4
        // 想想为什么他敢删去比他小的？

        // 我举个例子，假设当前滑动窗口对应的是 5，3，1 要入队的元素为4，此时，只要4 在，那么3，1永远不会成为 4存在的窗口的最大值
        // 也就是说这个队列只维护 进入的元素 和 原本队列中 大于他的元素

        // 然后再回来看这个出队方法，你大致就能清楚为什么 元素还可能不存在了，因为可能没到其之前，就在入队的时候被删了
        // 再举个例子，原本数组为 6 4 2 3 5 4  而k=3
        // 然后一开始要add三个进去

        // 原始窗口    mydueqe     peek
        // 6 4 2      6 4 2       6
        // 4 2 3      4 3         4
        // 2 3 5      5           5
        // 3 4 5      5 4         5

        // 但是还是觉得直观上来说不是很好理解

        // 直接开始写吧
        // 先定义自己的mydueqe

        // 先初始化一些东西
        // result数组长度
        int resultlen = nums.length - k + 1;
        int[] res = new int[resultlen];
        // 然后他题设有 1 <= k <= nums.length
        // 所以先将前k个元素入队

        MyQueue myqueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            // 将数组前k个先入队得到初始数组
            myqueue.add(nums[i]);
        }
        // 取得初始窗口的最大值
        res[0] = myqueue.peek();
        // 然后 i 指向 k 从 k 开始执行入队 和 出队操作 取模拟那个滑动窗口，直到 i 指向最后的元素
        int num = 1; // 这个是结果数组的指针
        for (int i = k; i < nums.length; i++) {
            // 将 i 入队
            myqueue.add(nums[i]);
            // 将 i - k 的元素 出队
            myqueue.poll(nums[i - k]);
            // 获取窗口的最大值
            res[num] = myqueue.peek();
            num++;
        }

        return res;


    }

    // 来一个求数组区间的最大值的函数
    public static int findmax(int[]nums,int start ,int end){
        // 数组从start到end区间内的最大值，两边都包含
        int result = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            result = Math.max(result, nums[i]);
        }
        return  result;
    }





}
