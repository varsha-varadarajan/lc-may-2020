/* Day 20: Kth Smallest Element in a BST
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Input: root = [3,1,4,null,2], k = 1
Output: 1

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

 */
public class Day20 {
    public static void main(String[] args) {
        // assume Tree is constructed
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] nums = new int[2];
        inorder(root, k, nums);
        return nums[1];
    }

    public static void inorder(TreeNode node, int k, int[] nums) {
        if (node == null) {
            return;
        }

        inorder(node.left, k, nums);

        if (++nums[0] == k) {
            nums[1] = node.val;
            return;
        }

        inorder(node.right, k, nums);
    }
}
