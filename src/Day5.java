/* DAY 5: FIRST UNIQUE CHARACTER IN A STRING
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

SOLUTION APPROACH:
1st traversal - maintain HashMap of Character-Count
2nd traversal - return first character with count 1
*/

import java.util.HashMap;
public class Day5 {
    public static void main(String[] args) {
        System.out.println("First unique character index in " + "leetcode: " + firstUniqChar("leetcode"));
        System.out.println("First unique character index in " + "loveleetcode: " + firstUniqChar("loveleetcode"));
    }
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (int i=0; i<s.length(); i++) {
            if ((int)countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}