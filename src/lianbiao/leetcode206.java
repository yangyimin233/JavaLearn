package lianbiao;

import com.sun.source.tree.NewArrayTree;

import java.util.List;

public class leetcode206 {

//    题意：反转一个单链表。
//
//    示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode reverseList(ListNode head) {

//        // 直观想到的，就是，我先创个新链表，然后遍历原链表，将每个节点插入到新链表的头部，哦哦哦天才
//        ListNode reversedHead = null; // 新链表的头节点
//        // 想想为什么不用 ListNode reversedHead = new ListNode(); 这样呢？因为这样会多一个头节点，导致最后返回的链表多了一个节点0
//
//        ListNode cur = head;
//        ListNode next = null;
//
//        while (cur != null) {
//
//            if (cur.next != null) {
//                // 如果当前节点的下一个节点不为空，说明还有节点可以处理
//                next = cur.next;
//                cur.next = reversedHead;
//                reversedHead = cur; // 更新新链表的头节点为当前节点
//                cur = next;
//            }
//            else {
//                // 如果当前节点的下一个节点为空，说明到了链表的尾部
//                cur.next = reversedHead; // 将当前节点的next指向新链表的头节点
//                reversedHead = cur; // 更新新链表的头节点为当前节点
//                break; // 退出循环
//            }
//
//        }
//        return reversedHead;



        // 上面的写法还是不推荐，这推荐还是给链表增加一个虚拟头节点，这样遍历起来更好用

        // 思路还是一样的
        ListNode reverse = null;
        // 创建虚拟头节点
        ListNode cur = new ListNode();
        cur.next = head;

        // 然后循环就更好写了
        while (cur.next != null) {
            // 顺序遍历原链表节点，将每个遍历得到的节点插入到reverse表前

            // 新建要插入的节点，并且将该节点的next指向reverse
            ListNode temp = new ListNode(cur.next.val);
            temp.next = reverse;
            reverse = temp;

            // 原链表的cur往下继续指向
            cur = cur.next;

        }

        return reverse;

    }

}
