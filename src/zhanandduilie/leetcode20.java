package zhanandduilie;

public class leetcode20 {

//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//    有效字符串需满足：
//
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    每个右括号都有一个对应的相同类型的左括号。


    // "{[]}()" true
    //  ({)} false 注意这种也是不行的

    public boolean isValid(String s) {

        // 定义一个栈来存储左括号
        java.util.Stack<Character> stack = new java.util.Stack<>();
        // 遍历字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            // 如果遍历得到左括号就入栈
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 是右括号，因为题设说了只有这几种括号，所以这里就不需要判断了
                if (stack.isEmpty()) {
                    return false; // 如果栈为空，说明没有对应的左括号
                }
                char top = stack.pop(); // 弹出栈顶元素
                // 判断弹出的左括号是否与当前右括号匹配
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false; // 如果不匹配，返回false
                }
            }
        }
        // 哦哦这里条件容易搞忘，最后还要判断栈是否为空，比如单给你一个做左括号
        return stack.isEmpty();
    }

}
