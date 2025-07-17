package tree;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LEETCODE100 {

//    100. 相同的树
//
//    给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
//    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

    public boolean isSameTree(TreeNode p, TreeNode q) {

//        // 想不出来，还是直接层序遍历来一遍
//
//        // 两个队列来存 两棵树的情况
//        Deque<TreeNode> stack1 = new LinkedList<>();
//        Deque<TreeNode> stack2 = new LinkedList<>();
//
//        if (p == null && q == null) {
//            return true;
//        }
//        if (q == null) {
//            return false;
//        }
//        if (p == null) {
//            return false;
//        }
//
//        stack1.push(p);
//        stack2.push(q);
//
//        // 只要有一个不空，就进入大循环
//        while (!stack1.isEmpty() || !stack2.isEmpty()) {
//
//            // 1空2不空
//            if (stack1.isEmpty() && !stack2.isEmpty()) {
//                return false;
//            }
//            // 2空1不空
//            if (stack2.isEmpty() && !stack1.isEmpty()) {
//                return false;
//            }
//            // 到这说明两个都不控
//            TreeNode node1 = stack1.pop();
//            TreeNode node2 = stack2.pop();
//            if (node1.val != node2.val) {
//                return false;
//            }
//
//            // 然后左右孩子入队
//
//            // 这里入队前也要判断左右孩子结构是否一样
//            if (node1.left == null && node2.left != null) {
//                return false;
//            }
//            if (node1.left != null && node2.left == null) {
//                return false;
//            }
//            if (node1.right == null && node2.right != null) {
//                return false;
//            }
//            if (node1.right != null && node2.right == null) {
//                return false;
//            }
//
//
//            if (node1.left != null) {
//                stack1.push(node1.left);
//            }
//            if (node1.right != null) {
//                stack1.push(node1.right);
//            }
//            if (node2.left != null) {
//                stack2.push(node2.left);
//            }
//            if (node2.right != null) {
//                stack2.push(node2.right);
//            }
//
//
//        }
//
//        return true;



        // 改写了一下，上面那个弄成栈了，虽然也过了，但可读性不好

            Deque<TreeNode> queue1 = new LinkedList<>();
            Deque<TreeNode> queue2 = new LinkedList<>();

            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }

            queue1.offerLast(p);
            queue2.offerLast(q);

            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                TreeNode node1 = queue1.pollFirst();
                TreeNode node2 = queue2.pollFirst();

                // 值不同直接返回 false
                if (node1.val != node2.val) {
                    return false;
                }

                // 检查左孩子结构是否相同
                if (node1.left == null ^ node2.left == null) {
                    return false;
                }

                // 检查右孩子结构是否相同
                if (node1.right == null ^ node2.right == null) {
                    return false;
                }

                // 左孩子都不为 null，加入队列
                if (node1.left != null) {
                    queue1.offerLast(node1.left);
                    queue2.offerLast(node2.left);
                }

                // 右孩子都不为 null，加入队列
                if (node1.right != null) {
                    queue1.offerLast(node1.right);
                    queue2.offerLast(node2.right);
                }
            }

            // 如果一个队列空了，一个还没空，说明结构不同
            return queue1.isEmpty() && queue2.isEmpty();






        // 上面这个层序确实没问题了
        // 但是写法有点复杂了，还是来考虑递归吧

//        return travel(p, q);



    }

    // 理论上来说这里做一个递归遍历一下应该就没问题了
    // 注意，递归函数这里函数体本身一般不设置返回值，都设置成void比较好
    // 因为，你递归结束条件这里是要设置成 return的
    // 但是有时候呢，比如求和时，你就可以设置成int 结束条件设置成 return 0

    public static void travel(TreeNode node, List<Integer> res){

        if (node == null) {return;}
        travel(node.left, res);
        res.add(node.val);
        travel(node.right, res);

    }

    // 然后我们在此基础上修改
    public static boolean travel(TreeNode node1, TreeNode node2){

        if (node1 == null && node2 == null) {return true;}
        if (node1 != null && node2 == null) {return false;}
        if (node2 != null && node1 == null) {return false;}

        if (node1.val != node2.val) {return false;}

        return travel(node1.left, node2.left) && travel(node1.right, node2.right);





    }



}
