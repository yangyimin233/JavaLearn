package tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LEETCODE112new {

    // 之前那个可能命名错了，这个才是真的112

//    给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
//
//    叶子节点 是指没有子节点的节点。


    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 那这个应该就是改一下之前那个遍历所有路径的 就可以了

        List<Integer> path = new ArrayList<>();
        int sum = 0;
        travel(root, sum, path);

        for (Integer i : path) {
            if (i == targetSum) {
                return true;
            }
        }

        return false;


    }


    public static void travel (TreeNode root, int sum, List<Integer> pathSum) {

        if (root==null) {
            return;
        }

        // 将当前节点算入sum
        sum += root.val;

        // 看是不是叶子节点
        if (root.left == null && root.right == null) {
            pathSum.add(sum);
            return;
        }

        // 其实我们很早就在使用这个回溯的思想了，
        // 每次到达根节点了，sum加入到这个path的list中了
        // 需要return到上一个travel
        // 比如之前我们是走左孩子 走到了一个叶子节点，现在 return回来 走下面的右孩子语句
        // 想想看？这时候sum是什么情况，是之前已经+= 叶子节点val了嘛？
        // 其实没有，每次进入传进去的都是sum的副本，在一个travel中，被执行 += val后 sum 就不会变了
        // 后面再递归travel也不会影响当前层的sum

        // 不是叶子节点 则进入左孩子
        travel (root.left, sum, pathSum);
        // 再进入右孩子
        travel (root.right, sum, pathSum);


    }



}
