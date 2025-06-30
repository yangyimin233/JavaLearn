package lianbiao;
// 力扣707 设计链表
public class MyLinkedList {

    //size存储链表元素的个数
    private int size;
    //注意这里记录的是虚拟头结点
    private ListNode head;
    // 真正的第一个节点是 head.next



    // 你去结合他这个写法，你就知道这个链表的结构了，一开始new一个MyLinkedList，此时head对应的节点是虚拟头节点，里面不装数据的，也没有index
    // 此时size为0，head.next为null
    // 真正的头节点(会装数据的)是head.next，初始时为null ，且该节点对应的index为0

    //初始化链表
    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是虚拟头结点
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        //第0个节点是虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;

        // 在链表最前面插入一个节点，等价于在第0个元素前添加
        // addAtIndex(0, val);
    }


    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size++;

        // 在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
        // addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        //找到要插入节点的前驱
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        //因为有虚拟头节点，所以不用对index=0的情况进行特殊处理
        ListNode pre = head;
        for (int i = 0; i < index ; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }


}
