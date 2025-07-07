package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LEETCODE117 {

//    给定一个二叉树：
//
//    struct Node {
//        int val;
//        Node *left;
//        Node *right;
//        Node *next;
//    }
//    填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
//
//    初始状态下，所有 next 指针都被设置为 NULL 。

    // 这里按照代码随想录里面，层序遍历二叉树的方法又写了好多类似的题，你之后可以上去慢慢看看，这边以这个题为例
    // 核心都差不多，设置一个队列，记录len，每次循环len此遍历队列里面的所有节点，并且再将 每个节点的左右孩子进队，这样就实现了层层遍历

    // 然后只需要简单改一下数据层的逻辑就行
    // 还是把117的代码先复制过来

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };


    public Node connect(Node root) {




        // 思路就是采用队列的方法
        // 先把根节点入队，然后while一个循环直到队列为空，每次将while里面，出队一个元素，然后记录val，再将其左右孩子分别入队(如果有的话)

        // 但是需要注意，这个每一层怎么设计？


        // 队列
        Deque<Node> queue = new LinkedList<>();
        // 先将根节点入队
        if (root == null) return null;
        queue.offer(root);

        while(!queue.isEmpty()){
            // 这里定义一个list用来记录每一层的结果
            List<Integer> curres = new ArrayList<>();

            // 这里还比较巧妙，len获取一个当前的队列长度，在此基础上，以len表示一个循环,这样就能一层一层地遍历了
            int len = queue.size();
            while (len > 0) {
                Node temp = queue.poll();
                // 这里需要将当前temp的next指向目前队列的队首

                if (len>1) {
                    Node temp1 = queue.getFirst();
                    temp.next = temp1;
                } else {
                    temp.next = null;
                }

                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                len--;
            }

        }


        return  root;

        // 这些都不是很难，重点在你能 处理二叉树的 层序遍历就行



    }




}
