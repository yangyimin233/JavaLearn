package hot100;

public class LEETCODE141 {

//    给你一个链表的头节点 head ，判断链表中是否有环。
//    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
//    如果链表中存在环 ，则返回 true 。 否则，返回 false 。



    public boolean hasCycle(ListNode head) {

        // 这个只需要判断 是否有环就行，不需要返回环的具体位置
        // 笨办法 ，是一个指针 一直往前走，每访问一个节点就放到 hashset里面去
        // 如果 访问节点 已经在hashset了，就说明当前回到之前的地方了，存在环
        // 如果一直到null都没有回去，说明没有环

        // 然后是快慢指针法，如果快指针一次走两步，慢指针一次走一步，如果相遇了就说明存在环

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;





    }


}
