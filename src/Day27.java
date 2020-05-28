import java.util.LinkedList;
import java.util.Queue;

/*
 * @created 27/05/2020 - 07:58
 * @project May2020
 * @author Varsha Varadarajan
 */

/* DAY 27 : Possible Bipartition
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
Each person may dislike some other people, and they should not go into the same group.
Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
Return true if and only if it is possible to split everyone into two groups in this way.

Example 1:
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]

Example 2:
Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false

Example 3:
Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 */
public class Day27 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(possibleBipartition(4, new int[][] {{1,2},{1,3},{2,4}}));
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(possibleBipartitionLeastTime(4, new int[][] {{1,2},{1,3},{2,4}}));
        end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes.length == 0) {
            return true;
        }

        if (dislikes[0].length == 0) {
            return false;
        }

        int[][] graph = new int[N+1][N+1];

        for (int i = 0; i < dislikes.length; i++) {
            int node1 = dislikes[i][0];
            int node2 = dislikes[i][1];

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        int[] color = new int[N+1];
        for (int i = 0; i <= N; i++) {
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList();

        for (int j = 1; j <= N; j++) {
            if (color[j] == -1) {
                color[j] = 1;
                q.add(j);

                // having only q.isEmpty() as in soln of VJTI notes doesn't work for example
                // [1,2] [3,4]
                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int i = 1; i <= N; i++) {
                        if (graph[node][i] == 1) {
                            if (color[i] == -1) {
                                color[i] = 1 - color[node];
                                q.add(i);
                            } else if (color[i] == color[node]) {
                                // System.out.println(i + " - " + node);
                                // System.out.println(color[i] + " - " + color[node]);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    // union found split two group
    // GroupA : all hate b, GroupB: all hate a;
    // Solution from Leetcode submissions
    public static boolean possibleBipartitionLeastTime(int N, int[][] dislikes) {
        int[] group = new int[N+1];
        for (int i = 0; i <= N; i++) {
            group[i] = i; // initial
        }

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];

            if (group[a] == a && group[b] == b) {
                group[a] = b;
                group[b] = a;
            } else if (group[a] == a && group[b] != b) {
                // let a go to group that all hate b;
                group[a] = group[group[b]];
            } else if (group[b] ==b && group[a] != a) {
                group[b] = group[group[a]];
            } else if (group[b] == group[a]) {
                return false;
            }
        }
        return true;
    }
}
