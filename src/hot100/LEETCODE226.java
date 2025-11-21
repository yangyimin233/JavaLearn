package hot100;

import java.util.Deque;
import java.util.LinkedList;

public class LEETCODE226 {


    // 翻转二叉树

    public TreeNode invertTree(TreeNode root) {
        // 我的想法就是层序遍历，然后交换每个节点的左右孩子

        // 每一层节点依次入
        if (root == null) return null;

        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        // 每层的节点数量
        int rownum = 1;

        // 根节点入队
        treeNodeDeque.offer(root);

        // 队列非空就一直遍历
        while(!treeNodeDeque.isEmpty()){
            // 取出当前节点
            TreeNode cur = treeNodeDeque.poll();
            // 如果左右节点非空，则将其孩子入队
            if(cur.left != null){
                treeNodeDeque.offer(cur.left);
            }
            if(cur.right != null){
                treeNodeDeque.offer(cur.right);
            }
            // 然后交换左右孩子
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

        }

        return root;


    }


}
