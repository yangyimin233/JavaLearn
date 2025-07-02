package zhanandduilie;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode347 {

//    给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
//    示例 1:
//
//    输入: nums = [1,1,1,2,2,3], k = 2
//    输出: [1,2]
//    示例 2:
//
//    输入: nums = [1], k = 1
//    输出: [1]

    public int[] topKFrequent(int[] nums, int k) {


        int[] res = new int[k];

        // 思路肯定是先遍历一边数组，存到一个map里面去
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // 对应的key 的vuale++
                map.put(nums[i], map.get(nums[i]) + 1); // 经典写法嗷
            } else  {
                map.put(nums[i], 1);
            }
        }
        // 然后我们现在就有个一个map 里面记录了各种值的出现频率
        // 现在需要在这个map里面选出前k个
        // 那就先排个序看看? 这个肯定能做？但是这个需要一个排序的复杂度，一般是nlog(n)

        // 这里主要是为了引入这个堆排序的操作
        // 比如我们用小顶堆来举例，实际上也就是那个优先级队列
        // 这个优先级队列(小顶堆有个特点)，每次出队一定是当前队列中最小的元素出去
        // 所以很适合去做 选出前k个最值的问题

        // 比如 现在数组是 6 9 10 5 3 12 1
        // 假设我要选 前3个最大的出来
        // 我就创建一个小顶堆，一次元素进队，但是当堆size>3时，就出队，最终留下的一定是3个最大的
        // 队列
        // 6 9 10 (注意这个优先级队列特点，第一个一定是最值，其他的顺序不一定，这是小顶堆底层实现的特点)
        // 5 9 10 (6出队)
        // 3 9 10 (5出队)
        // 9 10 12 (3出队)
        // ...

        // 最终留下来的就是最大的k个

        // 所以这里我们来做一个优先级队列，队列元素为int[]的二元组，其中int[0]为 map的key  ，int[1]为map的value，然后优先级规则按照 value来
        // 注意上面这种优先级队列的写法
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // 然后是遍历map ，这种map通过先获取key的set集合来作为遍历index的方法也要会
        for (int key : map.keySet()) {
            int[] keyandvuale = new int[2];
            keyandvuale[0] = key;
            keyandvuale[1] = map.get(key);
            // 将keyandvuale入队
            pq.offer(keyandvuale);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 然后此时我们得到的这个pq队列里面就只有k个最大的值了
        int i = 0;
        for (int[] keyandvuale : pq) {
            res[i] = keyandvuale[0];
            i++;
        }

        return res;








    }




}
