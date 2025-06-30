package hash;

import java.util.HashMap;

public class hashsetlearn {


    public static void main(String[] args) {

        // 这里来学习一下HashSet的用法
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        // 先是增删查改四种基本操作
        set.add(1); // 添加元素
        set.add(1); // 添加元素
        // 注意，HashSet不允许重复元素，所以这里添加两次1，实际上只会存储一个1
        // 打印元素
        System.out.println(set); // 输出：[1]

        // 比较set和List的区别
        java.util.List<Integer> list = new java.util.ArrayList<>();
        list.add(1); // 添加元素
        list.add(1); // 添加元素
        list.add(2);
        // 注意，List允许重复元素，所以这里添加两次1，实际上会存储两个1
        System.out.println(list); // 输出：[1, 1 ,2]

        // set是有序存放的吗？
        // 不，HashSet是无序的，元素的存储顺序不一定和添加顺序相同
        // 如果需要有序存放，可以使用LinkedHashSet，它是有序的，或者使用TreeSet，它是有序的并且会根据元素的自然顺序进行排序
        set.add(2); // 添加元素
        set.add(3); // 添加元素
        System.out.println(set); // 输出：[1, 2, 3]，顺序可能不一定是1, 2, 3

        // 删除元素
        set.remove(2); // 删除元素2
        System.out.println(set); // 输出：[1, 3]，元素2被删除了

        // 查找元素
        boolean contains1 = set.contains(1); // 检查是否包含元素1
        boolean contains2 = set.contains(2); // 检查是否包含元素2
        System.out.println("Contains 1: " + contains1); // 输出：Contains 1: true
        System.out.println("Contains 2: " + contains2); // 输出：Contains 2: false

        // 对比list，list里元素是有序的，可以通过索引访问
        System.out.println(list.get(2)); //


        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one"); // 添加键值对
        map.put(2, "two"); // 添加键值对
        map.put(2, "二"); // 添加键值对  // 注意，这里键2的值被更新为"二"，因为HashMap不允许有重复的键
        map.put(3, "three"); // 添加键值对
        System.out.println(map); // 输出：{1=one, 2=二, 3=three}
        System.out.println(map.get(2)); // 通过键获取值，输出：二
        System.out.println(map.get(4)); // 通过不存在的键获取值，输出：null








    }





}
