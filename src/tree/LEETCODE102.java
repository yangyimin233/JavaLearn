package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LEETCODE102 {


//    102. 二叉树的层序遍历

//    给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。


    public List<List<Integer>> levelOrder(TreeNode root) {

        // 哦哦，这里返回值是也是逐层的
        // 每层里面也是个list
        List<List<Integer>> res = new ArrayList<>();


        // 思路就是采用队列的方法
        // 先把根节点入队，然后while一个循环直到队列为空，每次将while里面，出队一个元素，然后记录val，再将其左右孩子分别入队(如果有的话)

        // 但是需要注意，这个每一层怎么设计？


        // 队列
        Deque<TreeNode> queue = new LinkedList<>();
        // 先将根节点入队
        if (root == null) return res;
        queue.offer(root);

        while(!queue.isEmpty()){
            // 这里定义一个list用来记录每一层的结果
            List<Integer> curres = new ArrayList<>();

            // 这里还比较巧妙，len获取一个当前的队列长度，在此基础上，以len表示一个循环,这样就能一层一层地遍历了
            int len = queue.size();
            while (len > 0) {
                TreeNode temp = queue.poll();
                curres.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                len--;
            }
            // len减完了，说明当前层已经遍历完了，但是注意，此时queue不一定空，里面剩下的就是下一层的节点，所以进入下次循环了
            res.add(curres);

        }

        return res;
    }


    // 那我们这里稍微改一下就可以得到求二叉树层数的迭代方法了
    public int getlevel(TreeNode root) {

        int res = 0;

        // 队列
        Deque<TreeNode> queue = new LinkedList<>();
        // 先将根节点入队
        if (root == null) return res;
        queue.offer(root);

        while(!queue.isEmpty()){

            // 这里还比较巧妙，len获取一个当前的队列长度，在此基础上，以len表示一个循环,这样就能一层一层地遍历了
            int len = queue.size();
            while (len > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                len--;
            }
            res++;
        }

        return res;
    }






}
