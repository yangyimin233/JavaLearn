package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LEETCODE111 {

//    给定一个二叉树，找出其最小深度。
//
//    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
//    说明：叶子节点是指没有子节点的节点。


    public int minDepth(TreeNode root) {

        // 思路：你想 使用程序遍历的话，最小深度一定遍历得到的第一个叶子节点的深度

        Deque<TreeNode> queue = new LinkedList<>();
        int depth = 0;

        if (root == null) {
            return depth;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {

            // 获取本层长度
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    // 遇到叶子节点了，直接返回该层深度就行
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                len--;
            }
            depth++;


        }

        // 实际上不会走这里返回
        return depth;


        // 我擦又搞错了，栈和队列 别弄错了






    }




}
