/* DAY 23: INTERVAL LIST INTERSECTIONS

Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.
For example, the intersection of [1, 3] and [2, 4] is [2, 3])

SOLUTION APPROACH:

1. Get start and end of intersection interval
   a. start - max(aStart, bStart)
      end   - min(aEnd, bEnd)
   b. if (start <= end)
      add to result
   c. if (aEnd < bEnd)
        goto next element in A (because this A is not going to overlap with any further elements in B, safely discard it)
      else
        goto next element in B
   Logic in "c" works because pairs in B are disjoint

*/

import java.util.ArrayList;
import java.util.List;

public class Day23 {
    public static void main(String args[]) {
        int a[][] = new int[][] {{0,2}, {5,10}, {13,23}, {24,25}};
        int b[][] = new int[][] {{1,5}, {8,12}, {15,24}, {25,26}};

        int c[][] = new int[][] {{4, 6}, {7, 8}, {10, 17}};
        int d[][] = new int[][] {{5, 10}};
        // print2D(a);
        // print2D(b);
        int[][] result = intervalIntersection(c, d);
        print2D(result);
    }

    public static void print2D(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList();

        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);

            if (start <= end) {
                res.add(new int[] {start, end});
            }

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}
