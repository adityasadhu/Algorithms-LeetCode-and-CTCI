//There are a total of n courses you have to take, labeled from 0 to n-1.
//
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//        There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//        Example 1:
//
//        Input: 2, [[1,0]]
//        Output: [0,1]
//        Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
//        course 0. So the correct course order is [0,1] .
//        Example 2:
//
//        Input: 4, [[1,0],[2,0],[3,1],[3,2]]
//        Output: [0,1,2,3] or [0,2,1,3]
//        Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
//        courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
//        So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
//        Note:
//
//        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//        You may assume that there are no duplicate edges in the input prerequisites.

package Leetcode.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        List[] adjacencyList = new List[numCourses];
        Queue<Integer> queue = new LinkedList();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            adjacencyList[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                result.add(i);
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i = 0; i < adjacencyList[n].size(); i++) {
                indegree[(int) adjacencyList[n].get(i)]--;
                if (indegree[(int) adjacencyList[n].get(i)] == 0) {
                    queue.offer((int) adjacencyList[n].get(i));
                    result.add((int) adjacencyList[n].get(i));
                }
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != 0)
                return new int[0];
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {


        findOrder(2, new int[][]{{1, 0}});
    }
}
