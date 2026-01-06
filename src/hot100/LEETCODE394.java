package hot100;

import javax.naming.NamingEnumeration;
import java.awt.font.FontRenderContext;
import java.util.Currency;
import java.util.Stack;

public class LEETCODE394 {

    public String decodeString(String s) {

        // 字符串解码
        // 2[aa3[b]] -> aabbbaabbb

        // 遇到 数字 开始准备编码
        // 因为下一个一定是 [
        // 将 [ 往后 的东西一直 + curstr中，直到遇到 ]
        // str +=  num个curstr

        // 此外，还有中情况是 遍历 [ 后，寻求下一个 ] 时
        // 又遇到了] 也就是说里面还有嵌套的情况
        // 这时候需要将原本的curstr入栈 和 num入栈
        // 开始标记新的这个curstr
        // 直到新的curstr被解码后 （curstr）重复num次
        // 如果 栈非空，说明之前还在解码中
        // 则 pop 出原来的curstr 把刚刚解码出来的加上去
        // 如果栈空了，就直接把当前结果加到restr上面去

        // 什么时候结束呢？
        // 遍历到最后一个字符时


        // 两个栈
        // 这个用于保存当前的解码中字符串
        Stack<String> strstack = new Stack<>();
        // 这个用于保存当前解码
        Stack<Integer> numstack = new Stack<>();


        // 记录当前正在解码的字符串
//        String curstr = null;
        // 这个还不能直接赋值成null ，我靠要小心一点
        String curstr = "";
        for (int i = 0; i < s.length(); ) {
            // 取出字符
            char c = s.charAt(i);

            // 然后判断
            // 如果是数字
            if (Character.isDigit(c)) {
                // 说明要开始解码了

                // 这里还要改一下，数字可能不止一位
//                if (!Character.isDigit(s.charAt(i+1))) {
//                    // 后一位不是数字了，说明当前数字位已经结束
//                    numstack.push(c - '0');
//                    if(curstr != null) {
//                        strstack.push(curstr);
//                    }
//                }
                int j = i;
                while (Character.isDigit(s.charAt(j))) {
                    // 先一直往后面取直到取到非数字
                    j++;
                }
                // 将i到j的部分转化成数字存入numstack
                String numstr = s.substring(i, j);
                numstack.push(Integer.parseInt(numstr));
                if(curstr != null) {
                    strstack.push(curstr);
                }
                // 然后需要调整 i 的位置
                i = j;


            } else if (c== '[') {
                // 这里好像暂时不用处理
                // 这里需要刷新curstr
                curstr = "";
                i++;

            } else if (c-'a'>=0 && 'z'- c >=0) {
                // 说明是字符
                curstr += c;
                i++;
            }  else if (c == ']') {
                // 开始解码
                // 弹出重复次数
                int num = numstack.pop();
                String temp = curstr;
                while (num>1){
                    curstr += temp;
                    num--;
                }
                // 括号里面解完了，就把之前的curstr加上去
                if (!strstack.isEmpty()) {
                    curstr = strstack.pop() + curstr;
                }
                i++;
            }





        }


        return curstr;


    }


    public static void main(String[] args) {
        char c = 'A';
        String str = null ;
//        System.out.println(str.substring(1,1));
        Stack<String> strstack = new Stack<>();
        strstack.push(str);
        System.out.println(strstack.pop() + "AAA");
        // 这个直接 + 会默认 将null 转成 string

        LEETCODE394 leetcode394 = new LEETCODE394();

//        System.out.println(leetcode394.decodeString("10[e]"));



    }



}
