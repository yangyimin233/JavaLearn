package lianbiao;

public class leetcode24 {

    // 题意：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。




    public ListNode swapPairs(ListNode head) {

        // 像这种链表类的题目，我们最好给他定义一个虚拟头节点，这样可以避免处理头节点的特殊情况，其实就是之前学c语言数据结构时候的首节点

        ListNode dummy = new ListNode(0); // 创建一个虚拟头节点
        dummy.next = head; // 将虚拟头节点的next指向原链表的头节点

        // 思路，每次交换两个节点，直到链表末尾 ， 修改链表的指针顺序往往依赖前一个节点
        // eg  dummy-1-2-4-5-null ，一开始指针指向dummy，交换1，2，是可以的，然后就成了 dummy-2-1-4-5-null ，此时指针需要移动到1的位置，再去交换4，5

        ListNode cur = dummy; // 当前节点指向虚拟头节点

        // 注意这个结束条件，cur.next 为null 时，说明已经到达链表末尾了，这是偶数情况，如果为奇数，cur.next.next 为null 时，说明后面只剩一个节点了，这两种情况都不要再交换了
        // 此外还要注意谁先谁后，这里面如果cur.next 为null 就直接退出循环了，不会判断后面一句，不会引发空指针，如果你写反了的话是会报错的，因为cur.next.next 可能为空指针，(偶数的情况)
        while (cur.next != null && cur.next.next != null) {

            // 交换 cur.next 和 cur.next.next 两个节点
            // 先保存这两个节点
            ListNode temp1 = cur.next; // 第一个节点
            ListNode temp2 = cur.next.next; // 第二个节点
            // 交换这两个节点
            cur.next = temp2;
            temp1.next = temp2.next; // 将第一个节点的next指向第二个节点的下一个节点
            temp2.next = temp1;

            cur = cur.next.next;

        }
        // 注意这里不能返回head，要返回dummy.next，因为head可能已经被修改了(eg 原本是dummy-1-5 ，head永远都是1那个节点，交换了之后就变成了dummy-5-1，这时候返回head的话就直接从1开始了，5没了)，返回的是虚拟头节点的下一个节点
        return dummy.next;

    }



}
