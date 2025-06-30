package shuzhu;

public class hebingshuzhu {


    // 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 7, 9, 11};
        int[] nums2 = {2, 5, 6, 8, 10, 12};



        // 就直接写在这里吧

        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0; // nums1索引
        int index2 = 0; // nums2索引
        int[] merged = new int[len1 + len2]; // 合并后的数组
        // int indexMerged = 0; // 合并后的数组索引


        // 这种合并还是很常见的，反正思路就是，两个数组分别设置一个指针，然后根据条件放进result
        // 注意，判断条件放入前要先考虑是否有数组已经遍历完了
        for (int indexMerged = 0; indexMerged < len1+len2; indexMerged++) {

            if (index1 >= len1){
                // 数组1已经遍历完了
                merged[indexMerged] = nums2[index2];
                index2++;
            } else if (index2 >= len2) {
                // 数组2已经遍历完了
                merged[indexMerged] = nums1[index1];
                index1++;
            }  else {
              // 否则就说明1 2 都没遍历完
                if (nums1[index1] <= nums2[index2]) {
                    // 1的比较小，把1的放进去，然后index1++
                    merged[indexMerged] = nums1[index1];
                    index1++;
                } else {
                    // 2的比较小，把2的放进去，然后index2++
                    merged[indexMerged] = nums2[index2];
                    index2++;
                }
            }

        }

        // 输出合并后的数组
        System.out.print("合并后的数组为：");
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i] + " ");
        }



    }





}
