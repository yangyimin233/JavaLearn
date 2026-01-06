package review;



public class 环形链表 {

//    给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//    不允许修改 链表。


    public ListNode detectCycle(ListNode head) {

        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        // 然后快指针一次走两步，满指针一次走一步，如果快慢指针相遇了，则说明存在环形节点

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }

        // 然后这里要判断是，指向空了退出，还是一样了退出的
        // 注意这里不能说判断 fast == slow ？
        // 因为如果只有一个节点 ，也是 fast == slow的
        if (fast == null || fast.next == null) {
            return null;
        }

        // 然后新创建一个指针
        ListNode start = head;
        // 然后和 之前的 start 一起，每次走一步
        // 二者再次相遇一定是 环节点
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }

        return start;

    }





}
