package zhanandduilie;

import java.util.Queue;

public class leetcode225 {


//    请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
//
//    实现 MyStack 类：
//
//    void push(int x) 将元素 x 压入栈顶。
//    int pop() 移除并返回栈顶元素。
//    int top() 返回栈顶元素。
//    boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。


    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 false
        myStack.push(3);
        System.out.println(myStack.top()); // 返回 3
        System.out.println(myStack.pop()); // 返回 3
        System.out.println(myStack.empty()); // 返回 false
    }


    static class MyStack {

        // 先定义两个队列
        // 这里用java的LinkedList来实现队列
        // 注意这个java的队列工具类
        private Queue<Integer> queue1 = new java.util.LinkedList<>();
        private Queue<Integer> queue2 = new java.util.LinkedList<>();
        // 这里queue1是主队列，queue2是备份辅助的队列
        // 实际过程中，push操作会将元素添加到queue1中，而pop和top操作会使用queue2来辅助实现后入先出的特性。

        public MyStack() {
            // 构造函数，初始化两个队列
            // 这里不需要做什么，因为LinkedList已经初始化了
        }

        public void push(int x) {
            queue1.offer(x);
        }

        public int pop() {
            // 思路，先把queue1中的所有元素都放到queue2中，除了最后一个元素，然后再把最后一个元素弹出
            // 然后再把queue2中的所有元素放回queue1中
            // 举个例子，queue1中有1,2,3,4，这是要模拟栈的话，是需要pop 4的
            // 所以我们先把queue1中1，2，3都放到queue2中，然后再把4弹出
            // 然后再把queue2中的1，2，3放回queue1中

            while (queue1.size() > 1) {
                queue2.offer(queue1.poll()); // 将queue1中的元素全部放到queue2中，除了最后一个元素
            }
            int topElement = queue1.poll(); // 弹出最后一个元素，也就是栈顶元素
            // 现在queue1中已经没有元素了，queue2中有1，2，3
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll()); // 将queue2中的元素全部放回queue1中
            }
            return topElement; // 返回弹出的栈顶元素

        }

        public int top() {
            // 思路同pop，先把queue1中的所有元素都放到queue2中，除了最后一个元素，然后再把最后一个元素弹出
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll()); // 将queue1中的元素全部放到queue2中，除了最后一个元素
            }
            int topElement = queue1.poll(); // 弹出最后一个元素，也就是栈顶元素
            queue2.offer(topElement);
            // 现在queue1中已经没有元素了，queue2中有1，2，3
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll()); // 将queue2中的元素全部放回queue1中
            }
            return topElement; // 返回弹出的栈顶元素
        }

        public boolean empty() {
            return queue1.isEmpty(); // 如果queue1为空，则栈为空
        }
    }


}
