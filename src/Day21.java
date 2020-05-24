/* DAY 21: Count Square Submatrices with All Ones
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:
Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

Example 2:
Input: matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation:
There are 6 squares of side 1.
There is 1 square of side 2.
Total number of squares = 6 + 1 = 7.
 */

public class Day21 {
    public static void main(String[] args) {
        int a[][] = new int[][] {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        System.out.println(countSquares(a));

        int b[][] = new int[][] {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(countSquares(b));
    }
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    continue;
                if (i == 0 || j == 0) {
                    result++;
                    continue;
                }
                int min = Math.min(matrix[i-1][j-1],
                        Math.min(matrix[i-1][j], matrix[i][j-1]));
                matrix[i][j] += min;
                result += matrix[i][j];
            }
        }

        return result;
    }
}
