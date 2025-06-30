package lianbiao;

public class leetcode19 {
//    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。


    // 输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5]

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 还是老规矩，我们来个dummy作为虚拟头节点，这样可以避免处理头节点的特殊情况

        ListNode dummy = new ListNode(0);
        dummy.next = head; // 将虚拟头节点的next指向原链表的头节点

        ListNode fast = dummy; // 快指针，先走n步
        ListNode slow = dummy; // 慢指针，最后指向要删除的节点的前一个节点

        // 双指针法的核心思想，是，比如我要删倒数第二个节点，我先让fast先走两步，然后，此时我fast和slow再一起走，直到fast走到null，此时的slow的位置恰好就是倒数第二个节点，这个画个图的话很明显

        // 先让fast走n步
        int count = 0;
        while(count<n + 1){
            // 这里还要处理一下n越界的情况
            // 题设给了这个 1<= n <= size
            // 所以 即使这个n取到了size ，这个fast最终也停在了null，就不会在进入循环了。这里是没问题的哈
            fast = fast.next;
            count++;
        }

        // 然后是fast和slow一起走，直到fast走到null
        while(fast!= null) {
            fast = fast.next; // fast一直走到链表的末尾
            slow = slow.next; // slow也跟着走
        }

        // 哦哦我们这里发现slow此时指向的又是要删除的本身节点了，所有我们理论上是希望slow指向被删除的前一个节点，这样处理起来比较方便，所以之前那里fast先走的步数要改一下
        // 自己想想啊，所以改成了 count < n + 1 ，也就是让fast多走一步，这样 slow会提前一个节点停下

        // 然后现在就是删除slow指向的下一个节点
        slow.next = slow.next.next;

        // 注意这个返回哈，凡是这种new了一个dummy的，你都这样子返回
        return dummy.next;


        // 链表的也做了这么多了
        // 总结一下，最害怕就是空指针异常，最后一个节点 往往是 val + null 的形式，你当前的cur遍历到这个最后节点了，可以再往后指向该节点的next 也就是null ，所以往往循环条件就写为cur！= null，而不是 cur.next != null，这样就可以避免空指针异常了
        // 此外 这个new一个dummy的节点还是很常见
        // 然后就是你要删除一个节点，最好是将当前处理指针放在要删除的节点的前一个节点上，这样就可以直接修改指针的指向来删除该节点了。


    }



}
