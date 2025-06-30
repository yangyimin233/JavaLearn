package zhanandduilie;

public class leetcode1047 {

//    给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
//
//    在 s 上反复执行重复项删除操作，直到无法继续删除。
//
//    在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
//
//
//    示例：
//
//    输入："abbaca"
//    输出："ca"
//    解释：
//    例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。


    public String removeDuplicates(String s) {

        // 思路还是比较简单的，使用栈来存储字符
        // 每次遍历字符串，当当前元素跟栈顶元素不一样时取当前元素入栈，
        // 哦哦哦这里还要让栈顶元素也出栈如果相同的话 ， 比如 abbc - 遍历到i =2 是 ，栈顶元素是b，当前元素也是b，所以栈顶元素出栈，当前元素不入栈

        String result = "";
        // 定义一个栈
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || s.charAt(i) != stack.peek()) {
                // 如果栈为空或者当前字符与栈顶字符不相同，则将当前字符入栈
                stack.push(s.charAt(i));
            } else {
                // 如果当前字符与栈顶字符相同，则将栈顶元素出栈
                stack.pop();
            }
        }

        // 最后将栈中的字符拼接成字符串
        while (!stack.isEmpty()) {
            result = stack.pop() + result; // 注意这里是先pop再拼接，这样才能保证顺序正确
        }

        return result;

    }


}
