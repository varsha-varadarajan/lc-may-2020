import java.util.HashMap;

/*
 * @created 26/05/2020 - 11:37
 * @project May2020
 * @author Varsha Varadarajan
 */

/* Day 26 : Contiguous Array
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000.
 */
public class Day26 {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[] {0,1,0}));
        System.out.println(findMaxLengthOfSumK(new int[] {0,1,0}, 1));
        System.out.println(findNumberOfSubarraysWithSumK(new int[] {1,1,1}, 2));
    }

    public static int findMaxLength(int[] nums) {
        int result = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);

        // right - left = k, here k = 0, thus, left = right, rename it to sum
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                result = Math.max(result, i - map.get(sum));
            }
            map.putIfAbsent(sum, i);
        }

        return result;
    }

    public static int findMaxLengthOfSumK(int[] nums, int k) {
        int result = 0;
        int right = 0;

        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            int left = right - k;

            if (map.containsKey(left)) {
                result= Math.max(result, i - map.get(left));
            }
            // put gives wrong result
            map.putIfAbsent(right, i);
        }
        return result;
    }

    public static int findNumberOfSubarraysWithSumK(int[] nums, int k) {
        int result = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum-k)) {
                result += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
