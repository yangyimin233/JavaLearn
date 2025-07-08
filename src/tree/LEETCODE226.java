package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LEETCODE226 {

//    给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

    // 实际上就是交换每个 节点的左右孩子

    // 那还是暂用层序遍历的模板的，每遍历一个节点，就交换其左右孩子

    public TreeNode invertTree(TreeNode root) {


        // 空节点也要处理一下，不然后面会报空指针异常
        if(root == null){ return root;}

        // 层序遍历借助了队列来实现
        Deque<TreeNode> stack = new LinkedList<>();
        // 根节点入队
        stack.offer(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.offer(node.left);
            }
            if (node.right != null) {
                stack.offer(node.right);
            }
            // 再交换这个节点的左右孩子，这里放前面应该也是可以的
            // 确实可以，试了一下
            TreeNode temp = new TreeNode();
            temp =  node.left;
            node.left = node.right;
            node.right = temp;
        }


        // 上面是层序遍历，实际上采用深度优先的也可以？但唯独中序遍历不行


        return root;
    }




}
