/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode front = head.next;
            head.next = prev;
            prev = head;
            head = front;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextNode = slow.next;
        slow.next = null;
        nextNode = reverse(nextNode);
        while (head != null && nextNode != null) {
            if (head.val != nextNode.val) {
                return false;
            }
            head = head.next;
            nextNode = nextNode.next;
        }
        return true;
    }
}