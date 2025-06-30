package hash;

public class leetcode26 {

//    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
//    1 <= s.length, t.length <= 5 * 104
//    s 和 t 仅包含小写字母





    public boolean isAnagram(String s, String t) {

        // 我觉得这个也不难啊很容易想到嘛，s遍历一遍，建立一个数组，记录每个字母出现的次数，然后t也遍历一遍，减去对应的字母出现的次数，最后看数组是否全为0即可

        int [] count = new int[26]; // 记录每个字母出现的次数，假设只包含小写字母

        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;   // 就是这个数组的index的记录方法要晓得就行了
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false; // 如果有一个字母的出现次数不为0，说明不是字母异位词
            }
        }
        return true;

    }

}
