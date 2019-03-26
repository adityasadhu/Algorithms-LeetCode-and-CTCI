/*There are a total of n courses you have to take, labeled from 0 to n-1.

        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

        Example 1:

        Input: 2, [[1,0]]
        !Output: true
        Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0. So it is possible.
        Example 2:

        Input: 2, [[1,0],[0,1]]
        Output: false
        Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0, and to take course 0 you should
        also have finished course 1. So it is impossible.
        Note:

        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
        You may assume that there are no duplicate edges in the input prerequisites.
        Accepted
        195,527
        Submissions
        528,476*/

package Leetcode.TopologicalSort;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {

        System.out.println(canFinish(3, new int[][]{{1, 0}, {2, 0}}));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List[] adjacencyList = new List[numCourses];
        Queue<Integer> queue = new LinkedList();

        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][1]]++;
            adjacencyList[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i = 0; i < adjacencyList[n].size(); i++) {
                indegree[(int) adjacencyList[n].get(i)]--;
                if (indegree[(int) adjacencyList[n].get(i)] == 0) {
                    queue.offer((int) adjacencyList[n].get(i));
                }
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != 0)
                return false;
        }
        return true;
    }

}
