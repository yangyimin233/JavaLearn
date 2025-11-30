package hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LEETCODE142 {

//    给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
//    不允许修改 链表。

    public class Solution {
        public ListNode detectCycle(ListNode head) {

            // 先来一般的方法
            // 遍历链表
            // 遍历一个就将该节点放进去一个hashset里面
            // 如果，重复了，说明当前节点已经遍历过了，存在环

            // 否则一直遍历
            // 因为没环的链表一定会到达 null 节点

            Set<ListNode> set = new HashSet<>();
            ListNode node = head;

            while (node != null) {

                if (set.contains(node)) {
                    // 说明存在环，且就是当前节点
                    return node;
                }
                set.add(node);
                node = node.next;
            }
            return null;


            // 这个使用了额外的空间，思考？能不能在有限的空间里面做到这个？
            // 可以的，使用快慢指针
            // 快指针每次 走两步
            // 满指针每次 走一步

            // 当快指针 没法往前走了(fast.next 或者 next的next为null ，说明一定不存在环)
            // 如果链表存在环

            // 快慢指针 一定相遇 这个没有问题
            // 但是问题是 ，这个相遇的位置 不一定就在环上？ 如何通过相遇点 来计算环的位置？

            // 考虑环长度为x
            // 慢指针 走的距离为 a
            // 快指针 走的距离一定为 2a

            // 现在两个相遇在 环上某个位置
            // 慢指针 应该是 a = n + m ，n 为环节点位置，m为 环节点到相遇节点的距离
            // 快指针 应该是 2a = n + m + kx ，k为快指针在环上多走的圈数

            // 为什么长这个样子？ 先思考以下两个问题：
            // 1. 慢指针有没有可能在环上已经走了不只一圈？


            // 2. 快指针有没有可能在环上面走了不只一圈？
            // 这个完全有可能，你想，考虑很长很长的链表，环存在于最后两个节点上，此时满指针走到一半，快指针已经开始跑环




        }
    }



}
