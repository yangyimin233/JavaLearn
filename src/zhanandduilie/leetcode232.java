package zhanandduilie;

public class leetcode232 {



//    请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
//
//    实现 MyQueue 类：
//
//    void push(int x) 将元素 x 推到队列的末尾
//    int pop() 从队列的开头移除并返回元素
//    int peek() 返回队列开头的元素
//    boolean empty() 如果队列为空，返回 true ；否则，返回 false

    class MyQueue {

        // 用两个栈来实现队列
        // 一个栈用来存入元素，另一个栈用来出队
        // 注意：栈是后进先出，队列是先进先出，所以需要在出队时将入队的栈中的元素全部倒入出队的栈中
        // 这里的栈可以用java.util.Stack来实现
        public java.util.Stack<Integer> stackin;
        public java.util.Stack<Integer> stackout;



        public MyQueue() {
            // 初始化队列
            stackin = new java.util.Stack<>(); // 用来存入元素
            stackout = new java.util.Stack<>(); // 用来出队
        }

        public void push(int x) {

            stackin.push(x);

        }

        public int pop() {
            // 注意这里pop出来是要把队列里面元素按照先进先出的顺序出，而stack里面栈只能后进先出，所以我们要先将stackin的全部pop进stackout，然后stackout再pop回stackin

            // 举个例子，比如队列里面现在是1, 2, 3, 4，要pop出来一个，则需要1出来
            // 这时候我们先把stackin里面的元素全部pop到stackout里面，顺序是4, 3, 2, 1
            // 然后再从stackout里面pop出来一个元素，这样就能保证先进先出的顺序了
            // stackout pop完了记得再把stackout的元素全部pop回stackin

            // 先把stackin的元素全部pop到stackout里面
            while (!stackin.isEmpty()) {
                stackout.push(stackin.pop());
            }
            // 现在stackout里面就是先进先出的顺序了
            int result = stackout.pop(); // 弹出队列开头的元素
            // 再把stackout的元素全部pop回stackin
            while (!stackout.isEmpty()) {
                stackin.push(stackout.pop());
            }
            return  result;
        }

        public int peek() {
            // 范围队列开头的元素，那跟pop的逻辑是一样的，只不过不pop掉而已
            while (!stackin.isEmpty()) {
                stackout.push(stackin.pop());
            }
            // 现在stackout里面就是先进先出的顺序了
            int result = stackout.pop(); // 队列开头的元素
            stackout.push(result); // 把队列开头的元素再放回去
            // 再把stackout的元素全部pop回stackin
            while (!stackout.isEmpty()) {
                stackin.push(stackout.pop());
            }
            return  result;
        }

        public boolean empty() {
            // 判断队列是否为空，只需要判断stackin是否为空即可
            return stackin.isEmpty();
        }
    }



}
