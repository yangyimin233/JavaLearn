package hot100;

import java.util.List;

public class LEETCODE234 {

    // 判断一个链表是不是回文链表，要求 不使用额外空间，然后时间复杂度为O(n)

//    思路如下：
//    使用快慢指针找到链表的中点
//
//    fast 每次走两步，slow 每次走一步。
//    当 fast 到尾时，slow 正好到中点。
//    原地反转链表的后半部分（O(1) 额外空间）
//
//    依次比较前半部分与反转后的后半部分
//
//    如果有任何节点值不同 → 不是回文。

    public boolean isPalindrome(ListNode head) {

        Boolean flag = true;

        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;

        // 1,2,3,4
        // FAST停在3的位置
        // SLOW停在2的位置

        // 1，2，3，4，5
        // FAST停在5的位置
        // SLOW停在3的位置

        // 先把这个特殊的处理了
        if (head == null || head.next == null) {
            return true;
        }


        while((fast != null) && (fast.next != null)){
            // 快指针每次走两步
            // 慢指针每次走一步
            fast = fast.next.next;
            slow = slow.next;
        }

        // 翻转后半部分链表，注意从上面来看是，从slow.next开始翻转
        ListNode p = slow.next;
        ListNode reversedSecondHalf = null;
        while(p != null){
            // 每次把节点p插入到reversedSecondHalf的头部
            ListNode temp = p;
            p = p.next;
            temp.next = reversedSecondHalf;
            reversedSecondHalf = temp;
        }

        // 比较前半部分和后半部分
        ListNode cur = head;
        while(reversedSecondHalf != null){
            if (cur.val != reversedSecondHalf.val) {
                flag = false;
            }
            cur = cur.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        // 当然你这可以可以做一下复原
        // 现在这个cur指向的是原来slow的那个地方
        cur = cur.next;
        // 再从cur.next开始翻转回来
        ListNode reversedSecondHalf_2 = null;
        while(cur != null){
            // 每次把节点p插入到reversedSecondHalf的头部
            ListNode temp = p;
            cur = cur.next;
            temp.next = reversedSecondHalf_2;
            reversedSecondHalf_2 = temp;
        }

        return flag;





    }




}
