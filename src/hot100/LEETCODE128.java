package hot100;

import java.util.HashMap;

public class LEETCODE128 {

//    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//    请你设计并实现时间复杂度为 O(n) 的算法解决此问题。



    // 写得什么勾八,等会重写
    public int longestConsecutive(int[] nums) {
        int re = 0;
        // 首先想到的肯定是 排序 ,可惜排序肯定不满住 o(N)复杂度

        // 直接看的思路
        // 维护一个hashmap <KEY,VALUE>
        // 其中 key 表示 数, value 为 该数所在序列的最长长度

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {

            // 然后就是往这里面放,并且维护 value
            // 看来下题目,这个数可能是存在重复的

            // 先看里面是否已经有了,若有就不放进去了
            if (!map.containsKey(num)) {

                // 没有才考虑往里面放

                // 此时又分以下几种情况
                // num是孤立的,即 num+1 和num -1 都不存在于map的key里面




                if ((!map.containsKey(num + 1))&&(!map.containsKey(num - 1))) {
                    // 孤立点 长度为1
                    map.put(num, 1);

                    continue;
                }
                // num刚好连接 两部分,即 左右都存在于map 的key里面
                if ((map.containsKey(num + 1))&&(map.containsKey(num - 1))) {
                    // 其实这个点塞不塞进去无所谓,我们只需要维护两边的 value就行
                    map.put(num, 1);
                    int leftlen = map.get(num-1).intValue();
                    // 实际上这里leftvalue直接取num-1的value也行,同理下面那个也一样
                    int leftvalue = map.get(num-leftlen).intValue();
                    // key  1 2 null 4 5 6  这时候插入3

                    // 维护两边
                    int rightlen = map.get(num+1).intValue();
                    int rightvalue = map.get(num+rightlen).intValue();


                    map.put(num + rightlen, rightvalue + leftvalue + 1);
                    map.put(num - leftlen, rightvalue + leftvalue + 1);
                    continue;
                }
                // 然后就是num 连接其中一边
                if (map.containsKey(num + 1)) {
                    // 连接右边
                    int rightlen = map.get(num+1).intValue();
                    int rightvalue = map.get(num+rightlen).intValue();
                    map.put(num, rightvalue + 1);
                    map.put(num+rightlen, rightvalue + 1);

                    continue;
                }
                if (map.containsKey(num - 1)) {
                    // 连接左边
                    int leftlen = map.get(num-1).intValue();
                    int leftvalue = map.get(num-leftlen).intValue();
                    map.put(num,leftvalue + 1);
                    map.put(num - leftlen, leftvalue + 1);

                }



            }




        }

        // 然后返回 map里面最大value值就行
        for (Integer key : map.keySet()) {
            re = Math.max(re, map.get(key).intValue());
        }

        return re;






    }


    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(1, 1);
        map.put(1, 2);
        map.put(2, 3);

        System.out.println(map);
        System.out.println(map.get(1).intValue());


    }




}
