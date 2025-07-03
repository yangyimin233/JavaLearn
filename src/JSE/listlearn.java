package JSE;

import java.util.*;

public class listlearn {

    // 这个类来学一下list相关的

//    在 Java 中，List 是一个接口，定义了有序、可重复元素的集合的行为规范，比如：
//    按索引插入、删除、访问元素；
//    允许元素重复；
//    维持元素插入顺序。


//    它的定义在 java.util 包里：
//    public interface List<E> extends Collection<E> {
//        // 定义了add、get、remove、size等核心方法
//    }

//    其中最常用的是arraylist，linklist
    // 这两种核心都是表示一种可变长度的容器
    // 但是底层实现不太一样，arraylist是用动态数组实现的
    // linklist是用链表实现的
    // 所以第一个适合随机访问，第二个适合在某个地方执行插入或者删除操作


//    因为 ArrayList 和 LinkedList 都实现了 List 接口，所以：
//    List 接口里定义的所有方法，比如 add(), remove(), get(), set(), size() 等，这两个实现类都必须提供。
//    你可以通过 List 接口的引用来使用它们的共有方法：

//    List<String> list = new ArrayList<>();
//    list.add("A");
//    list.add("B");
//    list.remove(0);

    // 上面这种写法就是典型的 用一个实现类 去 实例化了 对应的接口，然后我直接 调用接口里面的方法，本质是在调用 其 实现类的方法
    // 同理，我也可以用 Linklist<>（）去实例化，此时 调用的 list接口方法就是 这个linklist实现类里面实现的方法

    // 原理上来说，他们都需要实现接口里面的方法，功能也得大致一样，但具体的实现逻辑和过程肯定是不一样的


public static void main(String[] args) {


    //    扩展：实现类可以增加自己独有的方法
//    虽然通过 List 接口引用你只能访问接口定义的方法，但有些实现类会扩展一些 专有方法，它们不是 List 接口里定义的，比如：
//
//    LinkedList 还实现了 Deque 接口，因此它有：
//    addFirst(), addLast(), pollFirst(), pollLast() 等双端队列方法。

    // List<String> list = new LinkedList<>();
    // list.addFirst(...)   // ❌ 编译错误：List 接口中没有这个方法

//    LinkedList<String> mylinkedList = new LinkedList<>();
//    mylinkedList.addFirst("X");  // addFirst 是LinkedList类中自己的方法，必须得用本身类实例化后才能调用

//    // 以ArrayList为例，这里演示演示ArrayList的常用操作
//    List<Integer> listdemo = new ArrayList<>();
//
//    // 这里再度说明了，你用ArrayList也行，用LinkedList也行，取决于你具体的需要
//    // 反正他们都实现了list接口的功能，这些功能最终效果肯定是一样的
//    // List<Integer> listdemo = new LinkedList<>();
//
//
//    // 基本的增删查改方法;
//
//    // 增加不用说
//    listdemo.add(1);
//    listdemo.add(2);
//    listdemo.add(3);
//    // 然后是删
//    // 删除index 对应的元素
//    listdemo.remove(1);
//
//    // 遍历，这种java中也是最常用的方式，采用增强的for循环
//    for ( Integer x : listdemo ) {
//        System.out.println(x);
//    }
//    // 这种一般的for也行，但是需要调用get方法
//    System.out.println("---------------- 普通for循环");
//    for (int i = 0; i < listdemo.size(); i++) {
//        System.out.println("第" + (i+1) + "个元素: " + listdemo.get(i));
//    }
//
//    // 查，的话那肯定就是get方法
//    // 比如这里查询最后一个元素
//    // 这里get也是index，从0 开始的，跟数组是一样的
//    System.out.println("---------------- 查询最后一个元素");
//    System.out.println(listdemo.get(listdemo.size()-1));
//
//    // 改
//    System.out.println("---------------- 改元素");  // 比如这里将最后一个元素改为5
//    listdemo.set(listdemo.size()-1, 5);
//    System.out.println(listdemo.get(listdemo.size()-1));


    // 这里也顺便说说java的栈和队列吧，因为这个我发现用的也挺多的

//    // 传统栈（老旧，不推荐）
//    Stack<Integer> stack = new Stack<>();
//    stack.push(1);
//    stack.push(2);
//    System.out.println(stack.pop());


    // 推荐做法：用 Deque 模拟栈
    Deque<Integer> stack2 = new ArrayDeque<>();
    stack2.push(1);
    stack2.push(2);
    System.out.println(stack2.pop());
    // 2 -> 1   2出栈
    // 欸这里你肯定就发现了，这个不是名字队列？
    // 实际上这个是一个双端队列
    // 假设 队首在左 ， 队尾在 右
    // push方法 是 元素从 左进队，pop 方法 是元素从 左出队  组合起来就是栈
    // 而 poll 也是从 左出队 基本跟pop是一样的 ，小区别在于空的时候这个返回null ，不会抛异常

    // offer 方法 是元素 从右进队
    // push 搭配 pop/poll 使用 就是 栈
    // 所以 offer搭配 pop/poll使用 就是 队列

    // 比如此时上面这时候 队列里面只有一个1了
    stack2.offer(5);
    // 1->5   5从右进队
    stack2.push(3);
    // 3->1->5  3从左进队
    stack2.push(4);
    // 4->3->1->5  4从左进队
    System.out.println("-----------输出应该是4 3 1 5 null");
    System.out.println(stack2.poll());
    System.out.println(stack2.poll());
    System.out.println(stack2.poll());
    System.out.println(stack2.poll());
    System.out.println(stack2.poll());




}







}
