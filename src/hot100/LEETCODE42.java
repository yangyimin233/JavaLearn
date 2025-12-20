package hot100;

public class LEETCODE42 {


    public int trap(int[] height) {


        int MaxHeight = 0;
        int totalVolume = 0;
        // 先遍历一遍，获取最高的柱子高度以及总体积
        for (int i = 0; i < height.length; i++) {
            MaxHeight = Math.max(MaxHeight, height[i]);
            totalVolume += height[i];
        }

        // 然后 我们在一层一层地计算每一层的体积
        int total = 0;
        for (int h = 1; h <= MaxHeight;h++){

            int left = 0;
            int right = height.length - 1;

            while (height[left] < h) {
                left++;
            }
            // 最终退出时，left指向左边第一个 >= h 的位置
            while (height[right] < h) {
                right--;
            }
            // 最终退出时，right指向右边第一个 >= h 的位置
            // 所以 第i层 总体积 = (right - left + 1)

            total = total + (right - left) + 1;

        }

        return total-totalVolume;

        // 这个很好理解，但是 还不够快
        // 之后你还要去看看 双指针的解法



    }


}
