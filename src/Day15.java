/* DAY 15: MAXIMUM SUM CIRCULAR SUB-ARRAY
Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)

Example 1:
Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3

Example 2:
Input: [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10

Example 3:
Input: [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4

Example 4:
Input: [3,-2,2,-3]
Output: 3
Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3

Example 5:
Input: [-2,-3,-1]
Output: -1
Explanation: Subarray [-1] has maximum sum -1

Note:
-30000 <= A[i] <= 30000
1 <= A.length <= 30000

SOLUTION APPROACH:
Kadane's algo for max sub-array sum
For circular max sum, get total sum, get non-contributing elements sum
Subtract non-contributing sum from total sum
Alternatively, invert array, get sum and add to total sum
Max of Kadane(A) & Kadane(-A)+TotalSum(A)
Corner case - if all negative elements, then Kadane(A) will be -ve and hence return Kadane(A)
*/

class Day15 {

    public static void main(String args[]) {
        System.out.println(maxSubarraySumCircular(new int[] {5, -3, 5}));
        System.out.println(maxSubarraySumCircular(new int[] {-5, -3, -2}));
    }

    public static int kadane(int[] A) {
        int globalMax = A[0];
        int maxEndingHere = A[0];

        for (int i=1; i<A.length; i++) {
            maxEndingHere = Math.max(A[i], A[i] + maxEndingHere);
            globalMax = Math.max(maxEndingHere, globalMax);
        }

        return globalMax;
    }

    public static int maxSubarraySumCircular(int[] A) {
        int nonWrapMax = kadane(A);

        // corner case - all elements are negative
        if (nonWrapMax < 0) {
            return nonWrapMax;
        }

        // invert all elements in array
        // and calculate total max
        int totalMax = 0;
        for (int i=0; i<A.length; i++) {
            totalMax += A[i];
            A[i] = -A[i];
        }

        int wrapMax = totalMax + kadane(A);
        return Math.max(nonWrapMax, wrapMax);
    }
}
