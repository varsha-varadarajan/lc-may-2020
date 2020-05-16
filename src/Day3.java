/* DAY 3: RANSOM NOTE
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:
You may assume that both strings contain only lowercase letters.

SOLUTION APPROACH:
Hash character and count in Magazine
For every character in RansomNote, use characters from Magazine hash
If you run out, return false
*/

import java.util.HashMap;

public class Day3 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap mag = new HashMap<Character, Integer>();
        for (int i=0; i<magazine.length(); i++) {
            char curr = magazine.charAt(i);
            if (mag.containsKey(curr)) {
                int count = (int)mag.get(curr);
                mag.replace(curr, count+1);
            } else {
                mag.put(curr, 1);
            }
        }

        int i = 0;
        while(i<ransomNote.length()) {
            char curr = ransomNote.charAt(i);

            if (mag.containsKey(curr)) {
                int count = (int)mag.get(curr);
                if ((count-1) < 0) {
                    break;
                } else {
                    mag.replace(curr, count-1);
                }
            } else {
                break;
            }
            i++;
        }

        if (i == ransomNote.length()) {
            return true;
        } else {
            return false;
        }
    }
}
