/*
 * @created 28/05/2020 - 10:50
 * @project May2020
 * @author Varsha Varadarajan
 *
 * Day 28 : Counting Bits
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 * Example 1:
 * Input: 2
 * Output: [0,1,1]

 * Example 2:
 * Input: 5
 * Output: [0,1,1,2,1,2]
 *
 * Solution Approach: Think DP - O(n) time and O(n) space complexity
 */
public class Day28 {
    public static void main(String[] args) {
        print1DArray(countBits(5));
    }

    public static void print1DArray(int[] a) {
        for (int i = 0; i < a.length; i ++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int[] countBits(int num) {
        int[] ones = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            /*
            if (i % 2 == 1) {
                ones[i] = ones[i >> 1] + 1;
            } else {
                ones[i] = ones[i >> 1];
            }
            */

            ones[i] = ones[i >> 1] + (i & 1);
        }

        return ones;
    }
}
