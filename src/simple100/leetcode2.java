package simple100;

public class leetcode2 {


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


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        l1.printList();
        ListNode l2 = new ListNode(9, new ListNode(9));
        ListNode l3 = new leetcode2().addTwoNumbers(l1, l2);
        l3.printList();
    }





        // 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
        // 请你将两个数相加，并以相同形式返回一个表示和的链表。
        // 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        // 注意这个有进位，但是我们可以先考虑没有进位的情况。

        // 这里的l1和l2是两个链表
        // 链表的next是下一个链表，所以这里我们思路是记录3个index 标记当前三个链表的位置
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l1index = l1;
            ListNode l2index = l2;
            // 这个是存储结果的list
            ListNode result = new ListNode(0); // 结果链表
            // 结果链表的头节点
            ListNode resultindex = result; // 当前节点指向结果链表的头节点

            int carry = 0; // 进位

            while(l1index!= null || l2index!= null || carry > 0) {

                // 用三目运算符来判断当前l1index和l2index是否为空，从而获取对应的val值
                int l1val = (l1index != null) ? l1index.val : 0;
                int l2val = (l2index != null) ? l2index.val : 0;
                int sum = l1val + l2val + carry; // 计算当前位的和
                // 如果和大于等于10，那么需要进位
                if (sum >= 10) {
                    carry = 1; sum -= 10;
                } else {
                    carry = 0;
                }
                resultindex.val = sum;

                // 然后是移动指针
                if (l1index != null) {
                    l1index = l1index.next; // 移动到下一个节点
                }
                if (l2index != null) {
                    l2index = l2index.next; // 移动到下一个节点
                }

                // 这里要注意，如果l1index和l2index的next都不为空，那么我们才需要创建一个新的节点
                if (l1index != null || l2index != null || carry > 0) {
                    ListNode node = new ListNode(0); // 创建一个新的节点
                    resultindex.next = node; // 连接到结果链表
                    resultindex = node; // 移动到结果链表的下一个节点
                }
            }
            return result;
        }





    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        public void printList() {
            ListNode current = this;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

}
