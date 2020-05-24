/* DAY 13: REMOVE K DIGITS
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

SOLUTION APPROACH: Monotonically increasing stack
 */
public class Day13 {
    public static void main(String args[]) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < num.length()) {
            char curr = num.charAt(i);
            while (k>0 && sb.length() > 0 && sb.charAt(sb.length()-1) > curr) {
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            if (sb.length() == 0 && curr == '0') {
                i++;
                continue;
            }
            sb.append(curr);
            i++;
        }
        while (k > 0) {
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
