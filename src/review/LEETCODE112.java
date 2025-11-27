package review;


import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LEETCODE112 {



    // 二叉树层序遍历

    public List<List<Integer>> levelOrder(TreeNode root){

        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        queue.offer(root);


        while (!queue.isEmpty()) {
            // 获取当前层的节点数
            int rowSize = queue.size();
            List<Integer> rowres = new ArrayList<>();
            while (rowSize > 0) {
                TreeNode node = queue.poll();
                rowres.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                rowSize--;
            }
            // 当前层遍历完了
            res.add(rowres);
        }
        return res;


    }




}
