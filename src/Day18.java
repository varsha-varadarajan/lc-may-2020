/* DAY 24: Permutation in string
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False

SOLUTION APPROACH: Sliding Window
 */
public class Day18 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")?
                "Permutation of ab exists in eidbaooo": "Permutation of ab does not exist in eidbaooo");
        System.out.println(checkInclusion("ab", "eidboaoo")?
                "Permutation of ab exists in eidboaoo": "Permutation of ab does not exist in eidboaoo");
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() > s2.length()) {
            return false;
        }

        int[] chars = new int[256];
        for (char c: s1.toCharArray()) {
            chars[c]++;
        }

        int left = 0, right = 0, diff = s1.length();

        while (right < s2.length()) {
            chars[s2.charAt(right)]--;
            if (chars[s2.charAt(right)] >= 0) {
                diff--;
            }
            right++;

            if (diff == 0) {
                return true;
            }

            if (right - left == s1.length()) {
                if (chars[s2.charAt(left)] >= 0) {
                    diff++;
                }
                chars[s2.charAt(left)]++;
                left++;
            }
        }
        return false;
    }
}
