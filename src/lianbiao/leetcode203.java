package lianbiao;

public class leetcode203 {

    // 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。


    public static void main(String[] args) {
        // 测试用例 [1,2,6,3,4,5,6]
//        ListNode head = new ListNode(1,
//                new ListNode(2,
//                        new ListNode(6,
//                                new ListNode(3,
//                                        new ListNode(4,
//                                                new ListNode(5,
//                                                        new ListNode(5)))))));

        ListNode head = new ListNode(1,new ListNode(2));

//         ListNode head = null;


        ListNode p = head;
        // 遍历打印原链表
        for (; p!= null;p=p.next) {
            System.out.println(p.val);
        }

        leetcode203 solution = new leetcode203();
        ListNode newHead = solution.removeElements(head, 2);
        // 遍历打印新链表
        p = newHead;
        System.out.println("新链表：");
        for (; p!= null;p=p.next) {
            System.out.println(p.val);
        }


    }



    public ListNode removeElements(ListNode head, int val) {

//        ListNode p = head;
//        ListNode prev = null;
//
//        while (p != null) {
//            if (p.val == val) {
//                // 如果当前节点的值等于val，则删除该节点
//                if (prev == null) {
//                    // 如果是头节点，直接将头节点指向下一个节点
//                    head = p.next;
//                } else {
//                    // 如果不是头节点，将前一个节点的next指向当前节点的下一个节点
//                    prev.next = p.next;
//                }
//            } else {
//                // 如果当前节点的值不等于val，则更新前一个节点
//                prev = p;
//            }
//            // 移动到下一个节点
//            p = p.next;
//        }
//
//        return head;

    // 还是题解写得比较好看

        // 之前头节点那里处理起来很头疼，这里开始先处理头节点，一直处理到头节点位空() 或者头节点的val合法
        while(head!=null && head.val==val) {
            head = head.next;
        }
        // 现在开始再处理剩下的节点
        ListNode current = head; // 当前节点

        if (head==null) {
            return null; // 如果头节点为空，直接返回null
        }
        // 如果思路还是检查当前current节点的值是否等于val，那么有一点很麻烦的就是，删除当前节点，要么选择记录一个pre节点，修改pre节点的指针
        // 要么选择直接将当前节点的值替换为下一个节点的值，然后将当前节点的next指向下下个节点，但是这里也需要讨论当前节点是否为最后一个节点，否则也有问题
        // 所以建议是，利用目前这个head的特点，其首节点一定是合法的，且不等于val，所以每次可以检查current的next节点就行
        while (current.next != null) {
            if (current.next.val == val) {
                // 如果当前节点的下一个节点的值等于val，则删除下一个节点
                current.next = current.next.next; // 将当前节点的next指向下下个节点
            } else {
                // 如果当前节点的下一个节点的值不等于val，则移动到下一个节点
                current = current.next;
            }
        }
        return head;
    }



}
