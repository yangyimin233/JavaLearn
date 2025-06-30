package hash;

public class leetcode349 {

//    题意：给定两个数组，编写一个函数来计算它们的交集。

//    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    输出：[9,4]
//    解释：[4,9] 也是可通过的

    public int[] intersection(int[] nums1, int[] nums2) {
        // 先说最笨的方法，遍历num1的每一个元素，每遍历一个元素，就遍历num2的每一个元素，看看是否存在，如果存在就添加到结果集中，这个时间复杂度是O(n^2)，不太好

        // 那仿照上面的leetcode26，我们还是用数组来处理一下这个问题

        // 题目给了nums1和nums2的元素都是 <= 1000
//        int[] count = new int[1001]; // 记录nums1中每个元素出现的次数
//        for (int i = 0; i < nums1.length; i++) {
//            count[nums1[i]]++; // 统计nums1中每个元素出现的次数
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            if (count[nums2[i]] > 0) {
//                count[nums2[i]] = -1; // 标记为-1，表示已经添加到结果集中，避免重复添加
//            }
//        }
//        // 现在我们来统计结果集的大小
//        int size = 0;
//        for (int i = 0; i < count.length; i++) {
//            if (count[i] == -1) {
//                size++; // 统计结果集的大小
//            }
//        }
//        // 然后我们来创建结果集
//        int[] result = new int[size];
//        int index = 0;
//        for (int i = 0; i < count.length; i++) {
//            if (count[i] == -1) {
//                result[index++] = i; // 将结果集中的元素添加到结果数组中
//            }
//        }
//        return result; // 返回结果数组


        // 但是上面这种，你看1是的要求数组元素都是<=1000的，这样我们才能创建一个长度已知的count数组
        // 然后count里面 重复元素对应的index位置即使-1标记了，我们还需要一个循环来统计有多少个，这样才能创建最终的re数组

        // 所以我们可以用一个set来处理一下，这样就不用考虑重复元素的问题了

        java.util.Set<Integer> set = new java.util.HashSet<>();
        java.util.Set<Integer> resultSet = new java.util.HashSet<>();
        // 首先将nums1中的元素添加到set中
        for (int num : nums1) {
            set.add(num);
        }
        // 然后遍历nums2，如果nums2中的元素在set中存在，就添加到resultSet中
        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num); // 添加到结果集
            }
        }
        // 最后将resultSet转换为数组并返回
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num; // 将结果集中的元素添加到结果数组中
        }
        return result;

    }

}
