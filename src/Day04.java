/* DAY 4: NUMBER COMPLEMENT
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/

Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.

Example 1:
Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:
Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

Constraints:
The given integer num is guaranteed to fit within the range of a 32-bit signed integer.
num >= 1
You could assume no leading zero bit in the integer’s binary representation.
This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/

SOLUTION APPROACH:
Get LSD, flip using XOR, and convert to Base 10
*/

public class Day04 {
    public static void main(String args[]){
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
    }

    public static int findComplement(int num) {
        int pow = 0;
        int res = 0;
        while (num!=0) {
            int rem = num%2;
            int flipRem = rem^1;
            res += flipRem * Math.pow(2, pow);
            num /= 2;
            pow++;
        }
        return res;
    }
}
