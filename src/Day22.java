import java.util.HashMap;

/* Day 23: Sort Characters By Frequency
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:
Input:
"tree"
Output:
"eert"
Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input:
"cccaaa"
Output:
"cccaaa"
Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input:
"Aabb"
Output:
"bbAa"
Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

SOLUTION APPROACH: Buckets
 */
public class Day22 {
    public static void main(String[] args) {
        System.out.println("Frequency sort");
        System.out.println("tree -> " + frequencySort("tree"));
        System.out.println("cccaaa -> " + frequencySort("cccaaa"));
        System.out.println("Aabb -> " + frequencySort("Aabb"));
    }
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int max = 0;

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }

        StringBuilder[] bucket = new StringBuilder[max+1];

        for (char key: map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new StringBuilder();
            for (int i = 0; i < frequency; i++) {
                bucket[frequency].append(key);
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = bucket.length - 1; i >= 1; i--) {
            if (bucket[i] != null)
                result.append(bucket[i]);
        }
        return result.toString();
    }
}
