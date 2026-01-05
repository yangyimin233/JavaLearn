package hot100;

import java.util.*;

public class LEETCODE207 {

//    你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
//    在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
//
//    例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//    请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。



    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 思路
        // 将prerequisites转化为邻接表
        // eg : prerequisites = 【
        // [1，0]
        // [1,2]
        // [2,0]
        // 】

        // 这个表示 学习 课程1 需要先学课程 0 和2
        // 学习课程 2 需要先学课程 0
        // 所以这个肯定是可以学的

        // 邻接表List<List<int>>  表示 该有向图
        // 有向图中 a指向b 表示要先 学a才能学b

        // 然后我们再创建一个入度数组，入度为0 ，也就是说该课程没有前置

        // 然后我们可以创建一个队列，队列里面就放 所有入度为0 的课程
        // 然后每次取出该队列里面的一个数 (因为队列里面的课程一定是 可以完成的)，维护visited++
        // 比如 这时候取了0 出来
        // 从有向图 中 依次访问 需要 0 的课程i，并且给对应的 入度数组[i]--
        // 如果课程i 的入度归零了，这时候说明 i也可以修了，给i也入队
        // 直到访问完 队列中的所有课程，如果visited == nums ，则返回可行

        // 有向图
        List<List<Integer>> graph = new ArrayList<>();
        // 这里空链表要先创好
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 入度数组
        int[] inCourses = new int[numCourses];

        // 创建有向图和入度数组
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prep = prerequisites[i][1];

            // 入度数组++ ，也就是前置++
            inCourses[prep]++;
            // 有向图 course 作为节点，指向节点 prep
            graph.get(course).add(prep);
        }

        // 创建队列
        Deque<Integer> queue = new ArrayDeque<>();
        int visited = 0;

        // 把所有入度为0的节点入队
        for (int i = 0; i < numCourses; i++) {
            if (inCourses[i] == 0) {
                queue.offer(i);
            }
        }

        // 然后开始拓扑排序
        while (!queue.isEmpty()) {

            // 弹出当前 可以修的课程
            int cur = queue.poll();
            visited++;
            // 然后修了 cur 课程，并且 处理 其他所有依赖这个课程的 课程(入度减一)
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                inCourses[next]--;
                if(inCourses[next] == 0){
                    // 说明涉及到的next 课程 也进入了可以修的状态
                    queue.offer(next);
                }
            }

        }

        return visited == numCourses;


    }


}
