/*
DAY 24: Construct Binary Search Tree from Preorder traversal

Return the root node of a binary search tree that matches the given preorder traversal.
(Recall that a binary search tree is a binary tree where for every node,
any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day24 {
    static int i = 0;
    public static void main(String[] args) {
        int preOrder[] = new int[] {8,5,1,7,10,12};

        System.out.print("Iterative approach: ");
        inOrder(constructBSTIterative(preOrder));

        System.out.print("\nRecursive approach: ");
        inOrder(constructBSTRecursive(preOrder));

        System.out.print("\nIndex approach: ");
        inOrder(constructBSTIndex(preOrder));
    }

    public static TreeNode constructBSTIndex(int a[]) {
        if(a.length == 0) {
            return null;
        }
        return constructBST(a, 0, a.length - 1);
    }

    public static TreeNode constructBST(int a[], int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(a[start]);
        int i;
        for (i = start; i <= end; i++) {
            if (a[i] > root.val) {
                break;
            }
        }
        root.left = constructBST(a, start+1, i-1);
        root.right = constructBST(a, i, end);
        return root;
    }

    public static TreeNode constructBSTRecursive(int a[]) {
        if (a.length == 0) {
            return null;
        }
        return constructBST(a, Integer.MAX_VALUE);
    }

    public static TreeNode constructBST(int a[], int upperBound) {
        if (i == a.length || a[i] > upperBound) {
            return null;
        }

        TreeNode root = new TreeNode(a[i++]);
        root.left = constructBST(a, root.val);
        root.right = constructBST(a, upperBound);
        return root;
    }

    public static TreeNode constructBSTIterative(int a[]) {
        if (a.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(a[0]);
        for (int i = 1; i < a.length; i++) {
            constructBST(root, a[i]);
        }
        return root;
    }

    public static TreeNode constructBST(TreeNode n, int val) {
        TreeNode root = n;
        TreeNode node = new TreeNode(val);

        while (root != null) {
            if (val < root.val) {
                if (root.left == null) {
                    root.left = node;
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right == null) {
                    root.right = node;
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return n;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        inOrder(root.left);
        inOrder(root.right);
    }
}
