package hot100;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class LEETCODE406 {

    public int[][] reconstructQueue(int[][] people) {


//        排序完的people：
//        [[7,0], [7,1], [6,1], [5,0], [5,2]，[4,4]]
//
//        插入的过程：
//
//        插入[7,0]：[[7,0]]
//        插入[7,1]：[[7,0],[7,1]]
//        插入[6,1]：[[7,0],[6,1],[7,1]]
//        插入[5,0]：[[5,0],[7,0],[6,1],[7,1]]
//        插入[5,2]：[[5,0],[7,0],[5,2],[6,1],[7,1]]
//        插入[4,4]：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]


        // 首先根据 int[][0] （身高排序），身高相同的， int[][1] (index小)的排前面
        // 用什么来装这个排序后的结果？
        // 先用 数组来装，这样冒泡比较好写

        for (int i = 0; i < people.length; i++) {

            // 从people[0] 开始依次冒泡，
            // people[0] 跟 people[1] 比较，然后1跟2比较 ，身高小的放后面

            for (int j = 0; j < people.length - i ; j++) {

                if ((people[j][0] < people[j+1][0]) ||  (people[j][0] == people[j+1][0] && people[j][1] > people[j+1][1])) {
                    // 交换
                    int temp = people[j][0];
                    int temp2 = people[j][1];
                    people[j][0] = people[j+1][0];
                    people[j][1] = people[j+1][1];
                    people[j+1][0] = temp;
                    people[j+1][1] = temp2;

                }

            }

        }

        // 然后现在数组排序后就长这样了，开始插入


        //        排序完的people：
        //        [[7,0], [7,1], [6,1], [5,0], [5,2]，[4,4]]
        //
        //        插入的过程：
        //
        //        插入[7,0]：[[7,0]]
        //        插入[7,1]：[[7,0],[7,1]]
        //        插入[6,1]：[[7,0],[6,1],[7,1]]
        //        插入[5,0]：[[5,0],[7,0],[6,1],[7,1]]
        //        插入[5,2]：[[5,0],[7,0],[5,2],[6,1],[7,1]]
        //        插入[4,4]：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]


        // 用List来存储结果，插入操作方便
        List<int[]> result = new ArrayList<>();

        // 按照排序后的顺序插入
        for (int[] person : people) {
            result.add(person[1], person); // 将每个人插入到合适的位置
        }

        // 将List转换为数组并返回
        return result.toArray(new int[people.length][2]);




    }


}
