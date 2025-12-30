package hot100;

import javax.xml.crypto.dom.DOMCryptoContext;

public class LEETCODE287 {

//    给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
//    假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
//    你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。


    // 实际上这个跟 142本质上一样的，把这个数组也当成链表
    // 注意这个数组的特点，他的值 是只有 1到n 的，且 至少存在一个重复的数

    // 然后 nums[i] 的下一个链表节点 为 nums[nums[i]] ，因为nums[i] 是在1到n范围内，所以这个指针一定是合法的
    // 然后存在 不同i 和 j 使得 nums[i] = nums[j] = d
    // 也就是说 存在两个节点指向 同一个节点

    // 然后按照LEETCODE142的快慢指针 来处理 这种求环形链表节点的问题


    public int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;

        do{
            slow =  nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        // 退出上面的循环时，这个slow 和 fast 指向了相遇 的节点，注意，这个节点不一定是环节点
        // 然后现在需要 让一个指针重新指向开始，另一个指向相遇节点，然后一起每次走一步，直到再次相遇
        // 此时 相遇节点为环形节点，也就是重复的那个值
        int start = 0;
        while(start != fast){
            start = nums[start];
            fast = nums[fast];
        }

        return start;


    }







}
