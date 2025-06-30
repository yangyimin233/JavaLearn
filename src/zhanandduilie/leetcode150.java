package zhanandduilie;

public class leetcode150 {


//    给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
//
//    请你计算该表达式。返回一个表示表达式值的整数。
//
//    注意：
//
//    有效的算符为 '+'、'-'、'*' 和 '/' 。
//    每个操作数（运算对象）都可以是一个整数或者另一个表达式。
//    两个整数之间的除法总是 向零截断 。
//    表达式中不含除零运算。
//    输入是一个根据逆波兰表示法表示的算术表达式。
//    答案及所有中间计算结果可以用 32 位 整数表示。


    public int evalRPN(String[] tokens) {

        // 还是利用栈来做，遍历元素入栈，如果遇到运算符，就出栈两个元素进行运算，然后将结果入栈，最后栈中只剩一个元素就是结果
        // 他说这个入口是一个字符串数组是合法的波兰表示法
        // 所以遍历整个数组后，最终栈中只会剩下一个元素，这个元素就是结果
        // 此外遍历时，遇到运算符，前面也一定有两个操作数，所以可以直接出栈两个元素进行运算
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("+")) {
                // 取前两个栈里元素，相加再入栈
                int b = stack.pop(); // 弹出栈顶元素
                int a = stack.pop(); // 弹出次顶元素
                stack.push(a + b); // 将结果入栈
            } else if (tokens[i].equals("-")) {
                int b = stack.pop(); // 弹出栈顶元素
                int a = stack.pop(); // 弹出次顶元素
                stack.push(a - b); // 将结果入栈
            } else if (tokens[i].equals("*")) {
                int b = stack.pop(); // 弹出栈顶元素
                int a = stack.pop(); // 弹出次顶元素
                stack.push(a * b); // 将结果入栈
            } else if (tokens[i].equals("/")) {
                int b = stack.pop(); // 弹出栈顶元素
                int a = stack.pop(); // 弹出次顶元素
                stack.push(a / b); // 将结果入栈
            } else {
                // 如果是数字，就将其转换为整数并入栈
                // 注意这里要转int哦
                stack.push(Integer.parseInt(tokens[i]));
            }

        }

        // 最后栈中只剩一个元素，就是结果
        return stack.pop();


    }



}
