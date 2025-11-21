package hot100;

public class LEETCODE160 {


    // 返回两个链表的相交节点，若没有，则返回null
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;
        ListNode result = null ;

        // 这里我的思路是，先遍历两个链表各一次，然后让长的链表先走x步，这时候两个cur到各自尾节点长度一致

        int lenA = 0;
        int lenB = 0;

        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        // 指针先归位
        curA = headA;
        curB = headB;

//        1 2 3
//          2 3

        if (lenA > lenB) {
            // 说明A链表比B长，让A先走差步
            for (int i = 1; i <= (lenA - lenB); i++) {
                curA = curA.next;
            }
        }  else  if (lenB > lenA) {
            for (int i = 1; i <= (lenB - lenA); i++) {
                curB = curB.next;
            }
        }

        // 然后现在curA和curB 是同相对起点开始跑了
        while (curA != null) {
            if (curA == curB) {
                result = curA;
                break;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return result;

    }


}
