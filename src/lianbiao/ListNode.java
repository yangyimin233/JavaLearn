package lianbiao;

public class ListNode {
    // 链表的节点类

    int val;
    ListNode next;



    public static void main(String[] args) {
        ListNode l = new ListNode(2,new ListNode(3,new ListNode(4)));
//        l.addAtTail(2);

        l.PrintAll();
    }


    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


//    在链表类中实现这些功能：
//
//    get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
//    addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
//    addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
//    addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
//    deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。


//    public int get(int index) {
//        // 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
//        ListNode current = this; // 从头节点开始
//        int count = 0; // 计数器
//        while (current != null) {
//            if (count == index) {
//                return current.val; // 找到第 index 个节点，返回其值
//            }
//            current = current.next; // 移动到下一个节点
//            count++;
//        }
//        return -1; // 如果索引无效，返回 -1
//    }
//
//    public void addAtHead(int val) {
//        // 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
//        ListNode newNode = new ListNode(val);
//        newNode.next = this; // 新节点指向当原节点
//        // 再将新表头指向newNode
//
//
//    }
//
//    public void addAtTail(int val) {
//        // 将值为 val 的节点追加到链表的最后一个元素。
//        ListNode newNode = new ListNode(val);
//        ListNode current = this; // 从头节点开始
//        while (current.next != null) {
//            current = current.next; // 移动到下一个节点
//        }
//        current.next = newNode; // 将新节点添加到链表的末尾
//    }
//
//    public void addAtIndex(int index, int val) {
//        // 在链表中的第 index 个节点之前添加值为 val 的节点。
//        // 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
//        // 如果 index 大于链表长度，则不会插入节点。
//        // 如果index小于0，则在头部插入节点。
//        if (index <= 0) {
//            addAtHead(val); // 如果 index 小于 0，则在头部插入节点
//            return;
//        }
//        int count = 0;
//        ListNode current = this; // 从头节点开始
//        while (current != null) {
//            if (count == index) {
//
//
//
//            }
//
//            current = current.next;
//            count++;
//
//        }
//
//
//
//
//    }


    // 这里在加个打印链表所有值的方法，便于测试
    public void PrintAll(){
        ListNode current = this;
        while(current!=null){
            System.out.println(current.val);
            current = current.next;
        }
    }




}
