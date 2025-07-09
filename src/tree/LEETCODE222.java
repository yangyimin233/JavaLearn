package tree;

import java.util.*;

public class LEETCODE222 {

//    给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//
//    完全二叉树 的定义如下：
//    在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层（从第 0 层开始），则该层包含 1~ 2h 个节点。


    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1);
//        System.out.println(countNodes(root));



    }

    public int countNodes(TreeNode root) {

        // 思路，随便想一种遍历方式，遍历count++就行
        // 先试试嘛
//        int result = 0;
//        // 比如这里就再来谢谢这个先根遍历写着玩吧
//        // 来个栈
//        Deque<TreeNode> stack = new LinkedList<>();
//        while (root != null || !stack.isEmpty()) {
//            while (root!=null) {
//                result ++;
//                stack.push(root);
//                root = root.left;
//            }
//            // 出循环了，说明上面已经到最左分之了，弹一个出来，右偏一个
//            root = stack.pop();
//            root = root.right;
//        }
//        return  result;


        // 这样再来个层序遍历做一下吧
        int result = 0;

        // 层序遍历采用队列来实现，每次出队一个节点，然后入队该节点的左右孩子(如果有的话)
        Deque<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return result;
        }
        q.offer(root);
        // 只要队列里面还有元素，就一直大层循环
        while (!q.isEmpty()) {

//            // 这里也可以按照分层的来做
//            int len = q.size(); // 表示当前层还有几个节点
//            while (len > 0) {
//                // 出队一个元素
//                TreeNode node = q.poll();
//                result++;
//                if (node.left != null) {
//                    q.offer(node.left);
//                }
//                if (node.right != null) {
//                    q.offer(node.right);
//                }
//                len--;
//            }

             // 不分层的话，处理就更为简单了
            TreeNode node = q.poll();
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
            result ++;

        }



        return result;


    }


}
