package tree;

import java.util.Deque;
import java.util.LinkedList;

public class LEETCODE404 {

//    给定二叉树的根节点 root ，返回所有左叶子之和。

    public int sumOfLeftLeaves(TreeNode root) {

        // 直接想到的就是 层序遍历嘛，每次放入左孩子前可以先判断 左孩子节点是不是叶子节点，如果是的话，就+= sum
        int sum = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return sum;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                // 判断 该节点是不是叶子叶节点
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sum;
    }

}
