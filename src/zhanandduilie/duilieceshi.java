package zhanandduilie;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class duilieceshi {

    // 这里来学一下队列的基础相关

    public static void main(String[] args) {

        // 先看看这个队列，用Linkedlist这个实现的？
        Deque<Integer> deque = new LinkedList<>();

        deque.add(5);
        deque.add(2);
        deque.add(3);

        // 遍历队列
        System.out.println("---------------遍历测试");
        // 集合方式遍历，元素不会被移除
        for (Integer x : deque) {
            System.out.println(x);
        }


//        //队列方式遍历，元素逐个被移除
//        while (deque.peek() != null) {
//            System.out.println(deque.poll());
//        }

        // 一般还是采用这种增强for循环的方式遍历



        // 弹出方法
        System.out.println("---------------弹出测试");
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        // 这个pop和poll有什么区别？
//        pop 方法:

//        是 Deque 接口中的方法。
//        如果队列为空，会抛出 NoSuchElementException 异常。
//        等价于 removeFirst()，用于移除并返回队列的第一个元素。
//        poll 方法:

//        是 Queue 接口中的方法。
//        如果队列为空，会返回 null，而不会抛出异常。
//        用于移除并返回队列的第一个元素。

        // 基本没区别，安全和可操作性来说，推荐使用poll

        // 入队方法
        System.out.println("---------------入队测试");
//        System.out.println();
        deque.add(4);
        deque.add(5);
        for (Integer x : deque) {
            System.out.println(x);
        }

        // 其他方法简单过一下
        System.out.println("---------------其他测试");
        deque.removeLast();
        for (Integer x : deque) {
            System.out.println(x);
        }

        // 然后是看看这个优先级队列的操作
        System.out.println("--------------优先级队列");
        // 这个初始化方式有点意思哈
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        pq.add(5);
        pq.add(21);
        pq.add(3);

        // 哦哦队列一般是用的offer和poll方法
        pq.offer(4);

//        for (Integer x : pq) {
//            System.out.println(x);
//        }
//        // 这里输出为 3 21 5    ，很奇怪对吧，这里为什么不是 3 5 21呢？
        // 这是因为这个底层应该使用小顶堆来实现的
        // 你看看这个poll 出来的顺序肯定是 没问题的

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        // 输出 3 5 21





    }


}
