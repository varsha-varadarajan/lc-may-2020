import java.util.ArrayList;
import java.util.List;

/* DAY 17: Find All Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Solution approach: Sliding window
 */
public class Day17 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        if (s == null || p.length() > s.length() || s.length() == 0) {
            return result;
        }
        int[] pArr = new int[26];

        for (char c: p.toCharArray()) {
            pArr[c-'a']++;
        }
        int left = 0, right = 0, diff = p.length();

        while (right < s.length()) {
            pArr[s.charAt(right) - 'a']--;
            if (pArr[s.charAt(right) - 'a'] >= 0) {
                diff--;
            }
            right++;

            if (diff == 0) {
                result.add(left);
            }

            if (right - left == p.length()) {
                if (pArr[s.charAt(left) - 'a'] >= 0) {
                    diff++;
                }
                pArr[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return result;
    }
}
