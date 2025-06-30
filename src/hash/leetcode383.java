package hash;

public class leetcode383 {

//    给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//    如果可以，返回 true ；否则返回 false 。
//    magazine 中的每个字符只能在 ransomNote 中使用一次。

    public boolean canConstruct(String ransomNote, String magazine) {

        // 思路，是遍历ransomNote，存到一个数组里面，然后再遍历magazine每个字母，如果ransomNote里面对应字母的value>0则-1，否则继续往下，最后看数组是否全为0
        //        ransomNote 和 magazine 由小写英文字母组成
        // 所以可以用一个长度为26的数组来记录每个字母出现的次数
        int[] count = new int[26]; // 记录每个字母出现的次数，假设只包含小写字母
        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i) - 'a']++;   // 就是这个数组的index的记录方法很常见哦
        }
        // 遍历magazine，减去对应的字母出现的次数
        for (int i = 0; i < magazine.length(); i++) {
            if (count[magazine.charAt(i) - 'a'] > 0) {
                count[magazine.charAt(i) - 'a']--;
            }
        }

        // 最后看数组是否全为0
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                return false; // 如果有一个字母的出现次数不为0，说明不能构成
            }
        }
        // 如果所有字母的出现次数都为0，说明可以构成
        return true;
    }



}
