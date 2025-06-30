package simple100;

public class leetcode7 {

//    //整数反转
//    public int reverse(int x) {
//        int result = 0;
//        boolean flag = false; // 用于标记是否是负数
//        // 处理负数的情况
//        if (x < 0) {
//            x = -x; // 将负数转换为正数进行处理
//            flag = true; // 标记为负数
//        }
//        while (x != 0) {
//            int digit = x % 10; // 获取最后一位数字
//            x /= 10; // 去掉最后一位数字
//
//            // 检查是否会溢出
//            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
//                return 0; // 溢出，返回0
//            }
//            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
//                return 0; // 溢出，返回0
//            }
//
//            result = result * 10 + digit; // 更新结果
//        }
//        if (flag){
//            result = -result; // 如果是负数，转换结果为负
//        }
//        return result;
//    }

    // 换用String的方式来反转整数
    // 看看就行嗷
    public int reverse(int x){
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        // 如果是负数，先添加负号
        if (str.charAt(0) == '-') {
            sb.append('-');
            str = str.substring(1); // 去掉负号
        }
        // 反转字符串
        sb.append(str).reverse();
        // 转换为整数
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0; // 如果转换失败，返回0
        }
    }



}
