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
    
    public int countNodes(ListNode head) {
        int count = 0;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        return count + 1;
    }
    
    public ListNode middleNode(ListNode head) {
        int mid = (int) Math.floor(countNodes(head) / 2);
        while (mid-- != 0) head = head.next;
        return head;
    }
}