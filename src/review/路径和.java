package review;

import java.util.IllegalFormatCodePointException;

public class 路径和 {


    // 对了，之后我推荐你写递归函数都不要用static
    // 因为一旦涉及到 引用全局的变量
    // static 方法只能引用 static的
    // 所以这时候全局变量也得弄成 static 的，这就导致了，力扣上 多个测试样例实际上是多个solution类
    // 这个会共用一个static
    // 导致前一个用例可能会污染后一个的

    // 所以还是不要用static方法比较好
    // 主方法里面调用，也可以直接调用，他会默认是 this 引用


    private int sum = Integer.MIN_VALUE;

    // 求二叉树 根节点 到叶子节点 的最大路径和

    private int travelPath(TreeNode node) {

        if (node == null) {
            return 0;
        }

        // 否则一定有孩子节点
        int left = travelPath(node.left);
        int right = travelPath(node.right);

        return Math.max(node.val+left, node.val+right);

    }

    // 返回任意路径 最大和，节点作为中转也行
    private int travelAllPath(TreeNode node) {

        // 这里面return 的是包含当前节点的左右种最大的贡献值

        if (node == null) {
            return 0;
        }

        // 否则一定有孩子节点
        int left = Math.max(0,travelAllPath(node.left));
        int right = Math.max(0,travelAllPath(node.right));

        // 全局sum维护的是最大任意路径和
        // 注意，这里为什么 是直接跟left+rigth+node.val 作比较？
        // 单单一边会是最大的吗？
        // 因为前面路径贡献那里，我们是取了max(0，？)的，所以这个左右贡献一定是大于等于0的
        sum = Math.max(sum, left+right+node.val);

        // 返回的还是只是左右孩子分支中最大的
        return Math.max(node.val+left, node.val+right);

    }


    // 返回单向向下的最大路径和(起始节点不一定为根，终止节点不一定为叶子节点)
    private int travelDownPath(TreeNode node){

        if (node == null) return 0;

        int left = travelDownPath(node.left);
        int right = travelDownPath(node.right);

        // 从 node 往下走的最好单边（可以选择不走子树）
        int bestDown = node.val + Math.max(0, Math.max(left, right));

        // 全局答案：任意起点、任意终点的单向向下路径
        sum = Math.max(sum, bestDown);

        return bestDown;

    }



}
