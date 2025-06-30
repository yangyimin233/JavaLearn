package simple100;

import java.util.*;

public class leetcode3 {
    // 老老实实回去补哈基础算了

    public static void main(String[] args) {
        // 这里可以顺便回归一下java的map类型数据
        // 创建 Map
        Map<String, Integer> mapexp = new HashMap<>();

        // 添加键值对
        mapexp.put("apple", 3);
        mapexp.put("banana", 5);
        mapexp.put("orange", 2);

        // 获取值
        int appleCount = mapexp.get("apple");  // 3
        System.out.println("apple 数量: " + appleCount);

        // 检查键是否存在，并且修改对应val值
        if (mapexp.containsKey("banana")) {
            // 他这个put是覆盖原来的
            // 原本val值+1
            mapexp.put("banana",mapexp.get("banana")+1);
            System.out.println("banana 存在");
        }

        // 删除键值对
        mapexp.remove("orange");

        // 遍历 Map
        for (Map.Entry<String, Integer> entry : mapexp.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " -> " + value);
        }

        // 获取所有键或所有值
        System.out.println("所有键: " + mapexp.keySet());
        System.out.println("所有值: " + mapexp.values());

        Map<Character, Integer> mapexp2 = new HashMap<>();
        mapexp2.put('a',1);

//        System.out.println(allValuesAreOne(mapexp2));
//        System.out.println(allValuesAreOne(mapexp));


        // 然后arraylist也用得很多
        ArrayList<Integer> list = new ArrayList<>();
        // arraylist的增删查改
        // 添加元素
        list.add(10);
        list.add(20);
        list.add(30);
        // 访问元素
        System.out.println("第一个元素: " + list.get(0));
        // 修改元素
        list.set(1, 25);
        // 删除元素
        list.remove(0);
        // 遍历
        for (int value : list) {
            System.out.println(value);
        }
        // 当前大小
        System.out.println("长度: " + list.size());

        ArrayList<Character> list2 = new ArrayList<>();
        list2.add('a');
        list2.add('b');
        list2.add('c');
        System.out.println(hasNoDuplicates(list2));
        list2.add('a'); // 添加重复元素
        System.out.println(hasNoDuplicates(list2)); // 现在有重复元素了，返回false

        String str = "BBB";

        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(str));



    }





    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。

    static class Solution {
        public int lengthOfLongestSubstring(String s) {

//            if (s.isEmpty()){
//                return 0;
//            }
//
//            int result = 0;
//            int maxlen = 1;
//            ArrayList <Character> list = new ArrayList<>();
//
//            // 思路，从j = 0 开始，往后遍历，同时把遍历的放入arraylist中，直到array中出现了重复的元素
//            // 然后记录本次遍历得到的合法长度
//            // 再从 j = 1开始， 然后 是 j =2 ...
//            for (int i = 0; i < s.length()-1; i++) {
//                int j = i;
//                while (hasNoDuplicates(list) && j < s.length()) {
//                    list.add(s.charAt(j));
//                    j++;
//                }
//                result = j - i - 1;
//                maxlen = Math.max(maxlen, result);
//                // 清空list
//                list.clear();
//            }
//            return maxlen;


            // 这个题目可以用滑动窗口来做
            if (s.isEmpty()) {
                return 0;
            }

            int maxLength = 0;
            int left = 0;
            int right = 0;
            Set<Character> charSet = new HashSet<>();
            while (right < s.length()) {
                if (charSet.contains(s.charAt(right))) {
                    // 如果当前字符已经存在于集合中，说明有重复字符
                    // 移动左指针，直到移除重复字符
                    charSet.remove(s.charAt(left));
                    left++;
                } else {
                    // 如果当前字符不在集合中，添加到集合中
                    charSet.add(s.charAt(right));
                    // 更新最大长度
                    maxLength = Math.max(maxLength, right - left + 1);
                    right++;
                }
            }
            return maxLength;
        }
    }


    public static <T> boolean hasNoDuplicates(ArrayList<T> list) {
        // 判断这个list中是否有重复元素
        Set<T> set = new HashSet<>(list);
        return set.size() == list.size();
    }



}
