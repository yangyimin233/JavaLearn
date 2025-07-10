package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

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
        // 现在递归遍历每个节点高度的写好了，然后现在主函数，里面我们只需要任选一种遍历方式，然后遍历所有节点，同时再检查该节点的左右孩子的高度差是否大于1


//        // 比如这里还是以层序遍历为例
//        // 层序的队列
//        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
//        if (root == null) {
//            return true;
//        }
//
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
//                // 判断左右孩子的高度差
//                int value = getHeight(node.left)-getHeight(node.right);
//                if (value < -1 || value > 1) {
//                    return false;
//                }
//                len--;
//            }
//
//        }
//        return true;


        // 上面这个确实过了，但是 看起来 我们这里主函数里面一个层序遍历，递归执行了一个后续遍历，应该是有很多冗余的
        // 所以这边递归那里可以改一下，每个节点计算高度时，会采用其左右孩子的最高高度
        // 这里我们再加一步，如果绝对值差大于1，表示该节点作为根节点的子树不平衡了已经
        // 直接return -1，然后后续 计算 如果左右孩子高度已经记录为-1 ，则 其往上的节点也一定 是-1


        // 这样子写，主函数就一步就完成了
        return !(getHeight3(root) == -1);








    }


    // 递归方法 ，求某一个节点高度

    // 这里在补充一下 高度是 从下往上的，最下面的叶子节点到该节点
    // 然后深度是从上往下的，从根节点 到该节点


    public static int getHeight(TreeNode root) {

        // 写递归，首先确定 正常 终止条件
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);


    }


    // 当然也可以改进一下，边遍历边存，这样就只需调用一次就可以了
    // 而且这个存储顺序实际上是个后序的存储顺序嗷
    public static int getHeight2(TreeNode root, HashMap<TreeNode, Integer> map) {

        // 写递归，首先确定 正常 终止条件
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int height = 1 + Math.max(leftHeight, rightHeight);
        map.put(root, height);
        return height;

    }


    public static int getHeight3(TreeNode node){

        if (node == null) {
            return 0;
        }

        // 访问左右孩子的高度
        int leftHeight = getHeight3(node.left);
        int rightHeight = getHeight3(node.right);

        if (leftHeight == -1) {
            return -1;
        }
        if (rightHeight == -1) {
            return -1;
        }

        // 如果到这里了，说明其左右孩子作为根节点的字数还是平衡的
        // 这里就计算该节点作为根节点 并入左右孩子的 子树是否平衡
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // 平衡才会有合法高度
        return 1 + Math.max(leftHeight, rightHeight);
    }



}
