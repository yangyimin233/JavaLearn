package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class LEETCODE110 {



//    给定一个二叉树，判断它是否是 平衡二叉树



    public boolean isBalanced(TreeNode root) {

//        // 这里我们的思路是 求出所有叶子节点的 深度 ，然看后绝对值差有没有大于 1 就行
//        // 找叶子节点，并且求深度可以先用层序遍历
//
//
//        // 层序的队列
//        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
//        if (root == null) {
//            return true;
//        }
//
//        int depth = 0; // 这里从1开始还是从0开始都无所谓，因为反正也只要一个相对的
//        int minDepth = Integer.MAX_VALUE;
//        boolean findminnode = false;
//
//        // 根节点入队
//        q.offer(root);
//
//        // 只要队列里面还有节点就一直循环
//        while(!q.isEmpty()) {
//            // 这里还是做一个分层设计
//            int len =  q.size();
//            // 当前循环层
//            while (len>0) {
//                TreeNode node = q.poll();
//                // 同理左右孩子存在则入队
//                if (node.left != null) {
//                    q.offer(node.left);
//                }
//                if (node.right != null) {
//                    q.offer(node.right);
//                }
//                // 如果左右孩子都没有，则说明是叶子节点
//                // 而且我们这是层序遍历，第一次到这里说明找到了深度最低的叶子节点
//                if (node.left == null && node.right == null) {
//                    if (!findminnode) {
//                        minDepth =  depth ;
//                        findminnode = true;
//                    } else {
//                        // 说明 当前是其他的叶子节点
//                        if ( depth - minDepth > 1 ) {
//                            return  false;
//                        }
//                    }
//                }
//                len--;
//            }
//            // 当前层遍历完了，到下一层了，depth++
//            depth++;
//        }
//        return true;


        // 我擦，搞错了，这个平衡二叉树是指的是，所有节点的左右孩子高度差小于 1
        // 上面方法是去判断  叶子节点的深度 差是否 大于 1
        // 而且上面这里判断逻辑也还有点问题，只判断了第一个叶子节点 跟后面的差距会不会大于 1 而没有判断所有的

        // 这里还是老老实实用递归实现
        // 递归思路是从下往上去 计算 每个节点的高度
        // 所以得用后序遍历








    }


    // 递归方法 ，求高度的
    public static void getHeight(TreeNode root, int height) {

        // 写递归，首先确定 正常 终止条件
        if (root == null) {
            return;
        }


    }



}
