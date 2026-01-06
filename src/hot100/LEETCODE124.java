package hot100;

import com.sun.source.doctree.SummaryTree;

import java.util.ArrayList;
import java.util.List;

public class LEETCODE124 {

//    二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
//
//    路径和 是路径中各节点值的总和。
//
//    给你一个二叉树的根节点 root ，返回其 最大路径和 。

    // 有时候 递归，你也可以这样写，travel递归函数，还是用void，维护一个全局的指向变量
    private static int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int sum = 0;

        // 他这里最大路径 不是根节点到 叶子节点的，而是 可以往上走的，贯穿的那种也行

        // 我们先来个简单的 根节点到叶子节点的
        // 很明显这中得递归



        return sum;
    }


    static int travelPath(TreeNode node){


        // 左右孩子都有
        if (node.left != null && node.right != null) {
            // 返回左右里面大的那个
            return node.val + Math.max(travelPath(node.left), travelPath(node.right));
        }
        else if (node.right != null) {
            return node.val + travelPath(node.right);
        }
        else if (node.left != null) {
            return node.val + travelPath(node.left);
        }


        // 说明是叶子节点
        return node.val;

    }


    static void travelPath2(TreeNode node ,int current) {
        // VOID 版本
        // 维护一个 全局 sum 记录 最大值
        // 然后 形参 current 记录当前路径值

        if(node == null){
            return;
        }

        // 先将该节点统计进入当前 路径和
        current+= node.val;

        // 叶子节点
        if(node.left == null && node.right == null){
            // 到达叶子节点，这时候，比较当前路径和 全局最大和的关系
            sum = Math.max(sum, current);
            return;
        }

        // 走到这，说明非叶子节点
        // 首先，这里会不会爆空指针？
        // 不会，因为一开始就有node == null 的判断

        travelPath2(node.left, current);
        travelPath2(node.right, current);

        // 这个current 其实 自动就回溯了

    }


    static void travelPath3(TreeNode node , List<Integer> path, List<List<Integer>> res) {
        // 同理，上面那个改改就可以得到 这种递归路径的

        if(node == null){
            return;
        }

        // 否则就是有节点
        path.add(node.val);

        if(node.left == null && node.right == null){
            // 叶子节点了
            res.add(new ArrayList<>(path));
            // 凡是return前 统一都要回溯
//            凡是 path.add() 的地方
//            必须保证在所有返回路径上有对应的 path.remove()
            path.remove(path.size() - 1);
            return;
        }

        travelPath3(node.left, path, res);
        travelPath3(node.right, path, res);

        // 然后记得回溯
        path.remove(path.size() - 1);

    }


    static int travel(TreeNode node) {

        // 然后是这个 不一定从根节点开始的路径问题

        if (node == null) {
            return 0;
        }


        int left = Math.max(0,travel(node.left));
        int right = Math.max(0,travel(node.right));

        sum = Math.max(sum, node.val + left + right);

        return node.val+ Math.max(left , right);


    }



}
