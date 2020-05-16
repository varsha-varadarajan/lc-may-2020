/* DAY 16: ODD EVEN LINKED LIST
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

Note:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Day16 {
    public static void main(String[] args) {
        System.out.println("Even nodes");
        ListNode head = createList(new int[] {1,2,3,4,5,6});
        printList(head);
        ListNode newHead = oddEvenList(head);
        printList(newHead);

        System.out.println("Odd nodes");
        head = createList(new int[] {1,2,3,4,5});
        printList(head);
        newHead = oddEvenList(head);
        printList(newHead);

        System.out.println("One node");
        head = createList(new int[] {1});
        printList(head);
        newHead = oddEvenList(head);
        printList(newHead);

        System.out.println("Empty node");
        head = createList(new int[] {});
        printList(head);
        newHead = oddEvenList(head);
        printList(newHead);
    }

    public static ListNode createList(int[] a) {
        ListNode head = null;
        if (a.length > 0) {
            head = new ListNode(a[0], null);
            ListNode prev = head;
            for (int i=1; i< a.length; i++) {
                ListNode node = new ListNode(a[i], null);
                prev.next = node;
                prev = prev.next;
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode evenHead = odd.next;
        ListNode even = evenHead;

        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            if (odd.next != null) {
                odd = odd.next;
            }
            even.next = even.next.next;
            if (even.next != null) {
                even = even.next;
            }
        }

        even.next = null;
        odd.next = evenHead;

        return head;
    }
}
