package tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LEETCODE113 {

//    给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
//    叶子节点 是指没有子节点的节点。



    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        // 这个还是说跟那个112差不多，path到叶子节点，就放到 pathlist里面，否则只是加入到path里面
        // 但是这里要注意，如果我们也用list表示中途的暂存路径，那么每次调用递归函数，都会改变这个list本身，所以这里我们需要手动回溯一下
        // 还有个方法，就是我们先用string 存放 节点，然后pathlist里面放 string，最后主函数里面再 操作字符串
        // 这是因为string是不变引用的变量，每次进入递归函数不影响string本身的值
        // 这里我们先用回溯试一下

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempVal = new ArrayList<>();

        travel(root,targetSum,tempVal,result);

        return result;

    }


    public static void travel(TreeNode root, int targetSum, List<Integer> tempVal, List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        // 将当前节点值 加入 templist
        tempVal.add(root.val);


        // 如果遇到叶子节点了
        if (root.left == null && root.right == null) {
            // 说明是叶子节点,看sum是等于target，如果等于就加入 res
            if (getSum(tempVal) == targetSum) {
                result.add(new ArrayList<>(tempVal));
            }
            tempVal.remove(tempVal.size() - 1);
            return;
        }

        // 不是叶子节点继续进入左右孩子
        travel(root.left, targetSum, tempVal, result);
        travel(root.right, targetSum, tempVal, result);


        // 思考这里该怎么回溯？
        tempVal.remove(tempVal.size() - 1);

        // 你可以这样想，travel 左边出来了后，要 进入右孩子，就要return 一下，所以只要你return了 就要 回溯 ，所以这里有两个 回溯


    }

    private static int getSum(List<Integer> tempVal) {
        int sum = 0;
        for(Integer val : tempVal) {
            sum += val;
        }
        return sum;
    }


}
