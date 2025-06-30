package simple100;

public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    // 写一个打印方法

    public void printList() {
        System.out.println(this.val);
        ListNode current = this.next;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }


}
