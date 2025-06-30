package hash;

public class leetcode454 {

//    给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。



    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        // 还是采用哈希表的思想来解决这个问题
        // 遍历nums1和nums2，计算它们的所有可能的和，并将结果存储在哈希表中，键为和，值为出现的次数。

        java.util.HashMap<Integer, Integer> sumMap = new java.util.HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                // 注意这个map的写入方式，要先判断这个和是否已经存在于map中，如果存在，就将对应的次数加1，如果不存在，就初始化为1。
                if (sumMap.containsKey(nums1[i] + nums2[j])) {
                    sumMap.put(nums1[i] + nums2[j], sumMap.get(nums1[i] + nums2[j]) + 1);
                } else {
                    sumMap.put(nums1[i] + nums2[j], 1); // 如果不存在，就初始化为1
                }
            }
        }

        // 然后是遍历nums3和nums4，计算它们的所有可能的和，并检查这个和的相反数是否在哈希表中，如果存在，就将对应的次数累加到结果中。
        int count = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (sumMap.containsKey(-(nums3[i] + nums4[j]))) {
                    count += sumMap.get(-(nums3[i] + nums4[j])); // 如果存在，就将对应的次数累加到结果中
                }
            }
        }

        return count; // 返回结果


    }


}
